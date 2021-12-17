package com.fontskeyboard.cooltextstyle.skytechzone.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fontskeyboard.cooltextstyle.skytechzone.R;
import com.fontskeyboard.cooltextstyle.skytechzone.mdtoast.MDToast;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper_Class {
    protected static final int BUY_REQUEST_CODE = 10001;
    private static String TAG = "eu_consent_Class : ";
    public static String current_date;
    public static String current_date_time;
    public static Date current_datetime;
    public static String current_time;
    public static SimpleDateFormat df;
    public static Typeface font_type;
    public static boolean is_online;
    private static Dialog loading_dialog;
    private static TextView loading_dialog_message;
    private static Context mContext;
    public static SimpleDateFormat sdf;
    public static SimpleDateFormat sdt;

    public Helper_Class(Context context) {
        mContext = context;
    }

    public static void RateApp(Context context) {
        try {
            mContext = context;
            ConformRateDialog(mContext, Constant.rate_url + mContext.getPackageName(), "Rate Us", "Please give your valuable feedback\nShow your support to us!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void ShareApp(Context context) {
        try {
            mContext = context;
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", (mContext.getResources().getString(R.string.app_name) + " :") + "\n" + (Constant.rate_url + mContext.getPackageName()));
            mContext.startActivity(Intent.createChooser(intent, "Share via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void MoreApps(Context context) {
        try {
            mContext = context;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(Constant.more_url));
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting() || !connectivityManager.getActiveNetworkInfo().isAvailable() || !connectivityManager.getActiveNetworkInfo().isConnected()) {
            is_online = false;
            return false;
        }
        is_online = true;
        return true;
    }





    public static void ConformRateDialog(final Context context, final String str, String str2, String str3) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_rate);
        Button button = (Button) dialog.findViewById(R.id.dialog_conform_btn_yes);
        Button button2 = (Button) dialog.findViewById(R.id.dialog_conform_btn_no);
        TextView textView = (TextView) dialog.findViewById(R.id.dialog_conform_txt_header);
        TextView textView2 = (TextView) dialog.findViewById(R.id.dialog_conform_txt_message);
        Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), Constant.roboto_font_path);
        font_type = createFromAsset;
        button.setTypeface(createFromAsset);
        button2.setTypeface(font_type);
        textView.setTypeface(font_type);
        textView2.setTypeface(font_type);
        textView.setText(str2);
        textView2.setText(str3);
        button.setText("Rate Now");
        button2.setText("Cancel");
        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }




}
