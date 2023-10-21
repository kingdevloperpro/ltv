package com.livetv.alltvchannel.san_LiveTvGuide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.alltvchannel.R;

import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class san_LiveTVActivity extends AppCompatActivity {
    ImageView BtnBack;
    ImageView Guide1;
    ImageView Guide2;
    ImageView Guide3;
    ImageView Guide4;
    ImageView Guide5;
    ImageView Guide6;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_live_tvactivity);

        
        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.id_live_nativeContainer));

        InitBinding();
        InitListner();
    }

    private void InitBinding() {
        this.Guide1 = (ImageView) findViewById(R.id.Guide1);
        this.Guide2 = (ImageView) findViewById(R.id.Guide2);
        this.Guide3 = (ImageView) findViewById(R.id.Guide3);
        this.Guide4 = (ImageView) findViewById(R.id.Guide4);
        this.Guide5 = (ImageView) findViewById(R.id.Guide5);
        this.Guide6 = (ImageView) findViewById(R.id.Guide6);
        this.BtnBack = (ImageView) findViewById(R.id.BtnBack);
    }

    private void InitListner() {
        this.BtnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_LiveTVActivity.this.onBackPressed();
            }
        });
        this.Guide1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(san_LiveTVActivity.this, san_GuideActivity.class);
                intent.putExtra("pos", 0);
                san_LiveTVActivity.this.startActivity(intent);
            }
        });
        this.Guide2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(san_LiveTVActivity.this, san_GuideActivity.class);
                intent.putExtra("pos", 1);
                san_LiveTVActivity.this.startActivity(intent);
            }
        });
        this.Guide3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(san_LiveTVActivity.this, san_GuideActivity.class);
                intent.putExtra("pos", 2);
                san_LiveTVActivity.this.startActivity(intent);
            }
        });
        this.Guide4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(san_LiveTVActivity.this, san_GuideActivity.class);
                intent.putExtra("pos", 3);
                san_LiveTVActivity.this.startActivity(intent);
            }
        });
        this.Guide5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(san_LiveTVActivity.this, san_GuideActivity.class);
                intent.putExtra("pos", 4);
                san_LiveTVActivity.this.startActivity(intent);
            }
        });
        this.Guide6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(san_LiveTVActivity.this, san_GuideActivity.class);
                intent.putExtra("pos", 5);
                san_LiveTVActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
