package com.livetv.alltvchannel.san_pd__Exc;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class san_x_Clinet {

    public static final String BASE_URL = "http://ip-api.com/";

    public static san_x_Serc getGeoApiService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(san_x_Serc.class);
    }

}
