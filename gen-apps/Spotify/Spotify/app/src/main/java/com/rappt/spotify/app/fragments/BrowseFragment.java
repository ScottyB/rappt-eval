package com.rappt.spotify.app.fragments;

import com.rappt.spotify.app.model.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import com.rappt.spotify.app.*;
import com.rappt.spotify.app.adapters.*;
import com.rappt.spotify.app.activities.*;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import java.util.List;
import android.widget.TextView;
import com.rappt.spotify.app.views.*;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ListView;



@EFragment(R.layout.browse)

public class BrowseFragment extends Fragment  {

    @ViewById
    public TextView message ;

    @Bean
    public ListIdAdapter adapter ;

    @ViewById
    public ListView listId ;

    public FragmentActivity context ;

    public AlertDialog dialog ;

    @App
    public SpotifyApplication app ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = getActivity();

    }

    @Click
    void topBttn ( ) {}

    @Click
    void newBttn ( ) {}


    @ItemClick
    void listId ( ) {}

    @Background
    void callSpotifyApibrowseEndpoint ( ) {
        try {
            handleResponse(app.spotifyApi.browseEndpoint());
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (Browse data) {
        if (data.results.isEmpty()) {
            message.setText(R.string.message_no_data);
        } else {
            message.setVisibility(View.GONE);
            listId.setVisibility(View.VISIBLE);
            adapter.setData(data.results);
            adapter.notifyDataSetChanged();
        }
    }

    @AfterViews
    void init ( ) {
        callSpotifyApibrowseEndpoint();
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
