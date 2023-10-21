package com.livetv.alltvchannel.san_LiveChannel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("tv/get_b_guide_v1.php")
    Call<TVMainModel> GetData(@Query("mode") String str);
}
