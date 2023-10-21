package com.livetv.alltvchannel.san_LiveChannel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.alltvchannel.R;
import com.livetv.alltvchannel.san_newapi.san_APIClient;

import com.speed.loan.Speed_jitpack_compose.Trans_Aud_Id;
import com.speed.loan.Speed_jitpack_compose.sanAndroid_Admob_Id;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveTVMainActivity extends AppCompatActivity {
    List<Chennel> ChannelList;
    List<Datum> dataModel;
    ImageView ivback;
    RecyclerView rvMainChannelType;
    Api api;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.san_activity_live_tvmain);

        
        sanAndroid_Admob_Id.ShowInterstitialAdsOnCreate(this);

        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.id_liveTv_native));

        InitBinding();
        Init();
    }

    private void Init() {
        GetTVMainData();
    }

    private void InitBinding() {
        this.rvMainChannelType = (RecyclerView) findViewById(R.id.rvMainChannelType);
        ImageView imageView = (ImageView) findViewById(R.id.ivback);
        this.ivback = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void GetTVMainData() {
        api = san_APIClient.getClient().create(Api.class);
        Call<TVMainModel> call = api.GetData("release");
        call.enqueue(new Callback<TVMainModel>() {
            @Override
            public void onResponse(Call<TVMainModel> call, Response<TVMainModel> response) {

                TVMainModel body = response.body();

                LiveTVMainActivity.this.dataModel = body.getData();



                for (int i = 0; i < dataModel.size(); i++) {
                    Log.e("LiveTV", LiveTVMainActivity.this.dataModel.get(i).getCatName());
                }
                LiveTVMainActivity liveTVMainActivity = LiveTVMainActivity.this;
                ChannelNameAdapter channelNameAdapter = new ChannelNameAdapter(liveTVMainActivity, liveTVMainActivity.dataModel);
                LiveTVMainActivity.this.rvMainChannelType.setLayoutManager(new GridLayoutManager(LiveTVMainActivity.this, 2));
                LiveTVMainActivity.this.rvMainChannelType.setAdapter(channelNameAdapter);
            }

            @Override
            public void onFailure(Call<TVMainModel> call, Throwable t) {


            }
        });


    }

    @Override
    public void onBackPressed() {
        sanAndroid_Admob_Id.ShowInterstitialAdsOnBack(this);
    }
}
