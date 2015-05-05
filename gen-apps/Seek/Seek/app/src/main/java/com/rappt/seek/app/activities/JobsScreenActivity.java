package com.rappt.seek.app.activities;

import com.rappt.seek.app.*;
import android.os.Bundle;
import com.rappt.seek.app.adapters.*;
import com.rappt.seek.app.views.*;
import android.app.ProgressDialog;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import java.util.List;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;
import com.rappt.seek.app.model.*;



@EActivity(R.layout.jobsscreen)

public class JobsScreenActivity extends FragmentActivity  {

    @App
    public SeekApplication app ;

    @ViewById
    public TextView message ;

    @Bean
    public ListIdAdapter adapter ;

    @ViewById
    public ListView listId ;

    public FragmentActivity context ;

    public AlertDialog dialog ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = this;

    }

    @Click
    void favBttn ( ) {}


    @ItemClick
    void listId ( ) {}

    @Background
    void callSeekAPIMocksearchResults ( ) {
        try {
            handleResponse(app.seekAPIMock.searchResults());
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (List<Search> data) {
        if (data.isEmpty()) {
            message.setText(R.string.message_no_data);
        } else {
            message.setVisibility(View.GONE);
            listId.setVisibility(View.VISIBLE);
            adapter.setData(data);
            adapter.notifyDataSetChanged();
        }
    }

    @AfterViews
    void init ( ) {
        callSeekAPIMocksearchResults();
        loadingStarted();
        listId.setAdapter(adapter);

    }

    void loadingStarted() {
        dialog = ProgressDialog.show(context, "", "Please Wait...");
    }

    @UiThread
    void loadingFinished() {
        dialog.dismiss();
    }


}
