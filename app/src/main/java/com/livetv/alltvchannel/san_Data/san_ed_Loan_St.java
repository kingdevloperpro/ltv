package com.livetv.alltvchannel.san_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class san_ed_Loan_St {

    @SerializedName("loc_type")
    @Expose
    private String locType;
    @SerializedName("loc_array")
    @Expose
    private List<san_d__Loan_Arr> SFLoanArr;

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public List<san_d__Loan_Arr> getLocArray() {
        return SFLoanArr;
    }

    public void setLocArray(List<san_d__Loan_Arr> SFLoanArr) {
        this.SFLoanArr = SFLoanArr;
    }

}