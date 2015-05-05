package com.rappt.cleanmaster.app.fragments;

import com.rappt.cleanmaster.app.*;
import android.os.Bundle;
import com.rappt.cleanmaster.app.model.*;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import com.rappt.cleanmaster.app.views.*;
import com.rappt.cleanmaster.app.activities.*;
import com.rappt.cleanmaster.app.adapters.*;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import java.util.List;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;



@EFragment(R.layout.hot)

public class HotFragment extends Fragment  {

    @ViewById
    public TextView message ;

    @Bean
    public ListIdAdapter adapter ;

    @App
    public CleanMasterApplication app ;

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
    void callCleanMasterApihotApps ( ) {
        try {
            handleResponse(app.cleanMasterApi.hotApps());
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (List<Hot> data) {
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
        callCleanMasterApihotApps();
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
