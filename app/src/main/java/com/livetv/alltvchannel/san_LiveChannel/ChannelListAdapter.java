package com.livetv.alltvchannel.san_LiveChannel;

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

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {
    List<Chennel> chennelNameList;
    Activity context;

    public ChannelListAdapter(Activity activity, List<Chennel> list) {
        new ArrayList();
        this.context = activity;
        this.chennelNameList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.san_nnel_name_list_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        Glide.with(this.context).load("https://phpstack-1046237-3752222.cloudwaysapps.com/tv/assets/b_image/" + this.chennelNameList.get(i).getChennelIcon()).into(viewHolder.BtnsetImage);
        viewHolder.BtnsetImage.setOnClickListener(new View.OnClickListener() {
            /* class com.livetv.alltvchannel.LiveChannel.ChannelListAdapter.AnonymousClass1 */

            public void onClick(View view) {
                Intent intent = new Intent(ChannelListAdapter.this.context, ViewVideoActivity.class);
                intent.putExtra("VideoName", ChannelListAdapter.this.chennelNameList.get(i).getChennelLink());
                ChannelListAdapter.this.context.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Chennel> list = this.chennelNameList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView BtnsetImage;

        public ViewHolder(View view) {
            super(view);
            BtnsetImage = (ImageView) view.findViewById(R.id.BtnsetImage);
        }
    }
}
