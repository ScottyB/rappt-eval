package com.rappt.gumtree.app.fragments;

import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.gumtree.app.activities.*;
import android.support.v4.app.Fragment;
import com.rappt.gumtree.app.*;
import android.widget.EditText;



@EFragment(R.layout.savedsearches)

public class SavedSearchesFragment extends Fragment  {

    @ViewById
    public EditText password ;

    @ViewById
    public EditText email ;


    @Click
    void signInBtn ( ) {}

    @Click
    void forgot ( ) {}

    @Click
    void create ( ) {}




}
