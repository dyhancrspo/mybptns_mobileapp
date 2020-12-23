package com.example.mybtpns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mybtpns.databinding.ActivityLoginBinding;
import com.example.mybtpns.databinding.ActivityRegisterBinding;
import com.example.mybtpns.model.APIResponse;
import com.example.mybtpns.model.RegisterModel;
import com.example.mybtpns.viewmodel.AppViewModel;

public class RegisterActivity extends AppCompatActivity {

    private AppViewModel appViewModel;
    private ActivityRegisterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();


        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        binding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initView() {
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        appViewModel.init();
    }

    private void doRegister() {
        String fullname = binding.etRegistNama.getText().toString();
        String accountnumber = binding.etRegistNorek.getText().toString();
        String address = binding.etRegistAlamat.getText().toString();
        String phonenumber = binding.etRegistNotelp.getText().toString();
        String username = binding.etRegistUsername.getText().toString();
        String password = binding.etRegistPassword.getText().toString();

        if (fullname.equals("")&&accountnumber.equals("")&&address.equals("")&&phonenumber.equals("")&&username.equals("")&&password.equals("")) {
            Toast.makeText(getApplicationContext(),"Mohon Lengkapi Data Registrasi", Toast.LENGTH_SHORT).show();
        } else {
            RegisterModel registerModel = new RegisterModel(fullname, accountnumber, address, phonenumber, username, password);
            appViewModel.registerNasabah(registerModel).observe(this, nasabahsResponse -> {
                System.out.println("register response : " + nasabahsResponse.getMessage());
                APIResponse response = nasabahsResponse;
                if (response.getResponse() == 200) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

}