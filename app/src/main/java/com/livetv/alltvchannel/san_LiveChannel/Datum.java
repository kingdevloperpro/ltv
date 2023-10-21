package com.livetv.alltvchannel.san_LiveChannel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {
    @SerializedName("cat_icon")
    @Expose
    private String catIcon;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("cat_name")
    @Expose
    private String catName;
    @SerializedName("chennel_list")
    @Expose
    private List<Chennel> chennelList;

    public String getCatId() {
        return this.catId;
    }

    public void setCatId(String str) {
        this.catId = str;
    }

    public String getCatName() {
        return this.catName;
    }

    public void setCatName(String str) {
        this.catName = str;
    }

    public String getCatIcon() {
        return this.catIcon;
    }

    public void setCatIcon(String str) {
        this.catIcon = str;
    }

    public List<Chennel> getChennelList() {
        return this.chennelList;
    }

    public void setChennelList(List<Chennel> list) {
        this.chennelList = list;
    }
}
