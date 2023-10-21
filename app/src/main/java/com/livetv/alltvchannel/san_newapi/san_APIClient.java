package com.livetv.alltvchannel.san_newapi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class san_APIClient {

    private static Retrofit retrofit = null;
    private static Retrofit retrofitCountry = null;

    public static Retrofit getClient() {

        OkHttpClient client = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://phpstack-1046237-3752222.cloudwaysapps.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }


}