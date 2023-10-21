package com.livetv.alltvchannel;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.livetv.alltvchannel.san_haman.app_inter_d_DB_DB;
import com.livetv.alltvchannel.san_haman.app_interded__PF;
import com.livetv.alltvchannel.san_haman.san_d_TPPP;
import com.livetv.alltvchannel.san_haman.san_laeed__CMM;
import com.speed.loan.san__Android_MBit;


public class san_aavechebahiLoan extends san__Android_MBit {
    public static final String TAG = "MyApplicationClass";
    public static san_aavechebahiLoan san_aavechebahiLoan;
    public static Context context = null;
    public static app_inter_d_DB_DB SFLoanDB = null;
    public static boolean isDownloaded = false;
    public static san_d_TPPP SFLoanTPPP;
    private RequestQueue mRequestQueue;


    public static synchronized san_aavechebahiLoan getInstance() {
        san_aavechebahiLoan SFLoanMBit;
        synchronized (san_aavechebahiLoan.class) {
            SFLoanMBit = san_aavechebahiLoan;
        }
        return SFLoanMBit;
    }

    public static Context getContext() {
        return context;
    }

    public void onCreate() {
        super.onCreate();
        san_aavechebahiLoan = this;
        context = getApplicationContext();
        app_interded__PF.sharedPreferences();
        if (!app_interded__PF.sharedPreferences().contains("spin")) {
            app_interded__PF.editorString("spin", app_interded__PF.SPIN);
        }
        SFLoanDB = new app_inter_d_DB_DB(getApplicationContext());
        san_laeed__CMM.setDefaultFont(this, "DEFAULT", "fonts/MyFont.ttf");
        san_laeed__CMM.setDefaultFont(this, "MONOSPACE", "fonts/MyFont.ttf");
        san_laeed__CMM.setDefaultFont(this, "SERIF", "fonts/MyFont.ttf");
        san_laeed__CMM.setDefaultFont(this, "SANS_SERIF", "fonts/MyFont.ttf");
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String str) {
        if (TextUtils.isEmpty(str)) {
            str = TAG;
        }
        request.setTag(str);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object obj) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            requestQueue.cancelAll(obj);
        }
    }


}
