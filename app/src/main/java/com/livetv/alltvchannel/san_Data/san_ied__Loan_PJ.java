package com.livetv.alltvchannel.san_Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class san_ied__Loan_PJ {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("settings")
    @Expose
    private san_ed_Loan_St SFLoanSt;
    @SerializedName("response")
    @Expose
    private List<san_ed_Loan_App_Var> SFLoanAppVariables = new ArrayList<>();

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<san_ed_Loan_App_Var> getAppVariables() {
        return SFLoanAppVariables;
    }

    public void setAppVariables(List<san_ed_Loan_App_Var> SFLoanAppVariables) {
        this.SFLoanAppVariables = SFLoanAppVariables;
    }

    public san_ed_Loan_St getSettings() {
        return SFLoanSt;
    }

    public void setSettings(san_ed_Loan_St SFLoanSt) {
        this.SFLoanSt = SFLoanSt;
    }
}