package com.speed.loan.mukesh_ads;

import android.os.SystemClock;
import android.view.View;

public abstract class Speed_Android_One_Shot_Clk implements View.OnClickListener {

    protected int defaultInterval;
    private long lastTimeClicked = 0;

    public Speed_Android_One_Shot_Clk() {
        this(1000);
    }

    public Speed_Android_One_Shot_Clk(int minInterval) {
        this.defaultInterval = minInterval;
    }

    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return;
        }
        lastTimeClicked = SystemClock.elapsedRealtime();
        performClick(v);
    }

    public abstract void performClick(View v);
}
