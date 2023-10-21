package com.livetv.alltvchannel.san_SplashExit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class san_Glob {
    public static String App_Link = "https://play.google.com/store/apps/details?id=com.livetv.alltvchannel&hl=en";
    public static String app_name = "Live TV Guide";
    public static String privacy_link = "https://appsprivacypolicyfinder.blogspot.com/";
    public static int stopService;

    public static Boolean CheckNet(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }
}
