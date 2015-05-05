package com.rappt.centrelink.app.activities;

import com.rappt.centrelink.app.*;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import com.rappt.centrelink.app.activities.*;



@EActivity(R.layout.express)

public class ExpressActivity extends FragmentActivity  {

    @Click
    void acceptButton ( ) {
        LoginActivity_.intent(this).start();

    }


}
