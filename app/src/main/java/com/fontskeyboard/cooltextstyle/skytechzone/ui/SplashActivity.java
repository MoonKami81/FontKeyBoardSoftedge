package com.fontskeyboard.cooltextstyle.skytechzone.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;


import com.fontskeyboard.cooltextstyle.skytechzone.adsutils.LoadAds;
import com.fontskeyboard.cooltextstyle.skytechzone.db.SharedPreferencecDb;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.fontskeyboard.cooltextstyle.skytechzone.R;
import com.fontskeyboard.cooltextstyle.skytechzone.adsutils.MyApplication;
import com.fontskeyboard.cooltextstyle.skytechzone.utils.Constant;

public class SplashActivity extends Activity  {

    String TAG = "SplashActivity :";

    public String appName;
    Typeface roboto_font_type;



    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setDecorFitsSystemWindows(false);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        LoadAds.getInstance(this).initAds(this);
        SetView();
    }

    private void SetView() {
        this.roboto_font_type = Typeface.createFromAsset(getAssets(), Constant.roboto_font_path);
        this.appName = getApplicationContext().getString(R.string.app_name);


        ContinueWithoutAdsProcess();
    }

    private void ContinueWithoutAdsProcess() {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {


            public void run() {
                Application application = getApplication();

                // If the application is not an instance of MyApplication, log an error message and
                // start the MainActivity without showing the app open ad.
                if (!(application instanceof MyApplication)) {

                    SplashActivity.this.HomeScreen();
                    return;
                }

                // Show the app open ad.
                ((MyApplication) application)
                        .showAdIfAvailable(
                                SplashActivity.this,
                                new MyApplication.OnShowAdCompleteListener() {
                                    @Override
                                    public void onShowAdComplete() {

                                        Log.d(TAG, "onShowAdComplete: main");
                                        SplashActivity.this.HomeScreen();


                                    }
                                });


            }
        }, (long) (3500));
    }




    private void HomeScreen() {

          startActivity(new Intent(this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));


    }

    public void onBackPressed() {
        super.onBackPressed();
        ExitApp();
    }


    private void ExitApp() {
        moveTaskToBack(true);
        finish();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }




}
