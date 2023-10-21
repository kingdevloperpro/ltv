package com.livetv.alltvchannel.san_Speed__Rf;


import com.livetv.alltvchannel.san_Data.san_ed__Loan_Santa;
import com.livetv.alltvchannel.san_Data.san_ied__Loan_PJ;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface san_wo_Loan_UI {
    @GET("sank/live_tv/ds2d1s5ds/Api_V1.json")
    Call<ArrayList<san_ed__Loan_Santa>> getRandomApps();

    @GET("sank/live_tv/ds2d1s5ds/Api_V1.json")
    Call<san_ied__Loan_PJ> getSdkData();

}