package com.rappt.spotify.app.activities;

import com.rappt.spotify.app.activities.*;
import org.androidannotations.annotations.*;
import android.support.v4.app.FragmentActivity;
import com.rappt.spotify.app.*;



@EActivity(R.layout.home)

public class HomeActivity extends FragmentActivity  {

    @Click
    void loginBttnId ( ) {
        LoginActivity_.intent(this).start();

    }

    @Click
    void signUpBttn ( ) {}


}
