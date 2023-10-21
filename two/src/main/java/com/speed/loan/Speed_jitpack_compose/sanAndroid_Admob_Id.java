package com.speed.loan.Speed_jitpack_compose;

import android.app.Activity;
import android.content.Context;

import com.speed.loan.mukesh_ads.Speed_Android_Q_Manage;
import com.speed.loan.mukesh_ads.Speed_Android_Main_Pref;
import com.speed.loan.san__Android_LS1;

import java.util.Arrays;
import java.util.List;

public class sanAndroid_Admob_Id {
    public static String Strcheckad = "StrClosed";
    public static List<String> TestDeviceFB = Arrays.asList("53a3f7a8-b5ca-4054-be2f-9a7e06eaeeff");
    public static List<String> TestDeviceID = Arrays.asList(
            "FF8C3E217FCFC3F61610E14A420DEC2D",
            "018CA95DDE421581B68674E0640DC383",
            "95156D8543D9421D5FFE4F73EAF2C32E",
            "29471F7796C9694ABF9C23412BE1F80C",
            "FB1D7434FFFF94297066072DDCEF6333");

    public static int classSelection = 0;
    public static int AdsCounter = 0;

    public static san__Android_LS1 san__Android_LS1;

    public static void LoadInterstitialAds(Context context) {
        san__Android_Int_Req_Two.LoadInterstitialAd(context);
        san__Android_Int_Req_One.LoadInterstitialAd(context);
    }

    public static void ShowInterstitialAdsOnCreate(Context context) {
        Speed_Android_Main_Pref transMainPref = new Speed_Android_Main_Pref(context);
        if (AdsCounter % transMainPref.getInter_count() == 0) {
            if (classSelection == 0) {
                classSelection = 1;
                san__Android_Int_Req_Two.ShowInterstitialAd(context, () -> {
                    if (transMainPref.getDuo_Ads().equalsIgnoreCase("on")) {
                        //Log.e("@@TAG", "duo ads: ");
                        Speed_Android_Q_Manage.showQurekaInter(context);
                    }
                });
            } else if (classSelection == 1) {
                classSelection = 0;
                san__Android_Int_Req_One.ShowInterstitialAd(context, () -> {
                    if (transMainPref.getDuo_Ads().equalsIgnoreCase("on")) {
                        //Log.e("@@TAG", "duo ads: ");
                        Speed_Android_Q_Manage.showQurekaInter(context);
                    }
                });
            }
        }
        AdsCounter++;
    }

    public static void ShowInterstitialAdsWithListener(final Activity SourceActivity, final san__Android_LS1 mListener) {
        Speed_Android_Main_Pref transMainPref = new Speed_Android_Main_Pref(SourceActivity);
        if (AdsCounter % transMainPref.getInter_count() == 0) {
            if (classSelection == 0) {
                classSelection = 1;

                san__Android_Int_Req_Two.ShowInterstitialAd(SourceActivity, () -> {
                    san__Android_LS1 = mListener;
                    san__Android_LS1.onInterClose();
//                    Intent localIntent = new Intent(SourceActivity, DestinationClass);
//                    SourceActivity.startActivity(localIntent);
                });

            } else if (classSelection == 1) {
                classSelection = 0;
                san__Android_Int_Req_One.ShowInterstitialAd(SourceActivity, () -> {
                    san__Android_LS1 = mListener;
                    san__Android_LS1.onInterClose();
//                    Intent localIntent = new Intent(SourceActivity, DestinationClass);
//                    SourceActivity.startActivity(localIntent);
                });
            }
        }
        AdsCounter++;
    }

    public static void ShowInterstitialAdsOnBack(Context context) {
        Speed_Android_Main_Pref transMainPref = new Speed_Android_Main_Pref(context);
        if (AdsCounter % transMainPref.getBack_cnt() == 0) {
            if (classSelection == 0) {
                classSelection = 1;
                san__Android_Int_Req_Two.ShowInterstitialAd(context, () -> {
                    ((Activity) context).finish();
                });
            } else if (classSelection == 1) {
                classSelection = 0;
                san__Android_Int_Req_One.ShowInterstitialAd(context, () -> {
                    ((Activity) context).finish();
                });
            }
        }
        AdsCounter++;
    }
}
