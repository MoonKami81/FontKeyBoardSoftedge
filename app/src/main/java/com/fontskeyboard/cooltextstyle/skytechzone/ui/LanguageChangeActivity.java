package com.fontskeyboard.cooltextstyle.skytechzone.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fontskeyboard.cooltextstyle.skytechzone.db.SharedPreferencecDb;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.fontskeyboard.cooltextstyle.skytechzone.R;
import com.fontskeyboard.cooltextstyle.skytechzone.adsutils.LoadAds;
import com.fontskeyboard.cooltextstyle.skytechzone.adsutils.OnIntersitialAdListener;

public class LanguageChangeActivity extends AppCompatActivity {

    private RadioButton arabic;

    private RadioButton chi;
    private RadioButton eng;
    private RadioButton gujarati;
    private RadioButton hindi;

    private RadioButton jap;
    private RadioGroup radiogroup;

    private RadioButton russian;
    RecyclerView rv_langkey;
    SharedPreferencecDb sharedPreferenceAapnar;
    private RadioButton thai;
    private RadioButton urdu;
    private NativeAd nativeAd;
    @Override
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setContentView(R.layout.page_change_lang);
            loadNativeAd();
            getSupportActionBar().hide();
            this.sharedPreferenceAapnar = new SharedPreferencecDb(this);
            initView();
            this.rv_langkey.setLayoutManager(new GridLayoutManager(this, 2));
            this.rv_langkey.setAdapter(new KeyboardLang(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSetLanguage(View view) {
        switch (this.radiogroup.getCheckedRadioButtonId()) {
            case R.id.arabic:
                this.sharedPreferenceAapnar.setLanguage("arab", 5);
                break;
            case R.id.chinese:
                this.sharedPreferenceAapnar.setLanguage("chi", 4);
                break;
            case R.id.eng:
                this.sharedPreferenceAapnar.setLanguage("eng", 0);
                break;

            case R.id.hindi:
                this.sharedPreferenceAapnar.setLanguage("hindi", 7);
                break;
            case R.id.jap:
                this.sharedPreferenceAapnar.setLanguage("jap", 1);
                break;
            case R.id.russian:
                this.sharedPreferenceAapnar.setLanguage("rus", 2);
                break;
            case R.id.thai:
                this.sharedPreferenceAapnar.setLanguage("thai", 3);
                break;
            case R.id.urdu:
                this.sharedPreferenceAapnar.setLanguage("urdu", 6);
                break;
        }
        this.sharedPreferenceAapnar.isKeyboardChanged(true);
        finish();
    }

    private void initView() {
        this.radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        this.eng = (RadioButton) findViewById(R.id.eng);
        this.jap = (RadioButton) findViewById(R.id.jap);
        this.russian = (RadioButton) findViewById(R.id.russian);
        this.thai = (RadioButton) findViewById(R.id.thai);
        this.chi = (RadioButton) findViewById(R.id.chinese);
        this.gujarati = (RadioButton) findViewById(R.id.gujarati);
        this.arabic = (RadioButton) findViewById(R.id.arabic);
        this.urdu = (RadioButton) findViewById(R.id.urdu);
        this.hindi = (RadioButton) findViewById(R.id.hindi);
        this.rv_langkey = (RecyclerView) findViewById(R.id.rv_langkey);
        setupLang();
    }

    private void setupLang() {
        char c = 0;
        switch (this.sharedPreferenceAapnar.getLanguagepos().intValue()) {
            case 1:
                c = 1;
                break;
            case 2:
                c = 2;
                break;
            case 3:
                c = 3;
                break;
            case 4:
                c = 4;
                break;
            case 5:
                c = 5;
                break;
            case 6:
                c = 6;
                break;
            case 7:
                c = 7;
                break;

        }
        if (c == 0) {
            this.eng.setChecked(true);
        } else if (c == 1) {
            this.jap.setChecked(true);
        } else if (c == 2) {
            this.russian.setChecked(true);
        } else if (c == 3) {
            this.thai.setChecked(true);
        } else if (c == 4) {
            this.chi.setChecked(true);
        }  else if (c == 5) {
            this.arabic.setChecked(true);
        } else if (c == 6) {
            this.urdu.setChecked(true);
        } else {
            this.hindi.setChecked(true);
        }
    }

  
    @Override 
    public void onResume() {
        super.onResume();
        int intValue = this.sharedPreferenceAapnar.getLanguagepos().intValue();
        if (intValue == 0) {
            this.sharedPreferenceAapnar.setLanguage("eng", 0);
        } else if (intValue == 1) {
            this.sharedPreferenceAapnar.setLanguage("jap", 1);
        } else if (intValue == 2) {
            this.sharedPreferenceAapnar.setLanguage("rus", 2);
        } else if (intValue == 3) {
            this.sharedPreferenceAapnar.setLanguage("thai", 3);
        } else if (intValue == 4) {
            this.sharedPreferenceAapnar.setLanguage("chi", 4);

        }else if (intValue == 6) {
            this.sharedPreferenceAapnar.setLanguage("arab", 5);
        } else if (intValue == 7) {
            this.sharedPreferenceAapnar.setLanguage("urdu", 6);
        } else if (intValue == 8) {
            this.sharedPreferenceAapnar.setLanguage("hindi", 7);
        }

    }









    @Override 
    public void onBackPressed() {
        LoadAds.getInstance(LanguageChangeActivity.this)
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



    public void BackScreen() {
        finish();
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
                        if (LanguageChangeActivity.this.nativeAd != null) {
                            LanguageChangeActivity.this.nativeAd.destroy();
                        }
                        LanguageChangeActivity.this.nativeAd = nativeAd;
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

    @Override
    protected void onDestroy() {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();
    }
}
