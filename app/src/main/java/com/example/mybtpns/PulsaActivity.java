package com.example.mybtpns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mybtpns.databinding.ActivityMainBinding;
import com.example.mybtpns.databinding.ActivityPulsaBinding;
import com.example.mybtpns.model.APIResponse;
import com.example.mybtpns.viewmodel.AppViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PulsaActivity extends AppCompatActivity {

    private ActivityPulsaBinding binding;
    private AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPulsaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();

        binding.bottomnav.setSelectedItemId(R.id.pulsa);
        binding.bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mutasi:
                        startActivity(new Intent(getApplicationContext(), MutasiActivity.class));
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.pulsa:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(1,1);
                        return true;
                }
                return false;
            }
        });
    }


    private void init(){
        //  Account balance Info
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        appViewModel.init();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.mybtpns.login", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("com.example.mybtpns.login", "");
        System.out.println("Username : " + username);
        binding.etPulsaNama.setText(username);



        appViewModel.getSaldo(username).observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
                formatRp.setCurrencySymbol("");
                formatRp.setMonetaryDecimalSeparator(',');
                formatRp.setGroupingSeparator('.');
                kurs.setDecimalFormatSymbols(formatRp);
                Double saldo = Double.parseDouble(apiResponse.getMessage());
                binding.pulsaCurrentSaldo.setText(kurs.format(saldo));
            }
        });
    }
}