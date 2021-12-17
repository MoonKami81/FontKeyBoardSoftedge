package com.fontskeyboard.cooltextstyle.skytechzone.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.fontskeyboard.cooltextstyle.skytechzone.R;

public class PrivacyPolicyActivity extends Activity {
    private static Dialog loading_dialog;
    private static TextView loading_dialog_message;
    protected WebView webView;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.eu_consent_privacy_policy);
        WebView webView2 = (WebView) findViewById(R.id.webView);
        this.webView = webView2;
        webView2.setWebViewClient(new MyWebViewClient());
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setSupportZoom(true);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.loadUrl(Constant.privacy_policy_url);
    }

    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            PrivacyPolicyActivity.this.ShowLoadingDialog("Fetching Privacy & Policy");
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            PrivacyPolicyActivity.DismissLoadingDialog();
        }
    }

    public void LoadingDialog(String str) {
        Dialog dialog = new Dialog(this);
        loading_dialog = dialog;
        dialog.requestWindowFeature(1);
        loading_dialog.setContentView(R.layout.dialog_loading);
        loading_dialog_message = (TextView) loading_dialog.findViewById(R.id.dialog_loading_txt_message);
        loading_dialog_message.setTypeface(Typeface.createFromAsset(getAssets(), Constant.roboto_font_path));
        loading_dialog_message.setText(str);
        loading_dialog.show();
    }


    private void ShowLoadingDialog(String str) {
        LoadingDialog(str);
    }


    public static void DismissLoadingDialog() {
        Dialog dialog = loading_dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void onBackPressed() {
        BackScreen();
    }


    public void BackScreen() {
        finish();
    }
}
