package com.fontskeyboard.cooltextstyle.skytechzone.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
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

import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {

    CardView cv_continue;
    private NativeAd nativeAd;
    RelativeLayout rel_setting;
    String version = "";
    private static final String TAG = "Home";


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();


        loadNativeAd();
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            version = pInfo.versionName;
            loadCounter();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        initDefine();
        this.cv_continue.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                LoadAds.getInstance(HomeActivity.this)
                        .showintersitialwithoutcounter(new OnIntersitialAdListener() {
                            @Override
                            public void onAdFailded() {
                                gotoNext();
                            }

                            @Override
                            public void onAdDismis() {
                                gotoNext();
                            }
                        });



            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rel_setting);
        this.rel_setting = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                LoadAds.getInstance(HomeActivity.this).showintersitialwithoutcounter(new OnIntersitialAdListener() {
                    @Override
                    public void onAdFailded() {
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                    }

                    @Override
                    public void onAdDismis() {
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                    }
                });

            }
        });


    }

    private void gotoNext() {

        HomeActivity.this.cv_continue.startAnimation(AnimationUtils.loadAnimation(HomeActivity.this, R.anim.viewpush));
        Intent intent = new Intent(HomeActivity.this, DashboardActivity.class);
        intent.addFlags(67108864);
        HomeActivity.this.startActivity(intent);
    }

    private void initDefine() {
        this.cv_continue = (CardView) findViewById(R.id.cv_continue);
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ExitActivity.class);
        startActivity(intent);
    }


    @Override
    public void onDestroy() {
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        super.onDestroy();

    }


    @Override
    public void onPause() {
        super.onPause();

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
                        if (HomeActivity.this.nativeAd != null) {
                            HomeActivity.this.nativeAd.destroy();
                        }
                        HomeActivity.this.nativeAd = nativeAd;
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






    private void loadCounter() {
        RequestQueue requestQueue;

// Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

// Start the queue
        requestQueue.start();

        String url = "https://admin.skytechzone.net/web/app_detail.php?app_name=FontsKeyboard&account_name=Skyedge";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: getCounterData " + response.toString());


                try {
                    if (response.getBoolean("status")) {
                        JSONObject jsonObject = response.getJSONObject("data");
                        String server_version = jsonObject.getString("version");
                        String meessge = jsonObject.getString("message");

                        if (version != null) {
                            if (!version.isEmpty()) {

                                if (!server_version.equals(version)) {

                                    showUpdateDilouge(meessge);

                                }

                            }
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });


        requestQueue.add(jsonObjReq);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                7000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

    }

    private void showUpdateDilouge(String meessge) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MaterialAlertDialog_rounded);
        builder.setTitle("Update Notice");
        builder.setMessage((CharSequence) meessge);
        builder.setCancelable(false);

        builder.setPositiveButton((CharSequence) "Update", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                String packageName = HomeActivity.this.getPackageName();
                StringBuilder sb = new StringBuilder();
                sb.append("https://play.google.com/store/apps/details?id=");
                sb.append(packageName);
                HomeActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
            }
        });

        builder.setNegativeButton((CharSequence) "Later", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }
}
