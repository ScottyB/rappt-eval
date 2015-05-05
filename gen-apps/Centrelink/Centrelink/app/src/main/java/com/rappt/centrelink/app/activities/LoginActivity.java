package com.rappt.centrelink.app.activities;

import com.rappt.centrelink.app.*;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;



@EActivity(R.layout.login)

public class LoginActivity extends FragmentActivity  {

    @ViewById
    public EditText can ;

    @ViewById
    public EditText password ;




}
