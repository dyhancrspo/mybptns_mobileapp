package com.example.mybtpns.networking;

import com.example.mybtpns.model.APIResponse;
import com.example.mybtpns.model.LoginModel;
import com.example.mybtpns.model.RegisterModel;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestAPI {

    @POST("login/")
    Call<APIResponse> loginNasabah(@Body LoginModel body);

    @POST("register")
    Call<APIResponse> registerNasabah(@Body RegisterModel body);

    @GET("saldo/{username}")
    Call<APIResponse> getSaldo(@Path("username")String checkSaldo);

    @GET("nasabah/{username}")
    Call<APIResponse> getNasabah(@Path("username")String dataUser);

    @GET("mutasi/{accountnumber}")
    Call<APIResponse> getMutasi(@Path("accountnumber") String norek);

    @GET("logout/")
    Call<APIResponse> logoutNasabah();

}
