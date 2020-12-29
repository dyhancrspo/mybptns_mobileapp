package com.example.mybtpns.networking;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/api/mybtpns/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
//            .baseUrl("http://192.168.43.4:8080/dummybank/api/")

    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}



