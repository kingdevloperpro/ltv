package com.livetv.alltvchannel.san_SplashExit;

import static com.livetv.alltvchannel.san_pd__Exc.san_x_Clinet.getGeoApiService;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.livetv.alltvchannel.san_Data.san_d__Loan_Arr;
import com.livetv.alltvchannel.san_Data.san_ed_Loan_App_Var;
import com.livetv.alltvchannel.san_Data.san_ed_Loan_St;
import com.livetv.alltvchannel.san_Data.san_ied__Loan_PJ;
import com.livetv.alltvchannel.R;
import com.livetv.alltvchannel.san_pd__Exc.san_d_Ex_Res;
import com.livetv.alltvchannel.san_pd__Exc.san_x_Serc;
import com.livetv.alltvchannel.san_Speed__Rf.san_o_Loan_Api;
import com.livetv.alltvchannel.san_Speed__Rf.san_wo_Loan_UI;
import com.livetv.alltvchannel.san_ed__Manager.san_fd_n_LNGG;
import com.livetv.alltvchannel.san_ed__Manager.san_ird__Loan_ST;
import com.livetv.alltvchannel.san_ed__Manager.sand_Loan_PR;
import com.livetv.alltvchannel.san_ed__Manager.san_ned_Bhasha;
import com.livetv.alltvchannel.san_ed__Manager.sanaid_oan_PK;
import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;
import com.speed.loan.mukesh_ads.Speed_Android_Main_Pref;
import com.speed.loan.mukesh_ads.Speed_Android_Sp_OP_Ad;
import com.speed.loan.mukesh_ads.san_Android_Int_Cls;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    public static Class activity_X;
    public boolean excludeChecker = false;
    public boolean includeChecker = false;
    List<san_ed_Loan_App_Var> mVar = new ArrayList<>();
    Speed_Android_Main_Pref transMainPref;
    //verify
    String iType = "";
    int normal_Index = 0;
    int publisher_Index = 1;

    AlertDialog.Builder builder1;
    AlertDialog.Builder builder2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.san_activity_splash);
        transMainPref = new Speed_Android_Main_Pref(this);


        if (isNetworkConnected()) {
            san_wo_Loan_UI specialApiInterface = san_o_Loan_Api.getClient().create(san_wo_Loan_UI.class);
            Call<san_ied__Loan_PJ> call = specialApiInterface.getSdkData();
            call.enqueue(new Callback<san_ied__Loan_PJ>() {
                @Override
                public void onResponse(Call<san_ied__Loan_PJ> call, Response<san_ied__Loan_PJ> response) {

                    mVar = response.body().getAppVariables();

                    san_ed_Loan_St app_SFLoanSt = response.body().getSettings();
                    iType = app_SFLoanSt.getLocType();

                    if (iType.equalsIgnoreCase("include") || iType.equalsIgnoreCase("exclude")) {
                        verifyUser(app_SFLoanSt.getLocArray());
                    } else {
                        setVariables(normal_Index);
                    }

                }

                @Override
                public void onFailure(Call<san_ied__Loan_PJ> call, Throwable t) {
                    //Log.e("@@Trans", "onFailure: " + t.getMessage());
                }
            });
        } else {
            checkNetworkConnection();
        }

    }

    private void setVariables(int varIndex) {
        transMainPref.setInterCnt(Integer.parseInt(mVar.get(varIndex).getIntersCnt()));
        transMainPref.setBack_cnt(Integer.parseInt(mVar.get(varIndex).getBackCnt()));
        transMainPref.setFB_app_id(mVar.get(varIndex).getFBAppId());
        transMainPref.setFB_inter(mVar.get(varIndex).getFBInter());
        transMainPref.setFB_native(mVar.get(varIndex).getFBNative());
        transMainPref.setFB_native_banner(mVar.get(varIndex).getFBNativeBanner());
        transMainPref.setFB_banner(mVar.get(varIndex).getFBBanner());
        transMainPref.setAmAppId(mVar.get(varIndex).getAMAppId());
        transMainPref.setAM_native(mVar.get(varIndex).getAMNative());
        transMainPref.setAM_inter(mVar.get(varIndex).getAMInter());
        transMainPref.setAM_banner(mVar.get(varIndex).getAMBanner());
        transMainPref.setAM_App_Open(mVar.get(varIndex).getAMAppOpen());
        transMainPref.setAM_Rectangele(mVar.get(varIndex).getAMRectangle());
        transMainPref.setDuo_Ads(mVar.get(varIndex).getDuo_Ads());
        transMainPref.setQureka_Inter(mVar.get(varIndex).getQureka_Inter());
        transMainPref.setQureka_Inter_Mode(mVar.get(varIndex).getQureka_Inter_Mode());
        transMainPref.setQureka_Inter_CloseTap(mVar.get(varIndex).getQureka_Inter_CloseTap());
        transMainPref.setQureka_Url(mVar.get(varIndex).getQureka_Url());
        transMainPref.setApp_Country(mVar.get(varIndex).getApp_Country());
        transMainPref.setApp_Privacy(mVar.get(varIndex).getApp_Privacy());
        transMainPref.setApp_Language(mVar.get(varIndex).getApp_Language());
        transMainPref.setApp_Permission(mVar.get(varIndex).getApp_Permission());
        transMainPref.setApp_Start(mVar.get(varIndex).getApp_Start());
        transMainPref.setApp_Thankyou(mVar.get(varIndex).getApp_Thankyou());
        transMainPref.setApp_Exit_Dialoge(mVar.get(varIndex).getApp_Exit_Dialoge());
        transMainPref.setServer(mVar.get(varIndex).getServer());

        //ads & next
        sanAndroid_Admob_Id.LoadInterstitialAds(SplashActivity.this);
        Trans_Aud_Id.NativeAddLoad1(SplashActivity.this);
        Trans_Aud_Id.NativeBannerAddLoad1(SplashActivity.this);
        Speed_Android_Sp_OP_Ad.LoadInterstitialAd(SplashActivity.this);
        moveToAppOpen();
    }

    private void verifyUser(List<san_d__Loan_Arr> iArray) {
        san_x_Serc apiService = getGeoApiService();
        apiService.getLocation().enqueue(new retrofit2.Callback<san_d_Ex_Res>() {
            @Override
            public void onResponse(Call<san_d_Ex_Res> call, Response<san_d_Ex_Res> response) {

                String uCountryCode = response.body().getCountryCode();
                String uStateCode = response.body().getRegion();
                String uCityName = response.body().getCity();


                switch (iType) {
                    case "include":
                        for (int k = 0; k < iArray.size(); k++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(k).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(k).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(k).getCityName())) {
                                k = 999;
                                includeChecker = true;
                            }
                        }

                        if (includeChecker) {
                            setVariables(publisher_Index);
                            //Log.e("@@Trans", "exclude - Publisher...");
                        } else {
                            setVariables(normal_Index);
                            //Log.e("@@Trans", "exclude - Normal User...");
                        }
                        break;

                    case "exclude":
                        for (int j = 0; j < iArray.size(); j++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(j).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(j).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(j).getCityName())) {
                                j = 999;
                                excludeChecker = true;
                            }
                        }

                        if (excludeChecker) {
                            setVariables(publisher_Index);
                            //Log.e("@@Trans", "include - Publisher...");
                        } else {
                            setVariables(normal_Index);
                            //Log.e("@@Trans", "include - Normal User...");
                        }
                        break;

                    default:
                        setVariables(normal_Index);
                        break;
                }
            }

            @Override
            public void onFailure(Call<san_d_Ex_Res> call, Throwable t) {
                //Log.e("@@Trans", "user verify api issue: " + t.getMessage());
                setVariables(normal_Index);
            }
        });
    }

    private void moveToAppOpen() {
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                if (Speed_Android_Sp_OP_Ad.isAdAvailable()) {
                    onFinish();
                    cancel();
                }
            }

            public void onFinish() {
                Speed_Android_Sp_OP_Ad.ShowInterstitialAd(SplashActivity.this, new san_Android_Int_Cls() {
                    @Override
                    public void onAdsClose() {
                        loadAppScreen();
                    }
                });
            }

        }.start();
    }

    private void loadAppScreen() {

        activity_X = san_MainActivity.class;

        if (transMainPref.getApp_Country().equalsIgnoreCase("on")) {
            Intent i = new Intent(SplashActivity.this, san_fd_n_LNGG.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
            Intent i = new Intent(SplashActivity.this, sanaid_oan_PK.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
            Intent i = new Intent(SplashActivity.this, san_ned_Bhasha.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
            Intent i = new Intent(SplashActivity.this, sand_Loan_PR.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
            Intent i = new Intent(SplashActivity.this, san_ird__Loan_ST.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else {
            Intent i = new Intent(SplashActivity.this, activity_X);
            i.putExtra("app_inter", false);
            startActivity(i);
        }
    }

    public boolean isDevMode() {
        if (Integer.valueOf(android.os.Build.VERSION.SDK) == 16) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(), android.provider.Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0;
        } else if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 17) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(), android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0;
        } else return false;
    }


    public void checkNetworkConnection() {
        builder2 = new AlertDialog.Builder(this);
        builder2.setCancelable(false);
        builder2.setTitle("No internet Connection");
        builder2.setMessage("Please turn on internet connection to continue!");
        builder2.setPositiveButton("Turn On", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                SplashActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                SplashActivity.this.finish();
            }
        }).show();
        builder2.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                SplashActivity.this.finishAffinity();
            }
        }).show();
        builder2.create().show();
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}