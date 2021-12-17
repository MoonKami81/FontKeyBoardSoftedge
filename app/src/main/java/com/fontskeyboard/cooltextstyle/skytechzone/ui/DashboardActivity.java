package com.fontskeyboard.cooltextstyle.skytechzone.ui;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontSet;
import com.fontskeyboard.cooltextstyle.skytechzone.R;
import com.fontskeyboard.cooltextstyle.skytechzone.db.DataStore;
import com.fontskeyboard.cooltextstyle.skytechzone.adsutils.LoadAds;
import com.fontskeyboard.cooltextstyle.skytechzone.adsutils.OnIntersitialAdListener;

import java.util.HashMap;
import java.util.List;

import ir.androidexception.andexalertdialog.AndExAlertDialog;
import ir.androidexception.andexalertdialog.AndExAlertDialogListener;

public final class DashboardActivity extends AppCompatActivity {
    private NativeAd nativeAd;


    Context context;
    CardView cv_1;
    CardView cv_enbKey;
    CardView cv_service;
    InputMethodChangeReceiver inputMethodChangeReceiver;
    InputMethodManager inputMethodManager;
    ImageView iv_done;
    List<InputMethodInfo> list;
    public final Handler mGetBackHereHandler = new Handler() {
        /* class com.vvaani.fontkeyboard.yp.activity.FirstActivity.AnonymousClass1 */

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 446) {
                Intent intent = DashboardActivity.this.reLaunchTaskIntent;
            } else if (i == 447) {
                DashboardActivity.this.unregisterSettingsObserverNow();
            } else {
                super.handleMessage(message);
            }
        }
    };
    private int mState;
    DataStore nanoSangrahalay;

    boolean onBackClick = false;
    String packageLocal;
    public Intent reLaunchTaskIntent;

    private final ContentObserver secureSettingsChanged = new ContentObserver(null) {


        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean z) {
            DashboardActivity dashboardActivity = DashboardActivity.this;
            Log.d("secureSettingsChange", String.valueOf(dashboardActivity.isKeyboardEnabled(dashboardActivity.getApplicationContext())));
            DashboardActivity dashboardActivity2 = DashboardActivity.this;
            if (dashboardActivity2.isKeyboardEnabled(dashboardActivity2.getApplicationContext())) {
                DashboardActivity.this.mGetBackHereHandler.removeMessages(446);
                DashboardActivity.this.mGetBackHereHandler.sendMessageDelayed(DashboardActivity.this.mGetBackHereHandler.obtainMessage(446), 50);
            }
        }
    };
    TextView tv_service_enb;
    TextView tv_service_enb2;

    public class InputMethodChangeReceiver extends BroadcastReceiver {
        public InputMethodChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.INPUT_METHOD_CHANGED") && FontSet.INSTANCE.isThisKeyboardSetAsDefaultIME(context)) {
                DashboardActivity.this.onBackClick = false;

                DashboardActivity.this.BackScreen();

            }
        }
    }

    @Override

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.page_main_n);
        loadNativeAd();
        getSupportActionBar().hide();
        InputMethodChangeReceiver inputMethodChangeReceiver2 = new InputMethodChangeReceiver();
        this.inputMethodChangeReceiver = inputMethodChangeReceiver2;
        registerReceiver(inputMethodChangeReceiver2, new IntentFilter("android.intent.action.INPUT_METHOD_CHANGED"));
        this.mState = 0;
        this.packageLocal = getApplicationContext().getPackageName();
        InputMethodManager inputMethodManager2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        this.inputMethodManager = inputMethodManager2;
        this.list = inputMethodManager2.getEnabledInputMethodList();
        this.context = this;
        Intent intent = new Intent(getBaseContext(), DashboardActivity.class);
        this.reLaunchTaskIntent = intent;
        intent.addFlags(67108864);
        Intent intent2 = this.reLaunchTaskIntent;
        if (intent2 != null) {
            intent2.addFlags(268435456);
        }
        Log.d("test", "isThisKeyboardEnabled " + FontSet.INSTANCE.isThisKeyboardEnabled(this));
        Log.d("test", "isThisKeyboardSetAsDefaultIME " + FontSet.INSTANCE.isThisKeyboardSetAsDefaultIME(this));
        setupButtons();
        this.cv_1 = (CardView) findViewById(R.id.cv_1);
        this.cv_service = (CardView) findViewById(R.id.cv_service);
        this.iv_done = (ImageView) findViewById(R.id.iv_done);
        this.tv_service_enb = (TextView) findViewById(R.id.tv_service_enb);
        this.tv_service_enb2 = (TextView) findViewById(R.id.tv_service_enb2);
        CardView cardView = (CardView) findViewById(R.id.cv_enbKey);
        this.cv_enbKey = cardView;
        cardView.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                DashboardActivity.this.cv_enbKey.startAnimation(AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.viewpush));
                if (FontSet.INSTANCE.isThisKeyboardSetAsDefaultIME(DashboardActivity.this.context)) {
                    DashboardActivity.this.onBackClick = false;
                    LoadAds.getInstance(DashboardActivity.this).showintersitialwithoutcounter(new OnIntersitialAdListener() {
                        @Override
                        public void onAdFailded() {
                            DashboardActivity.this.BackScreen();
                        }

                        @Override
                        public void onAdDismis() {
                            DashboardActivity.this.BackScreen();
                        }
                    });


                } else {
                    DashboardActivity.this.openKeyboardChooser();
                }
            }
        });
        if (isInputEnabled()) {

            this.iv_done.setVisibility(0);
        }
        this.cv_1.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                DashboardActivity.this.cv_1.startAnimation(AnimationUtils.loadAnimation(DashboardActivity.this, R.anim.viewpush));
                if (!DashboardActivity.this.isInputEnabled()) {
                    dilougeSerivce();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        this.mGetBackHereHandler.removeMessages(446);
        unregisterSettingsObserverNow();
    }

    public boolean isInputEnabled() {
        List<InputMethodInfo> enabledInputMethodList = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).getEnabledInputMethodList();
        int size = enabledInputMethodList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            InputMethodInfo inputMethodInfo = enabledInputMethodList.get(i);
            Log.d("INPUT ID", String.valueOf(inputMethodInfo.getId()));
            if (inputMethodInfo.getId().contains(getPackageName())) {
                z = true;
            }
        }
        return z;
    }

    public final void setupButtons() {
        if (this.mState == 2) {
            this.mState = 0;
            if (FontSet.INSTANCE.isThisKeyboardSetAsDefaultIME(this)) {
                Intent intent = new Intent(this, TestKeyboardActivity.class);
                Log.d("test", "starting test activity activity from main");
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
    }

    public final void unregisterSettingsObserverNow() {
        this.mGetBackHereHandler.removeMessages(447);
        getApplicationContext().getContentResolver().unregisterContentObserver(this.secureSettingsChanged);
    }

    public void openKeyboardChooser() {
        Object systemService = getSystemService(Context.INPUT_METHOD_SERVICE);
        if (systemService != null) {
            this.mState = 1;
            ((InputMethodManager) systemService).showInputMethodPicker();
        }
    }

    public boolean isInputEnabled2() {
        InputMethodManager inputMethodManager2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        this.inputMethodManager = inputMethodManager2;
        List<InputMethodInfo> enabledInputMethodList = inputMethodManager2.getEnabledInputMethodList();
        int size = enabledInputMethodList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            InputMethodInfo inputMethodInfo = enabledInputMethodList.get(i);
            Log.d("INPUT ID", String.valueOf(inputMethodInfo.getId()));
            if (inputMethodInfo.getId().contains(getPackageName())) {
                z = true;
            }
        }
        return z;
    }

    public final void enableKeyboard() {
        getApplicationContext().getContentResolver().registerContentObserver(Settings.Secure.CONTENT_URI, true, this.secureSettingsChanged);
        this.mGetBackHereHandler.removeMessages(447);
        Handler handler = this.mGetBackHereHandler;
        handler.sendMessageDelayed(handler.obtainMessage(447), 45000);
        Intent intent = new Intent("android.settings.INPUT_METHOD_SETTINGS");
        intent.setFlags(268435456);
        intent.addFlags(BasicMeasure.EXACTLY);
        intent.addFlags(8388608);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, (int) R.string.setup_wizard_step_one_action_error_no_settings_activity, 1).show();
        }
    }

    public final boolean isKeyboardEnabled(Context context2) {
        return FontSet.INSTANCE.isThisKeyboardEnabled(context2);
    }




    @Override 
    public void onResume() {
        super.onResume();
        if (isInputEnabled()) {

            this.iv_done.setVisibility(0);
        }


    }



    @Override
    public void onDestroy() {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        unregisterReceiver(this.inputMethodChangeReceiver);

        super.onDestroy();
    }


    @Override 
    public void onPause() {
        super.onPause();

    }


    @Override 
    public void onBackPressed() {
        this.onBackClick = true;

        LoadAds.getInstance(DashboardActivity.this)
                .showintersitialwithoutcounter(new OnIntersitialAdListener() {
                    @Override
                    public void onAdFailded() {
                        BackScreen();
                    }

                    @Override
                    public void onAdDismis() {
                        BackScreen();
                    }
                });




    }


    private void BackScreen() {
        if (this.onBackClick) {
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        Intent intent = new Intent(this, TestKeyboardActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }


    /**
     * Populates a {@link NativeAdView} object with data from a given {@link NativeAd}.
     *
     * @param nativeAd the object containing the ad's assets
     * @param adView   the view to be populated
     */
    private void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        // Set the media view.
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));

        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline and mediaContent are guaranteed to be in every NativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        // These assets aren't guaranteed to be in every NativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd);


    }

    /**
     * Creates a request for a new native ad based on the boolean parameters and calls the
     * corresponding "populate" method when one is successfully returned.
     */
    private void loadNativeAd() {


        AdLoader.Builder builder = new AdLoader.Builder(this, this.getResources().getString(R.string.admob_native_ad_id));

        builder.forNativeAd(
                new NativeAd.OnNativeAdLoadedListener() {
                    // OnLoadedListener implementation.
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        // If this callback occurs after the activity is destroyed, you must call
                        // destroy and return or you may get a memory leak.
                        boolean isDestroyed = false;

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            isDestroyed = isDestroyed();
                        }
                        if (isDestroyed || isFinishing() || isChangingConfigurations()) {
                            nativeAd.destroy();
                            return;
                        }
                        // You must call destroy on old ads when you are done with them,
                        // otherwise you will have a memory leak.
                        if (DashboardActivity.this.nativeAd != null) {
                            DashboardActivity.this.nativeAd.destroy();
                        }
                        DashboardActivity.this.nativeAd = nativeAd;
                        FrameLayout frameLayout = findViewById(R.id.fl_adplaceholder);
                        NativeAdView adView =
                                (NativeAdView) getLayoutInflater().inflate(R.layout.ad_unified, null);
                        populateNativeAdView(nativeAd, adView);
                        frameLayout.removeAllViews();
                        frameLayout.addView(adView);
                    }
                });


        AdLoader adLoader =
                builder
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {




                                    }
                                })
                        .build();

        adLoader.loadAd(new AdRequest.Builder().build());


    }

    private void  dilougeSerivce(){


          new AndExAlertDialog.Builder(context)
                .setTitle("Discolusure")
                .setMessage("We never collect and share your Data. By continuing to use this app you represent that you have read and accept the Terms of Service, Privacy Policy and Terms. \nPlease allow Keyboard Service To Active Fancy Keyboard")
                .setPositiveBtnText("Continue")
                .setNegativeBtnText("No")
                .setCancelableOnTouchOutside(true)


                .OnPositiveClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {
                        DashboardActivity.this.enableKeyboard();
                    }
                })
                .OnNegativeClicked(new AndExAlertDialogListener() {
                    @Override
                    public void OnClick(String input) {

                    }
                })
                .setTitleTextColor(getResources().getColor(R.color.colorPrimary))
                .setMessageTextColor(getResources().getColor(R.color.colorAccent))
                .setButtonTextColor(getResources().getColor(R.color.colorPrimary))
                .build();
    }


}
