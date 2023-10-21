package com.livetv.alltvchannel.san_Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class san_m_F_Loan_List implements Serializable {
    @SerializedName("appDesc")
    @Expose
    private String appDesc;
    @SerializedName("appName")
    @Expose
    private String appName;
    @SerializedName("appUrl")
    @Expose
    private String appUrl;
    @SerializedName("borrowRange")
    @Expose
    private String borrowRange;
    @SerializedName("borrowTerm")
    @Expose
    private String borrowTerm;
    @SerializedName("id")
    @Expose
    private Integer f186id;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("interest")
    @Expose
    private String interest;
    @SerializedName("isHot")
    @Expose
    private Integer isHot;
    @SerializedName("packageNameStr")
    @Expose
    private String packageNameStr;
    @SerializedName("progress")
    @Expose
    private Integer progress;
    @SerializedName("pushFlag")
    @Expose
    private String pushFlag;
    @SerializedName("quota")
    @Expose
    private String quota;

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String getBorrowRange() {
        return this.borrowRange;
    }

    public void setBorrowRange(String str) {
        this.borrowRange = str;
    }

    public String getPushFlag() {
        return this.pushFlag;
    }

    public void setPushFlag(String str) {
        this.pushFlag = str;
    }

    public String getInterest() {
        return this.interest;
    }

    public void setInterest(String str) {
        this.interest = str;
    }

    public String getBorrowTerm() {
        return this.borrowTerm;
    }

    public void setBorrowTerm(String str) {
        this.borrowTerm = str;
    }

    public String getPackageNameStr() {
        return this.packageNameStr;
    }

    public void setPackageNameStr(String str) {
        this.packageNameStr = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getAppDesc() {
        return this.appDesc;
    }

    public void setAppDesc(String str) {
        this.appDesc = str;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public void setAppUrl(String str) {
        this.appUrl = str;
    }

    public Integer getId() {
        return this.f186id;
    }

    public void setId(Integer num) {
        this.f186id = num;
    }

    public Integer getIsHot() {
        return this.isHot;
    }

    public void setIsHot(Integer num) {
        this.isHot = num;
    }

    public String getQuota() {
        return this.quota;
    }

    public void setQuota(String str) {
        this.quota = str;
    }
}
