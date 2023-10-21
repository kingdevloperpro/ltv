package com.livetv.alltvchannel.san_LiveChannel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chennel implements Parcelable {
    public static final Creator<Chennel> CREATOR = new Creator<Chennel>() {
        /* class com.livetv.alltvchannel.LiveChannel.Chennel.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public Chennel createFromParcel(Parcel parcel) {
            return new Chennel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Chennel[] newArray(int i) {
            return new Chennel[i];
        }
    };
    @SerializedName("chennel_icon")
    @Expose
    private String chennelIcon;
    @SerializedName("chennel_link")
    @Expose
    private String chennelLink;
    @SerializedName("chennel_name")
    @Expose
    private String chennelName;
    @SerializedName("chennel_no")
    @Expose
    private String chennelNo;

    public int describeContents() {
        return 0;
    }

    protected Chennel(Parcel parcel) {
        this.chennelNo = parcel.readString();
        this.chennelName = parcel.readString();
        this.chennelIcon = parcel.readString();
        this.chennelLink = parcel.readString();
    }

    public String getChennelNo() {
        return this.chennelNo;
    }

    public void setChennelNo(String str) {
        this.chennelNo = str;
    }

    public String getChennelName() {
        return this.chennelName;
    }

    public void setChennelName(String str) {
        this.chennelName = str;
    }

    public String getChennelIcon() {
        return this.chennelIcon;
    }

    public void setChennelIcon(String str) {
        this.chennelIcon = str;
    }

    public String getChennelLink() {
        return this.chennelLink;
    }

    public void setChennelLink(String str) {
        this.chennelLink = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.chennelNo);
        parcel.writeValue(this.chennelName);
        parcel.writeValue(this.chennelIcon);
        parcel.writeValue(this.chennelLink);
    }
}
