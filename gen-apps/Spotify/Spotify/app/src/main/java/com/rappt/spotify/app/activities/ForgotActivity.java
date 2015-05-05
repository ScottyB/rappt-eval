package com.rappt.spotify.app.activities;

import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import com.rappt.spotify.app.model.*;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;
import com.rappt.spotify.app.*;
import android.webkit.WebView;



@EActivity(R.layout.forgot)

public class ForgotActivity extends FragmentActivity  {

    @ViewById
    public TextView userName;

    @ViewById
    public WebView aWebView ;

    public FragmentActivity context ;

    public AlertDialog dialog ;

    @App
    public SpotifyApplication app ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = this;

    }

    @AfterViews
    void setWebViewId() {
        aWebView.loadUrl(getString(R.string.aWebView_string));
        aWebView.setWebViewClient(new WebViewClient());
    }


    void loadingStarted() {
        dialog = ProgressDialog.show(context, "", "Please Wait...");
    }

    @UiThread
    void loadingFinished() {
        dialog.dismiss();
    }


}
