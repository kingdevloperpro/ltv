package com.livetv.alltvchannel.san_ed__Manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.livetv.alltvchannel.R;
import com.livetv.alltvchannel.san_SplashExit.SplashActivity;
import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;
import com.speed.loan.mukesh_ads.Speed_Android_Main_Pref;


public class sanaid_oan_PK extends AppCompatActivity {


    TextView tvAccept, textView, iv_close;
    TextView tv_policy1, tv_policy2, tv_policy3, tv_diffaccept;
    Speed_Android_Main_Pref transMainPref;
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.san___loan_activity_privacy_policy);

        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        }

        transMainPref = new Speed_Android_Main_Pref(this);
        init();

        String str1 = "Following link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/terms-conditions.html\"> <b> Terms and conditions of use </b> </a> ";
        tv_policy1.setText(Html.fromHtml(str1));
        tv_policy1.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy1.setMovementMethod(LinkMovementMethod.getInstance());

        String str2 = "Following Link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/privacy-policy.html\"> <b> Privacy policy </b> </a> ";
        tv_policy2.setText(Html.fromHtml(str2));
        tv_policy2.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy2.setMovementMethod(LinkMovementMethod.getInstance());

        String str3 = "Following Link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/app-community-guidelines.html\"> <b> App Community Guidelines </b> </a> ";
        tv_policy3.setText(Html.fromHtml(str3));
        tv_policy3.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy3.setMovementMethod(LinkMovementMethod.getInstance());

        iv_close.setOnClickListener(v -> onBackPressed());

        tvAccept.setOnClickListener(v -> {
            if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
                startActivity(new Intent(sanaid_oan_PK.this, san_ned_Bhasha.class).putExtra("app_inter", true));
            } else if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
                startActivity(new Intent(sanaid_oan_PK.this, sand_Loan_PR.class).putExtra("app_inter", true));
            } else if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
                startActivity(new Intent(sanaid_oan_PK.this, san_ird__Loan_ST.class).putExtra("app_inter", true));
            } else {
                startActivity(new Intent(sanaid_oan_PK.this, new SplashActivity().activity_X).putExtra("app_inter", true));
            }
        });
    }

    private void init() {
        iv_close = findViewById(R.id.iv_close);
        tvAccept = findViewById(R.id.tvText);
        textView = findViewById(R.id.textView);
        tv_policy1 = findViewById(R.id.tv_policy1);
        tv_policy2 = findViewById(R.id.tv_policy2);
        tv_policy3 = findViewById(R.id.tv_policy3);
        tv_diffaccept = findViewById(R.id.tv_diffaccept);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (transMainPref.getApp_Country().equalsIgnoreCase("on")) {
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
