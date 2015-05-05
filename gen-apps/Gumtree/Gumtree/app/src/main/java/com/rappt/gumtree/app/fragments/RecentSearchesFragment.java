package com.rappt.gumtree.app.fragments;

import android.os.Bundle;
import com.rappt.gumtree.app.model.*;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import com.rappt.gumtree.app.adapters.*;
import com.rappt.gumtree.app.views.*;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import java.util.List;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import com.rappt.gumtree.app.activities.*;
import android.view.View;
import android.widget.ListView;
import com.rappt.gumtree.app.*;



@EFragment(R.layout.recentsearches)

public class RecentSearchesFragment extends Fragment  {

    @App
    public GumtreeApplication app ;

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
        context = getActivity();

    }


    @ItemClick
    void listId ( ) {}

    @Background
    void callGumtreeMockrecentSearches ( ) {
        try {
            handleResponse(app.gumtreeMock.recentSearches());
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
        callGumtreeMockrecentSearches();
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
