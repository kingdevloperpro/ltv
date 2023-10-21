package com.speed.loan.mukesh_ads;

import android.app.Activity;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;
import com.speed.loan.san__Android_MBit;
import com.speed.loan.san___Android_CS2;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

public class Speed_Android_ManageBeta implements LifecycleObserver {

    private static Speed_Android_Main_Pref transMainPref;
    public static AppOpenAd appOpenAd = null;
    public static Activity currentActivity;
    public static boolean isShowingAd = false;
    public static AppOpenAd.AppOpenAdLoadCallback loadCallback;
    private final san__Android_MBit myApplication;

    public Speed_Android_ManageBeta(san__Android_MBit myApplication) {
        this.myApplication = myApplication;
        this.transMainPref = new Speed_Android_Main_Pref(myApplication);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public static void fetchAds(Activity activity) {
        if (isAdAvailable()) {
            return;
        }
        loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull AppOpenAd ad) {
                //Log.e("@@Trans_ManageBeta", "Loaded");
                appOpenAd = ad;
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                //Log.e("@@Trans_ManageBeta", "Error: " + loadAdError.toString());
            }
        };
        AppOpenAd.load(activity, transMainPref.getAM_App_Open(), new AdRequest.Builder().build(),
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    public static void showAdIfAvailableAds(Activity activity, san___Android_CS2 onInterCloseCallBack) {
        if (sanAndroid_Admob_Id.Strcheckad.equalsIgnoreCase("StrClosed") && !isShowingAd && isAdAvailable()) {
            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdDismissedFullScreenContent");
                            appOpenAd = null;
                            isShowingAd = false;
                            fetchAds(activity);
                            sanAndroid_Admob_Id.Strcheckad = "StrClosed";
                            onInterCloseCallBack.onAdsClose();
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            //Log.e("@@Trans_ManageBeta", "AdFailedToShowFullScreenContent" + adError.toString());
                            sanAndroid_Admob_Id.Strcheckad = "StrClosed";
                            onInterCloseCallBack.onAdsClose();
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdShowedFullScreenContent");
                            sanAndroid_Admob_Id.Strcheckad = "StrOpen";
                            isShowingAd = true;
                        }
                    };
            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
            appOpenAd.show(currentActivity);
        } else {
            onInterCloseCallBack.onAdsClose();
            fetchAds(activity);
        }
    }

    public static boolean isAdAvailable() {
        return appOpenAd != null;
    }

    public static void clearInstance() {
        currentActivity = null;
        isShowingAd = false;
        appOpenAd = null;
    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {
        showAdIfAvailable();
    }

    private void fetchAd() {
        if (isAdAvailable()) {
            return;
        }
        loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull AppOpenAd ad) {
                //Log.e("@@Trans_ManageBeta", "Loaded");
                appOpenAd = ad;
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                //Log.e("@@Trans_ManageBeta", "Error: " + loadAdError.toString());
                appOpenAd = null;
            }
        };
        AppOpenAd.load(myApplication, transMainPref.getAM_App_Open(), new AdRequest.Builder().build(),
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    private void showAdIfAvailable() {
        if (sanAndroid_Admob_Id.Strcheckad.equalsIgnoreCase("StrClosed") && !isShowingAd && isAdAvailable()) {
            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdDismissedFullScreenContent");
                            appOpenAd = null;
                            isShowingAd = false;
                            fetchAd();
                            sanAndroid_Admob_Id.Strcheckad = "StrClosed";
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            //Log.e("@@Trans_ManageBeta", "AdFailedToShowFullScreenContent" + adError.toString());
                            sanAndroid_Admob_Id.Strcheckad = "StrClosed";
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdShowedFullScreenContent");
                            sanAndroid_Admob_Id.Strcheckad = "StrOpen";
                            isShowingAd = true;
                        }
                    };
            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
            appOpenAd.show(currentActivity);
        } else {
            new Handler().postDelayed(() -> {
                //Log.e("@@SplashBeta", " - fetchAd going");
                fetchAd();
            }, 1500);
        }
    }
}