package com.example.mybtpns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mybtpns.databinding.ActivityLoginBinding;
import com.example.mybtpns.databinding.ActivityMutasiBinding;
import com.example.mybtpns.viewmodel.AppViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MutasiActivity extends AppCompatActivity {

    private ActivityMutasiBinding binding;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMutasiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//--------------------   Bottom Navigation   -----------------------------
        binding.bottomnav.setSelectedItemId(R.id.mutasi);
        binding.bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mutasi:
                        return true;
                    case R.id.pulsa:
                        startActivity(new Intent(getApplicationContext(), PulsaActivity.class));
                        overridePendingTransition(1, 1);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(1, 1);
                        return true;
                }
                return false;
            }
        });

    }
}