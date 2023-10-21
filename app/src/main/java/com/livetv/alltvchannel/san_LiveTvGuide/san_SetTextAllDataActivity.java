package com.livetv.alltvchannel.san_LiveTvGuide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.alltvchannel.R;

import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class san_SetTextAllDataActivity extends AppCompatActivity {
    Intent intent;
    ImageView ivback;
    int pos = 0;
    String title;
    TextView tvData;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_setall_text);


        
        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.id_nativeBanner_setAllText));

        tvData = (TextView) findViewById(R.id.tvData);
        ivback = (ImageView) findViewById(R.id.ivback);
        Intent intent2 = getIntent();
        intent = intent2;
        pos = intent2.getIntExtra("type", 0);
        title = this.intent.getStringExtra("title");
        int i = this.pos;
        if (i == 0) {
            this.tvData.setText(getResources().getString(R.string.circled));
        } else if (i == 1) {
            this.tvData.setText(getResources().getString(R.string.tvfirmad));
        } else if (i == 2) {
            this.tvData.setText(getResources().getString(R.string.reporterd));
        } else if (i == 3) {
            this.tvData.setText(getResources().getString(R.string.escannerd));
        } else if (i == 4) {
            this.tvData.setText(getResources().getString(R.string.racerd));
        }
        this.ivback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
