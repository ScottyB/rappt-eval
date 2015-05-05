package com.rappt.centrelink.app.activities;

import com.rappt.centrelink.app.*;
import org.androidannotations.annotations.*;
import de.greenrobot.event.EventBus;
import android.support.v4.app.FragmentActivity;
import com.rappt.centrelink.app.activities.*;
import com.rappt.centrelink.app.model.*;



@EActivity(R.layout.home)

public class HomeActivity extends FragmentActivity  {

    @Click
    void startButton ( ) {
        ExpressActivity_.intent(this).start();

    }

    @Click
    void mapbutton ( ) {
        HomeToMapScreen event = new HomeToMapScreen();
        EventBus.getDefault().postSticky(event);
        TabbarActivity_.intent(this).start();

    }


}
