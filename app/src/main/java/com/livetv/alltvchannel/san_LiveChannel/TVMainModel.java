package com.livetv.alltvchannel.san_LiveChannel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVMainModel {
    @SerializedName("data")
    @Expose
    private List<Datum> data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("success")
    @Expose
    private Integer success;

    public Integer getSuccess() {
        return this.success;
    }

    public void setSuccess(Integer num) {
        this.success = num;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public List<Datum> getData() {
        return this.data;
    }

    public void setData(List<Datum> list) {
        this.data = list;
    }
}
