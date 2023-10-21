package com.livetv.alltvchannel.san_pd__Exc;

import retrofit2.Call;
import retrofit2.http.GET;

public interface san_x_Serc {
    @GET("json")
    Call<san_d_Ex_Res> getLocation();
}