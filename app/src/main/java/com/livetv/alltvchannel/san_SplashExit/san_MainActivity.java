package com.livetv.alltvchannel.san_SplashExit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.alltvchannel.san_LiveChannel.LiveTVMainActivity;
import com.livetv.alltvchannel.san_LiveTvGuide.san_TVGuideActivity;
import com.livetv.alltvchannel.R;
import com.livetv.alltvchannel.san_ed__Manager.san_d_an_TQ;
import com.livetv.alltvchannel.san_ed__Manager.san_fd_n_LNGG;
import com.livetv.alltvchannel.san_ed__Manager.san_ird__Loan_ST;
import com.livetv.alltvchannel.san_ed__Manager.sand_Loan_PR;
import com.livetv.alltvchannel.san_ed__Manager.san_ned_Bhasha;
import com.livetv.alltvchannel.san_ed__Manager.sanaid_oan_PK;
import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;
import com.speed.loan.mukesh_ads.Speed_Android_Main_Pref;


public class san_MainActivity extends AppCompatActivity {
    ImageView BtnLiveTv;
    ImageView BtnTVGuide;
    Speed_Android_Main_Pref transMainPref;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_main);
        transMainPref = new Speed_Android_Main_Pref(this);

        if (getIntent().getBooleanExtra("app_inter", true)) {
            sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        }
//        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.main_nativeContainer));

        InitBinding();
        InitListner();
    }



    private void InitBinding() {
        BtnTVGuide = (ImageView) findViewById(R.id.BtnTVGuide);
        BtnLiveTv = (ImageView) findViewById(R.id.BtnLiveTv);
    }

    private void InitListner() {
        BtnTVGuide.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(san_MainActivity.this, san_TVGuideActivity.class));
            }


        });
        BtnLiveTv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (transMainPref.getServer().equalsIgnoreCase("on")) {
                    startActivity(new Intent(san_MainActivity.this, LiveTVMainActivity.class));
                } else {
                    startActivity(new Intent(san_MainActivity.this, san_TVGuideActivity.class));
                }
            }


        });
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, san_ird__Loan_ST.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sand_Loan_PR.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, san_ned_Bhasha.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, sanaid_oan_PK.class).putExtra("app_inter", true));
            finish();
        } else if (transMainPref.getApp_Country().equalsIgnoreCase("on")) {
            startActivity(new Intent(context, san_fd_n_LNGG.class).putExtra("app_inter", true));
            finish();
        } else {
            if (transMainPref.getApp_Exit_Dialoge().equalsIgnoreCase("on")) {
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.san__loan_more_exit_dialog);
                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Window window = dialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                dialog.setCancelable(true);
                wlp.gravity = Gravity.BOTTOM;
                window.setAttributes(wlp);

                Trans_Aud_Id.NativeAddShow(this, dialog.findViewById(R.id.native_container));

                TextView txt_yes = dialog.findViewById(R.id.yes);
                txt_yes.setOnClickListener(v -> {
                    dialog.dismiss();
                    if (transMainPref.getApp_Thankyou().equalsIgnoreCase("on")) {
                        startActivity(new Intent(this, san_d_an_TQ.class).putExtra("app_inter", true));
                    } else {
                        finishAffinity();
                    }
                });
                dialog.show();
            } else {
                if (doubleBackToExitPressedOnce) {
                    ((Activity) context).finishAffinity();
                    System.exit(1);
                    return;
                }

                doubleBackToExitPressedOnce = true;
                Toast.makeText(context, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }
    }

}
