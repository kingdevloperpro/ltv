package com.livetv.alltvchannel.san_LiveChannel;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.alltvchannel.R;

import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

public class ChannelNameActivity extends AppCompatActivity {
    ImageView ivback;
    RecyclerView rvChannelName;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_channel_name);

        
        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);

        Trans_Aud_Id.NativeBannerAddShow(this, findViewById(R.id.id_channel_nativecontainer));

        InitBinding();
        Init();
    }

    private void InitBinding() {
        this.rvChannelName = (RecyclerView) findViewById(R.id.rvChannelName);
        ImageView imageView = (ImageView) findViewById(R.id.ivback);
        this.ivback = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void Init() {
        ChannelListAdapter channelListAdapter = new ChannelListAdapter(this, ChannelNameAdapter.chennelNameList);
        this.rvChannelName.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        this.rvChannelName.setAdapter(channelListAdapter);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
