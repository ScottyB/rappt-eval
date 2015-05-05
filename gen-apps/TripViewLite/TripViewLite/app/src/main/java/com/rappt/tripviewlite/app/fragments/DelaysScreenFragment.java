package com.rappt.tripviewlite.app.fragments;

import com.rappt.tripviewlite.app.activities.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import com.rappt.tripviewlite.app.adapters.*;
import com.rappt.tripviewlite.app.model.*;
import com.rappt.tripviewlite.app.*;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import java.util.List;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import com.rappt.tripviewlite.app.views.*;
import android.view.View;
import android.widget.ListView;



@EFragment(R.layout.delaysscreen)

public class DelaysScreenFragment extends Fragment  {

    @App
    public TripViewLiteApplication app ;

    @ViewById
    public TextView message ;

    public List<Delays> data ;

    @Bean
    public ListIdAdapter adapter ;

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
    void listId (Delays data) {
        DelayDetailActivity_.intent(getActivity()).start();

    }

    @Background
    void callTripViewAPIdelays ( ) {
        try {
            handleResponse(app.tripViewAPI.delays());
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (List<Delays> data) {
        this.data = data;
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
        callTripViewAPIdelays();
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
