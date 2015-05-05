package com.rappt.ebay.app.activities;

import org.androidannotations.annotations.*;
import android.os.Bundle;
import com.rappt.ebay.app.*;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebViewClient;
import android.webkit.WebView;



@EActivity(R.layout.password)

public class PasswordActivity extends FragmentActivity  {

    @ViewById
    public WebView aWebView ;

    public FragmentActivity context ;


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



}
