package com.rappt.tripviewlite.app.activities;

import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;
import android.webkit.WebView;
import com.rappt.tripviewlite.app.model.*;
import com.rappt.tripviewlite.app.*;



@EActivity(R.layout.delaydetail)

public class DelayDetailActivity extends FragmentActivity  {

    @App
    public TripViewLiteApplication app ;

    @ViewById
    public TextView message ;

    @ViewById
    public WebView aWebView ;

    public FragmentActivity context ;

    public AlertDialog dialog ;


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
