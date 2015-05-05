package com.rappt.cleanmaster.app.fragments;

import org.androidannotations.annotations.*;
import com.rappt.cleanmaster.app.*;
import android.support.v4.app.Fragment;
import com.rappt.cleanmaster.app.activities.*;



@EFragment(R.layout.home)
@OptionsMenu( {R.menu.home})

public class HomeFragment extends Fragment  {

    @Click
    void junkBttn ( ) {}

    @Click
    void phoneBttn ( ) {}

    @Click
    void antiBttn ( ) {}

    @Click
    void appBttn ( ) {}

    @OptionsItem
    void lock ( ) {}

    @OptionsItem
    void recomended ( ) {}


}
