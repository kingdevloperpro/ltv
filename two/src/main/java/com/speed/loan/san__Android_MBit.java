package com.speed.loan;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.speed.loan.mukesh_ads.Speed_Android_ManageBeta;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class san__Android_MBit extends Application {

    private static san__Android_MBit mInstance;

    public static synchronized san__Android_MBit getInstance() {
        return mInstance;
    }

    public static boolean isConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            return nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
        } catch (Exception e) {
            //Log.e("Connectivity Exception", e.getMessage());
            return false;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (isConnected(this)) {
            AudienceNetworkAds.initialize(this);
            MobileAds.initialize(this, initializationStatus -> {
            });
            MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().setTestDeviceIds(sanAndroid_Admob_Id.TestDeviceID).build());
            new Speed_Android_ManageBeta(this);
        }
    }
}
