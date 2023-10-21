package com.livetv.alltvchannel.san_ed__Manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.livetv.alltvchannel.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class saneed_an_Lang extends RecyclerView.Adapter<saneed_an_Lang.MyHolder> {

    Context context;
    ArrayList<sand_F_Loan_MC> sand_F_Loan_MCS;
    san_akhoSpd_an_BV san_akhoSpd_an_BV;
    String[] strings = new String[]{"au", "us", "gb", "ch", "ca"};

    public saneed_an_Lang(Context context, ArrayList<sand_F_Loan_MC> sand_F_Loan_MCS, san_akhoSpd_an_BV san_akhoSpd_an_BV) {
        this.context = context;
        this.sand_F_Loan_MCS = sand_F_Loan_MCS;
        this.san_akhoSpd_an_BV = san_akhoSpd_an_BV;
    }


    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.san__loan_count_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        holder.imgCountry.setImageResource(sand_F_Loan_MCS.get(position).getResourceId());
        holder.imgCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sand_F_Loan_MCS.get(position).getCode().equalsIgnoreCase("all")) {
                    san_akhoSpd_an_BV.callback(strings[new Random().nextInt(4 - 0 + 1) + 0]);
                } else {
                    san_akhoSpd_an_BV.callback(sand_F_Loan_MCS.get(position).getCode());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return sand_F_Loan_MCS.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgCountry;


        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgCountry = itemView.findViewById(R.id.imgCountry);

        }
    }
}
