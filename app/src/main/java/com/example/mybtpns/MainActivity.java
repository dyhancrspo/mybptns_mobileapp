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
import com.example.mybtpns.model.APIResponse;
import com.example.mybtpns.viewmodel.AppViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppViewModel appViewModel;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();


        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogout();
            }
        });

        binding.bottomnav.setSelectedItemId(R.id.home);
        binding.bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mutasi:
                        startActivity(new Intent(getApplicationContext(), MutasiActivity.class));
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.pulsa:
                        startActivity(new Intent(getApplicationContext(), PulsaActivity.class));
                        overridePendingTransition(1,1);
                        return true;
                    case R.id.home:
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
        binding.etNama.setText(username);



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
                binding.currentSaldo.setText(kurs.format(saldo));
            }
        });
    }


    private void doLogout() {
        appViewModel.logoutNasabah().observe(this, nasabahsResponse -> {
            System.out.println("logout response : " + nasabahsResponse.getMessage());
            APIResponse response = nasabahsResponse;
            if (response.getResponse() == 200) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}