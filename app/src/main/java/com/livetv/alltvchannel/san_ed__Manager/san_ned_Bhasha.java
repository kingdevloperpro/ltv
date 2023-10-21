package com.livetv.alltvchannel.san_ed__Manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.alltvchannel.R;
import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;
import com.speed.loan.mukesh_ads.Speed_Android_Main_Pref;

public class san_ned_Bhasha extends AppCompatActivity {

    Speed_Android_Main_Pref transMainPref;
    RecyclerView rvLeng;
    int[] ints = new int[]{R.drawable.leng1, R.drawable.leng2, R.drawable.leng3, R.drawable.leng4, R.drawable.leng5, R.drawable.leng6};
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.san___loan_activity_lenguage);

        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        }

        transMainPref = new Speed_Android_Main_Pref(this);
        init();
    }

    private void init() {
        rvLeng = findViewById(R.id.rvLeng);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvLeng.setLayoutManager(gridLayoutManager);
        sand_Loan_LG_ADP appLanguageAdapter = new sand_Loan_LG_ADP(this, ints);
        rvLeng.setAdapter(appLanguageAdapter);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
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
