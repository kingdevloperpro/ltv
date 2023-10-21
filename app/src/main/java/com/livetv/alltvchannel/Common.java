package com.livetv.alltvchannel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;

public class Common {
    public static int startScreen = 0;

    @SuppressLint("MissingPermission")
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
