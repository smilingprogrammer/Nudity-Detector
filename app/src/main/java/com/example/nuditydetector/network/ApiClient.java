package com.example.nuditydetector.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://testphasenew.herokuapp.com/apidocs/?fbclid=IwAR09zUgERThg2213nGs0yGYbs0pzewL2XOx7H8lWcpET8hq-5mI7m39r_ho#/default";

    public static Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();
        return retrofit;
    }
}
