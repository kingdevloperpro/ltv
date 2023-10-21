package com.livetv.alltvchannel.san_LiveTvGuide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.alltvchannel.R;

import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class san_TVGuideActivity extends AppCompatActivity {
    ImageView BtnBack;
    ImageView BtnCircle;
    ImageView BtnEscanerQE;
    ImageView BtnLiveTv;
    ImageView BtnRacer;
    ImageView BtnReporter;
    ImageView BtnTVFirma;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_tvguide);

        
        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.id_fl_native_tvGuide));

        InitBinding();
        InitListner();
    }

    private void InitBinding() {
        BtnLiveTv = (ImageView) findViewById(R.id.BtnLiveTv);
        BtnCircle = (ImageView) findViewById(R.id.BtnCircle);
        BtnTVFirma = (ImageView) findViewById(R.id.BtnTVFirma);
        BtnReporter = (ImageView) findViewById(R.id.BtnReporter);
        BtnEscanerQE = (ImageView) findViewById(R.id.BtnEscanerQE);
        BtnRacer = (ImageView) findViewById(R.id.BtnRacer);
        BtnBack = (ImageView) findViewById(R.id.BtnBack);
    }

    private void InitListner() {
        this.BtnLiveTv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.startActivity(new Intent(san_TVGuideActivity.this, san_LiveTVActivity.class));
            }


        });
        this.BtnCircle.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.callNext(0, "Circle", new Intent(san_TVGuideActivity.this, san_SetTextAllDataActivity.class));
            }
        });
        this.BtnTVFirma.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.callNext(1, "TV Firma", new Intent(san_TVGuideActivity.this, san_SetTextAllDataActivity.class));
            }

        });
        this.BtnReporter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.callNext(2, "Reporter", new Intent(san_TVGuideActivity.this, san_SetTextAllDataActivity.class));
            }
        });
        this.BtnEscanerQE.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.callNext(3, "Escaner QE", new Intent(san_TVGuideActivity.this, san_SetTextAllDataActivity.class));
            }
        });
        this.BtnRacer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.callNext(4, "Racer", new Intent(san_TVGuideActivity.this, san_SetTextAllDataActivity.class));
            }

        });
        this.BtnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_TVGuideActivity.this.onBackPressed();
            }
        });
    }

    public void callNext(int i, String str, Intent intent) {
        intent.putExtra("type", i);
        intent.putExtra("title", str);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
