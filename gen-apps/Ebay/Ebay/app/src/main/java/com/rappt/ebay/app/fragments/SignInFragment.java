package com.rappt.ebay.app.fragments;

import org.androidannotations.annotations.*;
import com.rappt.ebay.app.*;
import android.support.v4.app.Fragment;
import com.rappt.ebay.app.activities.*;
import android.widget.EditText;



@EFragment(R.layout.signin)

public class SignInFragment extends Fragment  {

    @ViewById
    public EditText password ;

    @ViewById
    public EditText email ;


    @Click
    void forgotPassword ( ) {
        PasswordActivity_.intent(getActivity()).start();

    }

    @Click
    void signInButton1 ( ) {}




}
