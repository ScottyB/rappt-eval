package com.rappt.twitter.app.activities;

import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import com.rappt.twitter.app.model.*;
import com.rappt.twitter.app.*;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;



@EActivity(R.layout.newtweet)

public class NewTweetActivity extends FragmentActivity  {

    @ViewById
    public TextView message ;

    @ViewById
    public EditText inputId ;

    public FragmentActivity context ;

    public AlertDialog dialog ;

    @App
    public TwitterApplication app ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = this;

    }

    @Background
    void callTwitterApipostTweet ( ) {
        try {
            handleResponse(app.twitterApi.postTweet(buildDataTwitterApipostTweet()));
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (Update data) {
        Toast.makeText(context, R.string.toastId_string, Toast.LENGTH_LONG).show();

    }

    Update buildDataTwitterApipostTweet ( ) {
        Update update = new Update();

        update.dataSource1 = this.inputId.getText().toString();

        return update;
    }

    @Click
    void submit ( ) {
        callTwitterApipostTweet();
        loadingStarted();
    }


    void loadingStarted() {
        dialog = ProgressDialog.show(context, "", "Please Wait...");
    }

    @UiThread
    void loadingFinished() {
        dialog.dismiss();
    }


}
