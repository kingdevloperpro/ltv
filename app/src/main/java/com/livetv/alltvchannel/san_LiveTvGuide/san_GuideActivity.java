package com.livetv.alltvchannel.san_LiveTvGuide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.livetv.alltvchannel.R;

import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class san_GuideActivity extends AppCompatActivity {
    ImageView chooselanguage;
    public String[] data;
    Intent intent;
    ImageView ivNext;
    ImageView ivPrev;
    ImageView ivback;
    Button local_english;
    Button local_gujarati;
    Button local_hindi;
    int pos = 0;
    TextView tvData;
    TextView tvNoData;
    int intExtra;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_guide);

        
        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.id_guide_nativeContainer));

        ivback = (ImageView) findViewById(R.id.ivback);
        tvData = (TextView) findViewById(R.id.tvData);
        tvNoData = (TextView) findViewById(R.id.tvNoData);
        ivPrev = (ImageView) findViewById(R.id.ivPrev);
        ivNext = (ImageView) findViewById(R.id.ivNext);
        data = getResources().getStringArray(R.array.guide_array);
        chooselanguage = (ImageView) findViewById(R.id.chooselanguage);
        Intent intent2 = getIntent();
        intent = intent2;
        intExtra = intent2.getIntExtra("pos", 0);
        pos = intExtra;
        Log.e("vvvv", "onCreate: " +  pos);
        tvData.setText(data[intExtra]);
        ivPrev.setVisibility(View.GONE);
        ivPrev.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (san_GuideActivity.this.pos > 0) {
                    san_GuideActivity sanGuideActivity = san_GuideActivity.this;
                    sanGuideActivity.pos--;
                    san_GuideActivity.this.tvData.setText(san_GuideActivity.this.data[san_GuideActivity.this.pos]);
                    if (san_GuideActivity.this.pos == 0) {
                        san_GuideActivity.this.ivNext.setVisibility(View.VISIBLE);
                        san_GuideActivity.this.ivPrev.setVisibility(View.INVISIBLE);
                        san_GuideActivity.this.tvNoData.setVisibility(View.VISIBLE);
                        return;
                    }
                    san_GuideActivity.this.ivNext.setVisibility(View.VISIBLE);
                    san_GuideActivity.this.tvNoData.setVisibility(View.INVISIBLE);
                    return;
                }
                san_GuideActivity.this.ivPrev.setVisibility(View.INVISIBLE);
                san_GuideActivity.this.ivNext.setVisibility(View.VISIBLE);
                san_GuideActivity.this.tvNoData.setVisibility(View.VISIBLE);
            }
        });
        this.ivNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (san_GuideActivity.this.pos < san_GuideActivity.this.data.length - 1) {
                    san_GuideActivity.this.pos++;
                    san_GuideActivity.this.tvData.setText(san_GuideActivity.this.data[san_GuideActivity.this.pos]);
                    if (san_GuideActivity.this.pos == san_GuideActivity.this.data.length - 1) {
                        san_GuideActivity.this.ivNext.setVisibility(View.INVISIBLE);
                        san_GuideActivity.this.ivPrev.setVisibility(View.VISIBLE);
                        san_GuideActivity.this.tvNoData.setVisibility(View.VISIBLE);
                        return;
                    }
                    san_GuideActivity.this.ivPrev.setVisibility(View.VISIBLE);
                    san_GuideActivity.this.tvNoData.setVisibility(View.INVISIBLE);
                    return;
                }
                san_GuideActivity.this.ivNext.setVisibility(View.INVISIBLE);
                san_GuideActivity.this.ivPrev.setVisibility(View.VISIBLE);
                san_GuideActivity.this.tvNoData.setVisibility(View.VISIBLE);
            }
        });
        this.ivback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                san_GuideActivity.this.onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
