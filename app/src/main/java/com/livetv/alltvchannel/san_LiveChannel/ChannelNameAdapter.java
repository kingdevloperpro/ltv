package com.livetv.alltvchannel.san_LiveChannel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.livetv.alltvchannel.R;

import java.util.ArrayList;
import java.util.List;

public class ChannelNameAdapter extends RecyclerView.Adapter<ChannelNameAdapter.ViewHolder> {
    public static List<Chennel> chennelNameList = new ArrayList();
    List<Datum> channeltypeList;
    Activity context;

    public ChannelNameAdapter(Activity activity, List<Datum> list) {
        new ArrayList();
        this.context = activity;
        this.channeltypeList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.san_channel_name_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int pos) {
        Glide.with(this.context).load("https://phpstack-1046237-3752222.cloudwaysapps.com/tv/assets/b_image/" + this.channeltypeList.get(pos).getCatIcon()).into(viewHolder.BtnsetBG);
        viewHolder.BtnsetBG.setOnClickListener(new View.OnClickListener() {
            /* class com.livetv.alltvchannel.LiveChannel.ChannelNameAdapter.AnonymousClass1 */

            public void onClick(View view) {
                int i = pos;
//                if (i == 1 || i == 2 || i == 5 || i == 6) {
//                    AdLoader.getInstance(ChannelNameAdapter.this.context).showInterstitialAd(ChannelNameAdapter.this.context, new ChannelNameAdapter$1$$ExternalSyntheticLambda0(this, i));

                    ChannelNameAdapter.chennelNameList = ChannelNameAdapter.this.channeltypeList.get(i).getChennelList();
                    ChannelNameAdapter.this.context.startActivity(new Intent(ChannelNameAdapter.this.context, ChannelNameActivity.class));
                    return;
//                }
//                ChannelNameAdapter.chennelNameList = ChannelNameAdapter.this.channeltypeList.get(i).getChennelList();
//                ChannelNameAdapter.this.context.startActivity(new Intent(ChannelNameAdapter.this.context, ChannelNameActivity.class));
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$onClick$0$com-co-rbb-live-tv-guide-watchlivetv-tvlive-LiveChannel-ChannelNameAdapter$1  reason: not valid java name */
            public /* synthetic */ void m58xd07aec54(int i) {

            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Datum> list = this.channeltypeList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView BtnsetBG;

        public ViewHolder(View view) {
            super(view);
            this.BtnsetBG = (ImageView) view.findViewById(R.id.BtnsetBG);
        }
    }
}
