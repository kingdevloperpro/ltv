package com.speed.loan.Speed_jitpack_compose;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.facebook.FacebookSdk;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.speed.loan.mukesh_ads.Speed_Android_Main_Pref;
import com.speed.loan.san___Android_CS2;

public class san__Android_Int_Req_One {

    static boolean aBoolean = false;
    static Context mContext;
    static san___Android_CS2 adsListener1;
    static InterstitialAd ANInterstitialAd;
    private static com.google.android.gms.ads.interstitial.InterstitialAd AMInterstitial;
    public static Speed_Android_Main_Pref transMainPref;

    public static void LoadInterstitialAd(Context context) {
        mContext = context;
        transMainPref = new Speed_Android_Main_Pref(context);
        FacebookSdk.setApplicationId(transMainPref.getFB_app_id());
        FacebookSdk.sdkInitialize(context);
        Activity activity = (Activity) context;
        AppEventsLogger.activateApp(activity.getApplication());
        AdSettings.addTestDevices(sanAndroid_Admob_Id.TestDeviceFB);
        loadFBInterstitialAd();

    }

    private static void loadFBInterstitialAd() {
        //Log.e("InterstitialAd", "1-> 1"+ANInterstitialAd + " "+aBoolean);
        if (ANInterstitialAd == null && !aBoolean) {
            //Log.e("InterstitialAd", "1-> 2");
            aBoolean = true;
            ANInterstitialAd = new InterstitialAd(mContext, transMainPref.getFB_inter());
            ANInterstitialAd.loadAd(
                    ANInterstitialAd.buildLoadAdConfig()
                            .withAdListener(new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {
                                    releaseObject();
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {
                                    releaseObject();
                                    adsListener1.onAdsClose();

                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    //Log.e("InterstitialAd", "" + adError.getErrorMessage());
                                    aBoolean = false;
                                    loadAMInterstitialAd();
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    //Log.e("@@Ads", "onAdLoaded + InterstitialAd 0");
                                    aBoolean = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {

                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                }
                            })
                            .build());
        }
    }

    private static void loadAMInterstitialAd() {
        if (AMInterstitial == null && !aBoolean) {
            aBoolean = true;
            try {
                com.google.android.gms.ads.interstitial.InterstitialAd.load(mContext, transMainPref.getAM_inter(), new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        //Log.e("@@InterstitialAd", "AdLoaded: 1");
                        AMInterstitial = interstitialAd;
                        aBoolean = true;
                        AMCallBack();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        super.onAdFailedToLoad(adError);
                        //Log.e("@@InterstitialAd", "AdFailedToLoad: 1");
                        releaseObject();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void AMCallBack() {
        AMInterstitial.setFullScreenContentCallback(new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                //Log.e("@@InterstitialAd", "AdDismissedFullScreenContent: 1");
                sanAndroid_Admob_Id.Strcheckad = "StrClosed";
                releaseObject();
                adsListener1.onAdsClose();
            }

            @Override
            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                super.onAdFailedToShowFullScreenContent(adError);
                //Log.e("@@InterstitialAd", "AdFailedToShowFullScreenContent: 1");
                sanAndroid_Admob_Id.Strcheckad = "StrClosed";
                releaseObject();
                adsListener1.onAdsClose();
            }

            @Override
            public void onAdShowedFullScreenContent() {
                //Log.e("@@InterstitialAd", "AdShowedFullScreenContent: 1");
                sanAndroid_Admob_Id.Strcheckad = "StrOpen";
                releaseObject();
            }
        });

    }

    private static void releaseObject(){
        aBoolean = false;
        AMInterstitial = null;
        ANInterstitialAd = null;
    }

    public static void ShowInterstitialAd(Context context, san___Android_CS2 interstitialAdsListener1) {
        mContext = context;
        adsListener1 = interstitialAdsListener1;
        if (ANInterstitialAd != null && ANInterstitialAd.isAdLoaded() && sanAndroid_Admob_Id.Strcheckad.equalsIgnoreCase("StrClosed")) {
            ANInterstitialAd.show();
            releaseObject();
            san__Android_Int_Req_Two.LoadInterstitialAd(mContext);
        } else if (AMInterstitial != null && sanAndroid_Admob_Id.Strcheckad.equalsIgnoreCase("StrClosed")) {
            AMInterstitial.show((Activity) context);
            releaseObject();
            san__Android_Int_Req_Two.LoadInterstitialAd(context);
        } else {
            adsListener1.onAdsClose();
        }
    }

}
