package com.livetv.alltvchannel.san_haman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.livetv.alltvchannel.san_Pojo.san__lued_Foan_Ln_Dt;

import java.util.ArrayList;
import java.util.List;

public class app_inter_d_DB_DB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myDatabase";
    private static final int DATABASE_VERSION = 1;

    public app_inter_d_DB_DB(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE Loan (id INTEGER PRIMARY KEY, date TEXT, loanType TEXT, amount TEXT, emiTerms TEXT, emiAmount TEXT, name TEXT, email TEXT, dateOfBirth TEXT, number TEXT, address TEXT, documentType TEXT, documentNumber TEXT, nominee TEXT, bank TEXT, accountNumber TEXT, ifscCode TEXT, status TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE Payment (id INTEGER PRIMARY KEY, name TEXT, email TEXT, number TEXT, paymentMethod TEXT, amount TEXT, date TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Loan");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Payment");
        onCreate(sQLiteDatabase);
    }

    public void addLoan(san__lued_Foan_Ln_Dt SFLoanLnDt) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", SFLoanLnDt.getDate());
        contentValues.put("loanType", SFLoanLnDt.getLoanType());
        contentValues.put("amount", SFLoanLnDt.getAmount());
        contentValues.put("emiTerms", SFLoanLnDt.getEmiTerms());
        contentValues.put("emiAmount", SFLoanLnDt.getEmiAmount());
        contentValues.put("Name", SFLoanLnDt.getName());
        contentValues.put("email", SFLoanLnDt.getEmail());
        contentValues.put("dateOfBirth", SFLoanLnDt.getDateOfBirth());
        contentValues.put("number", SFLoanLnDt.getNumber());
        contentValues.put("address", SFLoanLnDt.getAddress());
        contentValues.put("documentType", SFLoanLnDt.getDocumentType());
        contentValues.put("documentNumber", SFLoanLnDt.getDocumentNumber());
        contentValues.put("nominee", SFLoanLnDt.getNominee());
        contentValues.put("bank", SFLoanLnDt.getBank());
        contentValues.put("accountNumber", SFLoanLnDt.getAccountNumber());
        contentValues.put("ifscCode", SFLoanLnDt.getIfscCode());
        contentValues.put("status", SFLoanLnDt.getStatus());
        writableDatabase.insert("Loan", null, contentValues);
        writableDatabase.close();
    }


    public List<san__lued_Foan_Ln_Dt> getAllLoan() {
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = getWritableDatabase().rawQuery("SELECT * FROM Loan ORDER BY id DESC", null);
        if (rawQuery.moveToFirst()) {
            do {
                san__lued_Foan_Ln_Dt SFLoanLnDt = new san__lued_Foan_Ln_Dt();
                SFLoanLnDt.setId(Integer.parseInt(rawQuery.getString(0)));
                SFLoanLnDt.setDate(rawQuery.getString(1));
                SFLoanLnDt.setLoanType(rawQuery.getString(2));
                SFLoanLnDt.setAmount(rawQuery.getString(3));
                SFLoanLnDt.setEmiTerms(rawQuery.getString(4));
                SFLoanLnDt.setEmiAmount(rawQuery.getString(5));
                SFLoanLnDt.setName(rawQuery.getString(6));
                SFLoanLnDt.setEmail(rawQuery.getString(7));
                SFLoanLnDt.setDateOfBirth(rawQuery.getString(8));
                SFLoanLnDt.setNumber(rawQuery.getString(9));
                SFLoanLnDt.setAddress(rawQuery.getString(10));
                SFLoanLnDt.setDocumentType(rawQuery.getString(11));
                SFLoanLnDt.setDocumentNumber(rawQuery.getString(12));
                SFLoanLnDt.setNominee(rawQuery.getString(13));
                SFLoanLnDt.setBank(rawQuery.getString(14));
                SFLoanLnDt.setAccountNumber(rawQuery.getString(15));
                SFLoanLnDt.setIfscCode(rawQuery.getString(16));
                SFLoanLnDt.setStatus(rawQuery.getString(17));
                arrayList.add(SFLoanLnDt);
            } while (rawQuery.moveToNext());
        }
        return arrayList;
    }

}
