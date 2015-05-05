package com.rappt.tripviewlite.app.activities;

import org.androidannotations.annotations.*;
import de.greenrobot.event.EventBus;
import com.rappt.tripviewlite.app.activities.*;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import com.rappt.tripviewlite.app.model.*;
import com.rappt.tripviewlite.app.*;



@EActivity(R.layout.home)
@OptionsMenu( {R.menu.home})

public class HomeActivity extends FragmentActivity  {

    @OptionsItem
    void serviceAction ( ) {
        HomeToDelaysScreen event = new HomeToDelaysScreen();
        EventBus.getDefault().postSticky(event);
        TabbarActivity_.intent(this).start();

    }

    @OptionsItem
    void mapsAction ( ) {}

    @OptionsItem
    void settingsAction ( ) {}

    @OptionsItem
    void aboutAction ( ) {}


}
