package com.rappt.seek.app.fragments;

import com.rappt.seek.app.*;
import org.androidannotations.annotations.*;
import com.rappt.seek.app.activities.*;
import android.support.v4.app.Fragment;
import android.widget.EditText;



@EFragment(R.layout.search)

public class SearchFragment extends Fragment  {

    @ViewById
    public EditText keywords ;


    @Click
    void registerBttn ( ) {}

    @Click
    void signInBttn ( ) {}

    @Click
    void searchBttn ( ) {
        JobsScreenActivity_.intent(getActivity()).start();

    }



}
