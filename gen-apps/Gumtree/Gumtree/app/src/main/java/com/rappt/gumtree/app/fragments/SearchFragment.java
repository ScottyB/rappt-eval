package com.rappt.gumtree.app.fragments;

import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.gumtree.app.activities.*;
import android.support.v4.app.Fragment;
import com.rappt.gumtree.app.*;
import android.widget.EditText;



@EFragment(R.layout.search)

public class SearchFragment extends Fragment  {

    @ViewById
    public EditText keywords ;


    @Click
    void clear ( ) {}

    @Click
    void search ( ) {}



}
