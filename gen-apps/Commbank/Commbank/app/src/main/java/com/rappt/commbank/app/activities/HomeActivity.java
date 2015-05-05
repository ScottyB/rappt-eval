package com.rappt.commbank.app.activities;

import com.rappt.commbank.app.activities.*;
import org.androidannotations.annotations.*;
import com.rappt.commbank.app.*;
import de.greenrobot.event.EventBus;
import android.support.v4.app.FragmentActivity;
import android.net.Uri;
import android.content.Intent;
import com.rappt.commbank.app.model.*;



@EActivity(R.layout.home)

public class HomeActivity extends FragmentActivity  {

    @Click
    void accountBttn ( ) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.accountBttn_url_string)));
        startActivity(intent);
    }

    @Click
    void bttn ( ) {
        HomeToATM event = new HomeToATM();
        EventBus.getDefault().postSticky(event);
        TabbarActivity_.intent(this).start();

    }


}
