package com.rappt.domain.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import com.rappt.domain.app.views.*;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import java.util.List;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import com.rappt.domain.app.model.*;
import com.rappt.domain.app.*;
import android.view.View;
import com.rappt.domain.app.activities.*;
import android.widget.ListView;
import com.rappt.domain.app.adapters.*;



@EFragment(R.layout.recent)

public class RecentFragment extends Fragment  {

    @ViewById
    public TextView message ;

    @Bean
    public ListIdAdapter adapter ;

    @App
    public DomainApplication app ;

    @ViewById
    public ListView listId ;

    public FragmentActivity context ;

    public AlertDialog dialog ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = getActivity();

    }


    @ItemClick
    void listId ( ) {}

    @Background
    void callDomainAPIrecentResults ( ) {
        try {
            handleResponse(app.domainAPI.recentResults());
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (List<Recent> data) {
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
        callDomainAPIrecentResults();
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
