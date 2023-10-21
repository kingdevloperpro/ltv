package com.livetv.alltvchannel.san_LiveChannel;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.livetv.alltvchannel.R;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class ViewVideoActivity extends AppCompatActivity {
    ProgressBar progressBar1;
    SwipeRefreshLayout swipe;
    WebView webView;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_view_video);
        getWindow().setFlags(1024, 1024);

//        
//        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);

        String stringExtra = getIntent().getStringExtra("VideoName");
        webView = (WebView) findViewById(R.id.webView);
        progressBar1 = (ProgressBar) findViewById(R.id.awv_progressBar);
        webView.loadUrl("https://ramappsdeveloper.com/inhouse/tv/channel/" + stringExtra);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new AppWebViewClients(this.progressBar1));
    }

    public class AppWebViewClients extends WebViewClient {
        private ProgressBar progressBar;

        public AppWebViewClients(ProgressBar progressBar2) {
            this.progressBar = progressBar2;
            progressBar2.setVisibility(View.VISIBLE);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
