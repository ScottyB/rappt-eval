package com.rappt.netflix.app.activities;

import org.androidannotations.annotations.*;
import com.rappt.netflix.app.activities.*;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import com.rappt.netflix.app.*;



@EActivity(R.layout.home)
@OptionsMenu( {R.menu.home})

public class HomeActivity extends FragmentActivity  {

    @ViewById
    public WebView WebViewId ;

    public FragmentActivity context ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = this;

    }

    @AfterViews
    void setWebViewId() {
        WebViewId.loadUrl(getString(R.string.webViewId_string));
        WebViewId.setWebViewClient(new WebViewClient());
    }


    @OptionsItem
    void signInAction ( ) {
        SignInActivity_.intent(this).start();

    }


}
