package com.rappt.cleanmaster.app.fragments;

import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.cleanmaster.app.*;
import android.support.v4.app.Fragment;
import com.rappt.cleanmaster.app.activities.*;



@EFragment(R.layout.mycloud)
@OptionsMenu( {R.menu.mycloud})

public class MyCloudFragment extends Fragment  {

    @Click
    void fbk ( ) {}

    @Click
    void google ( ) {}

    @Click
    void email ( ) {}

    @OptionsItem
    void signIn ( ) {}


}
