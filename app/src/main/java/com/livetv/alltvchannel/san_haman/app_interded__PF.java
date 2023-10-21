package com.livetv.alltvchannel.san_haman;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.livetv.alltvchannel.R;
import com.livetv.alltvchannel.san_aavechebahiLoan;

import java.text.DecimalFormat;

public class app_interded__PF {
    public static String SPIN = "10";
    public static SharedPreferences _sharedPreferences;
    private Activity activity;

    public app_interded__PF(Activity activity2) {
        this.activity = activity2;
    }

    public static SharedPreferences sharedPreferences() {
        SharedPreferences sharedPreferences = san_aavechebahiLoan.getContext().getSharedPreferences("PrefData", 0);
        _sharedPreferences = sharedPreferences;
        return sharedPreferences;
    }

    public static SharedPreferences.Editor editorString(String str, String str2) {
        SharedPreferences.Editor edit = _sharedPreferences.edit();
        edit.putString(str, str2);
        edit.commit();
        return edit;
    }

    public static SharedPreferences.Editor editorBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = _sharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.commit();
        return edit;
    }

    public static void clearSharedPreferences() {
        SharedPreferences.Editor edit = _sharedPreferences.edit();
        edit.clear();
        edit.commit();
        edit.apply();
    }

    public static String getNumber() {
        return sharedPreferences().getString("number", " ");
    }

    public static String getName() {
        return sharedPreferences().getString("Name", " ");
    }

    public static String getReferralCode() {
        return sharedPreferences().getString("referralCode", " ");
    }

    public static Bitmap getSelfie() {
        if (!sharedPreferences().contains("selfie")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("selfie", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String getDocumentType() {
        return sharedPreferences().getString("documentType", " ");
    }

    public static String getAadhaarNumber() {
        return sharedPreferences().getString("aadhaarNumber", " ");
    }

    public static Bitmap getDocumentFront() {
        if (!sharedPreferences().contains("documentFront")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("documentFront", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap getDocumentBack() {
        if (!sharedPreferences().contains("documentBack")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("documentBack", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String getPanNumber() {
        return sharedPreferences().getString("panNumber", " ");
    }

    public static Bitmap getPancardImage() {
        if (!sharedPreferences().contains("pancardImage")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("pancardImage", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String getAddressLine1() {
        return sharedPreferences().getString("addressLine1", " ");
    }

    public static String getAddressLine2() {
        return sharedPreferences().getString("addressLine2", " ");
    }

    public static String getPincode() {
        return sharedPreferences().getString("pincode", " ");
    }

    public static String getCity() {
        return sharedPreferences().getString("city", " ");
    }

    public static String getState() {
        return sharedPreferences().getString("state", " ");
    }

    public static String getSalaryDate() {
        return sharedPreferences().getString("salaryDate", " ");
    }

    public static String getBankAccountHolder() {
        return sharedPreferences().getString("bankAccountHolder", " ");
    }

    public static String getBankAccountNumber() {
        return sharedPreferences().getString("bankAccountNumber", " ");
    }

    public static String getBankAccountType() {
        return sharedPreferences().getString("bankAccountType", " ");
    }

    public static String getBankIfscCode() {
        return sharedPreferences().getString("bankIfscCode", " ");
    }

    public static Bitmap getSalarySlip() {
        if (!sharedPreferences().contains("salarySlip")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("salarySlip", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String getSalaryProofType() {
        return sharedPreferences().getString("salaryProofType", " ");
    }

    public static Bitmap getSalaryProof() {
        if (!sharedPreferences().contains("salaryProof")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("salaryProof", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static boolean getIsAcceptFinalOffer() {
        return sharedPreferences().getBoolean("isAcceptFinalOffer", false);
    }

    public static String getInstantCashCompleteDate() {
        return sharedPreferences().getString("instantCashCompleteDate", " ");
    }

    public static String getDateOfBirth() {
        return sharedPreferences().getString("dateOfBirth", " ");
    }

    public static String getEmail() {
        return sharedPreferences().getString("email", "androidstudio@gmail.com");
    }

    public static String getGender() {
        return sharedPreferences().getString("gender", " ");
    }

    public static String getHaveChild() {
        return sharedPreferences().getString("haveChild", " ");
    }

    public static String getNomineeName() {
        return sharedPreferences().getString("nomineeName", " ");
    }

    public static String getNomineeNumber() {
        return sharedPreferences().getString("nomineeNumber", " ");
    }

    public static String getNomineeDateOfBirth() {
        return sharedPreferences().getString("nomineeDateOfBirth", " ");
    }

    public static String getNomineeRelation() {
        return sharedPreferences().getString("nomineeRelation", " ");
    }

    public static String getInsuranceStartDate() {
        return sharedPreferences().getString("insuranceStartDate", " ");
    }

    public static String getInsuranceCompleteDate() {
        return sharedPreferences().getString("insuranceCompleteDate", " ");
    }

    public static boolean getIsInsuranceComplete() {
        return sharedPreferences().getBoolean("isInsuranceComplete", false);
    }

    public static String getSavingsTime() {
        return sharedPreferences().getString("savingsTime", " ");
    }

    public static String getWeeklySavingsAmount() {
        return sharedPreferences().getString("weeklySavingsAmount", " ");
    }

    public static String getFatherName() {
        return sharedPreferences().getString("fatherName", " ");
    }

    public static String getMotherName() {
        return sharedPreferences().getString("motherName", " ");
    }

    public static String getMaritalStatus() {
        return sharedPreferences().getString("maritalStatus", " ");
    }

    public static String getOccupationType() {
        return sharedPreferences().getString("occupationType", " ");
    }

    public static boolean getIsSavingsBasicDetails() {
        return sharedPreferences().getBoolean("isSavingsBasicDetails", false);
    }

    public static String getAddressProofType() {
        return sharedPreferences().getString("addressProofType", " ");
    }

    public static boolean getIsAddressProof() {
        return sharedPreferences().getBoolean("isAddressProof", false);
    }

    public static Bitmap getSignatureImage() {
        if (!sharedPreferences().contains("signatureImage")) {
            return BitmapFactory.decodeResource(san_aavechebahiLoan.getContext().getResources(), R.drawable.ic_default_user);
        }
        String string = sharedPreferences().getString("signatureImage", "");
        if (string.equalsIgnoreCase("")) {
            return null;
        }
        byte[] decode = Base64.decode(string, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static String getIsIndian() {
        return sharedPreferences().getString("isIndian", " ");
    }

    public static String getIsNotPoliticallyExposed() {
        return sharedPreferences().getString("isNotPoliticallyExposed", " ");
    }

    public static String getIsIndianTaxResident() {
        return sharedPreferences().getString("isIndianTaxResident", " ");
    }

    public static String getSpin() {
        return sharedPreferences().getString("spin", "0");
    }

    public static String getPoints() {
        return new DecimalFormat("#00.00").format(Double.parseDouble(sharedPreferences().getString("point", "0")));
    }

    public static String getTempPoint() {
        return sharedPreferences().getString("tempPoint", "0");
    }

    public static void addPoint(double d) {
        editorString("point", String.valueOf(Double.parseDouble(getPoints()) + d));
    }

    public static void removePoint(double d) {
        editorString("point", String.valueOf(Double.parseDouble(getPoints()) - d));
    }

    public static boolean getIsPermissionGranted() {
        return sharedPreferences().getBoolean("isPermissionGranted", false);
    }

    public static String getOtp() {
        return sharedPreferences().getString("otp", " ");
    }

    public static boolean getHaveReferralCode() {
        return sharedPreferences().getBoolean("haveReferralCode", false);
    }

    public static String getMID() {
        return sharedPreferences().getString("mid", " ");
    }

    public static String getSavingsBalance() {
        return sharedPreferences().getString("savingsBalance", "0.00");
    }

    public static String getHomeNumber() {
        return sharedPreferences().getString("homeNumber", "");
    }

    public static String getSociety() {
        return sharedPreferences().getString("society", "");
    }

    public static String getCountry() {
        return sharedPreferences().getString("country", "");
    }

    public static String getLoanAmount() {
        return sharedPreferences().getString("loanAmount", "");
    }

    public static String getEmiTerms() {
        return sharedPreferences().getString("emiTerms", "");
    }

    public static String getEmiAmount() {
        return sharedPreferences().getString("emiAmount", "");
    }

    public static String getDocumentNumber() {
        return sharedPreferences().getString("documentNumber", "");
    }

    public static String getNominee() {
        return sharedPreferences().getString("nominee", "");
    }

    public static String getBankName() {
        return sharedPreferences().getString("bankName", "");
    }

    public static String getAccountNumber() {
        return sharedPreferences().getString("accountNumber", "");
    }

    public static String getIfscCode() {
        return sharedPreferences().getString("ifscCode", "");
    }
}
