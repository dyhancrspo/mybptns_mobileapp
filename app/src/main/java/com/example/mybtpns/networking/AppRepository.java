package com.example.mybtpns.networking;

import androidx.lifecycle.MutableLiveData;


import com.example.mybtpns.model.APIResponse;
import com.example.mybtpns.model.LoginModel;
import com.example.mybtpns.model.RegisterModel;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private static AppRepository appRepository;

    public static AppRepository getInstance(){
        if (appRepository == null){
            appRepository = new AppRepository();
        }
        return appRepository;
    }

    private RestAPI RestAPI;

    public AppRepository(){
        RestAPI =RetrofitService.createService(RestAPI.class);
    }


    public MutableLiveData<APIResponse> loginNasabah(LoginModel loginModel){
        String request = new Gson().toJson(loginModel);
        System.out.println("request : " + request);
        MutableLiveData<APIResponse> response = new MutableLiveData<>();
        RestAPI.loginNasabah(loginModel).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> responses) {
                response.setValue(responses.body());
                System.out.println("test : " + responses.body());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                System.out.println("Error login ");
            }
        });
        return response;
    }

    public MutableLiveData<APIResponse> logoutNasabah(){
        System.out.println("request : Logout ");
        MutableLiveData<APIResponse> response = new MutableLiveData<>();
        RestAPI.logoutNasabah().enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> responses) {
                response.setValue(responses.body());
                System.out.println("test : " + responses.body());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                System.out.println("Error logout");
            }
        });
        return response;
    }

    public MutableLiveData<APIResponse> registerNasabah(RegisterModel registerModel){
        String request = new Gson().toJson(registerModel);
        System.out.println("request : " + request);
        MutableLiveData<APIResponse> regisresponse = new MutableLiveData<>();
        RestAPI.registerNasabah(registerModel).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> responses) {
                regisresponse.setValue(responses.body());
                System.out.println("register : " + responses.body());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                System.out.println("Error register ");
            }
        });
        return regisresponse;
    }

    public MutableLiveData<APIResponse> getSaldo(String string){
        MutableLiveData<APIResponse> saldoRequest = new MutableLiveData<>();
        RestAPI.getSaldo(string).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                saldoRequest.setValue(response.body());
                System.out.println("Get Saldo");
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                saldoRequest.setValue(null);
            }
        });
        return saldoRequest;
    }

    public MutableLiveData<APIResponse> getNasabah(String string){
        MutableLiveData<APIResponse> nasabahRequest = new MutableLiveData<>();
        RestAPI.getSaldo(string).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                nasabahRequest.setValue(response.body());
                System.out.println("Get Nasabah");
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                nasabahRequest.setValue(null);
            }
        });
        return nasabahRequest;
    }

    public MutableLiveData<APIResponse> getMutasi(String string){
        MutableLiveData<APIResponse> nasabahRequest = new MutableLiveData<>();
        RestAPI.getSaldo(string).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                nasabahRequest.setValue(response.body());
                System.out.println("Get Nasabah");
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                nasabahRequest.setValue(null);
            }
        });
        return nasabahRequest;
    }



}
