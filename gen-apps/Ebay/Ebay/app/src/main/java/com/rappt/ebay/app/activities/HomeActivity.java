package com.rappt.ebay.app.activities;

import org.androidannotations.annotations.*;
import de.greenrobot.event.EventBus;
import android.widget.TextView;
import com.rappt.ebay.app.*;
import android.support.v4.app.FragmentActivity;
import com.rappt.ebay.app.activities.*;
import com.rappt.ebay.app.model.*;



@EActivity(R.layout.home)
@OptionsMenu( {R.menu.home})

public class HomeActivity extends FragmentActivity  {

    @Click
    void searchBttn ( ) {}

    @Click
    void signInButton ( ) {
        HomeToSignIn event = new HomeToSignIn();
        EventBus.getDefault().postSticky(event);
        TabbarActivity_.intent(this).start();

    }

    @Click
    void registerButton ( ) {
        HomeToRegister event = new HomeToRegister();
        EventBus.getDefault().postSticky(event);
        TabbarActivity_.intent(this).start();

    }

    @OptionsItem
    void shopAction ( ) {
        HomeToSignIn event = new HomeToSignIn();
        EventBus.getDefault().postSticky(event);
        TabbarActivity_.intent(this).start();

    }


}
