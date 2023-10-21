package com.livetv.alltvchannel.san_haman;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.livetv.alltvchannel.R;

import java.io.File;
import java.lang.reflect.Field;

public class san_laeed__CMM {
    public static int[] listColors = {R.color.color_1, R.color.color_2, R.color.color_3, R.color.color_4, R.color.color_5, R.color.color_6, R.color.color_7, R.color.color_8};
    static Dialog dialog;
    static Dialog dialog1;
    FirebaseListener firebaseListener;
    DialogCreated listener;
    private Activity activity;

    public san_laeed__CMM(Activity activity2) {
        this.activity = activity2;
    }

//    public static void toolbar(final Activity activity2, String str, boolean z) {
//        AppCompatActivity appCompatActivity = (AppCompatActivity) activity2;
//        Toolbar toolbar = (Toolbar) activity2.findViewById(R.id.toolbar);
//        appCompatActivity.setSupportActionBar(toolbar);
//        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
//        ((TextView) toolbar.findViewById(R.id.tvTitle)).setText(str);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                activity2.onBackPressed();
//            }
//        });
//    }

    public static void setDefaultFont(Context context, String str, String str2) {
        replaceFont(str, Typeface.createFromAsset(context.getAssets(), str2));
    }

    protected static void replaceFont(String str, Typeface typeface) {
        try {
            Field declaredField = Typeface.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, typeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static void alertDialog(Activity activity2, int i, DialogCreated dialogCreated) {
        new san_laeed__CMM(activity2).listener = dialogCreated;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        builder.setView(activity2.getLayoutInflater().inflate(i, (ViewGroup) null));
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        create.getWindow().getAttributes().windowAnimations = 2131820794;
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        create.show();
        dialogCreated.onDialogCreated(create);
    }

    public static void alertDialogCancle(Activity activity2, int i, DialogCreated dialogCreated) {
        new san_laeed__CMM(activity2).listener = dialogCreated;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        builder.setView(activity2.getLayoutInflater().inflate(i, (ViewGroup) null));
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        create.getWindow().getAttributes().windowAnimations = 2131820794;
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        create.show();
        dialogCreated.onDialogCreated(create);
    }

    public static void dialogCommon(Activity activity2, final String str, final String str2) {
        alertDialog(activity2, R.layout.san_ayout_dialog_common, new DialogCreated() {

            @Override
            public void onDialogCreated(final AlertDialog alertDialog) {
                ((TextView) alertDialog.findViewById(R.id.tvTitle)).setText(str);
                ((TextView) alertDialog.findViewById(R.id.tvDescription)).setText(str2);
                ((Button) alertDialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }

    public static boolean isNetworkConnected(Context context) {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 0) {
            return true;
        }
        return false;
    }

    public static void progressDialogShow1(Activity activity2) {
        try {
            Dialog dialog2 = new Dialog(activity2);
            dialog1 = dialog2;
            dialog2.setContentView(R.layout.san__loan_layout_loader);
            dialog1.setCancelable(true);
            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void progressDialogDismiss1() {
        try {
            dialog1.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void progressDialogShow(Activity activity2) {
        try {
            Dialog dialog2 = new Dialog(activity2);
            dialog = dialog2;
            dialog2.setContentView(R.layout.san__loan_layout_loader);
            dialog.setCancelable(true);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void progressDialogDismiss() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dialogServerError(Activity activity2) {
        alertDialog(activity2, R.layout.san__loan_layout_dialog_server_error, new DialogCreated() {

            @Override
            public void onDialogCreated(final AlertDialog alertDialog) {
                ((TextView) alertDialog.findViewById(R.id.tvTitle)).setText("Ooops!");
                ((TextView) alertDialog.findViewById(R.id.tvDescription)).setText("Some problems occur from Server side.\nPlease try again later.");
                ((Button) alertDialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }

    public static int dpToPx(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static void dialogNoInternet(final Activity activity2, final boolean z) {
        alertDialog(activity2, R.layout.san_oan_layout_dialog_no_internet, new DialogCreated() {

            @Override
            public void onDialogCreated(final AlertDialog alertDialog) {
                ((TextView) alertDialog.findViewById(R.id.tvTitle)).setText("Ooops!");
                ((TextView) alertDialog.findViewById(R.id.tvDescription)).setText("No internet connection available.");
                ((Button) alertDialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        alertDialog.dismiss();
                        if (z) {
                            activity2.finish();
                        }
                    }
                });
            }
        });
    }

    public static String getDirectory() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        try {
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return externalStoragePublicDirectory.getAbsolutePath();
    }

    public interface DialogCreated {
        void onDialogCreated(AlertDialog alertDialog);
    }

    public interface FirebaseListener {
        void onDataLoaded();
    }
}
