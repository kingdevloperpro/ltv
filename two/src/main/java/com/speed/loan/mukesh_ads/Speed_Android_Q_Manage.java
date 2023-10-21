package com.speed.loan.mukesh_ads;

import static com.speed.loan.mukesh_ads.san_AndroidVIPQurekaInterAd.openCustomTab;

import android.content.Context;
import android.net.Uri;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.speed.loan.R;

public class Speed_Android_Q_Manage {

    public static void showQurekaInter(Context context) {
        if (new Speed_Android_Main_Pref(context).getQureka_Inter().equalsIgnoreCase("on")) {
            if (new Speed_Android_Main_Pref(context).getQureka_Inter_Mode().equalsIgnoreCase("on")) {
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.chormecolor));
                openCustomTab(context, customIntent.build(), Uri.parse(new Speed_Android_Main_Pref(context).getQureka_Url()));
            } else {
                new san_AndroidVIPQurekaInterAd(context).show();
            }
        }
    }
}
