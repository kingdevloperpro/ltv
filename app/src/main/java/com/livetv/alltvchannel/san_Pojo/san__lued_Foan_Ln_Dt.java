package com.livetv.alltvchannel.san_Pojo;

public class san__lued_Foan_Ln_Dt {
    String accountNumber;
    String address;
    String amount;
    String bank;
    String date;
    String dateOfBirth;
    String documentNumber;
    String documentType;
    String email;
    String emiAmount;
    String emiTerms;
    int f2716id;
    String ifscCode;
    String loanType;
    String name;
    String nominee;
    String number;
    String status;

    public san__lued_Foan_Ln_Dt() {
    }

    public san__lued_Foan_Ln_Dt(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        this.f2716id = i;
        this.date = str;
        this.loanType = str2;
        this.amount = str3;
        this.emiTerms = str4;
        this.emiAmount = str5;
        this.name = str6;
        this.email = str7;
        this.dateOfBirth = str8;
        this.number = str9;
        this.address = str10;
        this.documentType = str11;
        this.documentNumber = str12;
        this.nominee = str13;
        this.bank = str14;
        this.accountNumber = str15;
        this.ifscCode = str16;
        this.status = str17;
    }

    public san__lued_Foan_Ln_Dt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17) {
        this.date = str;
        this.loanType = str2;
        this.amount = str3;
        this.emiTerms = str4;
        this.emiAmount = str5;
        this.name = str6;
        this.email = str7;
        this.dateOfBirth = str8;
        this.number = str9;
        this.address = str10;
        this.documentType = str11;
        this.documentNumber = str12;
        this.nominee = str13;
        this.bank = str14;
        this.accountNumber = str15;
        this.ifscCode = str16;
        this.status = str17;
    }

    public int getId() {
        return this.f2716id;
    }

    public void setId(int i) {
        this.f2716id = i;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public void setLoanType(String str) {
        this.loanType = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getEmiTerms() {
        return this.emiTerms;
    }

    public void setEmiTerms(String str) {
        this.emiTerms = str;
    }

    public String getEmiAmount() {
        return this.emiAmount;
    }

    public void setEmiAmount(String str) {
        this.emiAmount = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getDocumentType() {
        return this.documentType;
    }

    public void setDocumentType(String str) {
        this.documentType = str;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public String getNominee() {
        return this.nominee;
    }

    public void setNominee(String str) {
        this.nominee = str;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String str) {
        this.bank = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getIfscCode() {
        return this.ifscCode;
    }

    public void setIfscCode(String str) {
        this.ifscCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
