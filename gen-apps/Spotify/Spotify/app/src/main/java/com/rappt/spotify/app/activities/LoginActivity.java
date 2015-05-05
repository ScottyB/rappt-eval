package com.rappt.spotify.app.activities;

import com.rappt.spotify.app.activities.*;
import org.androidannotations.annotations.*;
import com.rappt.spotify.app.model.*;
import de.greenrobot.event.EventBus;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import com.rappt.spotify.app.*;
import android.widget.EditText;



@EActivity(R.layout.login)

public class LoginActivity extends FragmentActivity  {

    @ViewById
    public EditText password ;

    @ViewById
    public EditText email ;


    @Click
    void fbk ( ) {}

    @Click
    void loginBttn ( ) {
        LoginToBrowse event = new LoginToBrowse();
        EventBus.getDefault().postSticky(event);
        DrawerActivity_.intent(this).start();

    }

    @Click
    void forgotBttn ( ) {
        ForgotActivity_.intent(this).start();

    }




}
