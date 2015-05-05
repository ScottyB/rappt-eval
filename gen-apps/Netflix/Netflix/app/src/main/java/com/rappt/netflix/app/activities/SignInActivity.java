package com.rappt.netflix.app.activities;

import org.androidannotations.annotations.*;
import com.rappt.netflix.app.activities.*;
import android.support.v4.app.FragmentActivity;
import android.net.Uri;
import android.content.Intent;
import android.widget.EditText;
import com.rappt.netflix.app.*;



@EActivity(R.layout.signin)
@OptionsMenu( {R.menu.signin})

public class SignInActivity extends FragmentActivity  {

    @ViewById
    public EditText password ;

    @ViewById
    public EditText email ;


    @Click
    void signInBtn ( ) {}

    @Click
    void forgot ( ) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.forgot_url_string)));
        startActivity(intent);
    }



    @OptionsItem
    void aboutIdAction ( ) {
        AboutIdActivity_.intent(this).start();

    }


}
