package com.rappt.twitter.app.activities;

import com.google.android.gms.maps.CameraUpdateFactory;
import android.os.Bundle;
import com.google.android.gms.maps.model.LatLng;
import android.app.NotificationManager;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.ImageView;
import android.app.ProgressDialog;
import android.app.AlertDialog;
import org.androidannotations.annotations.*;
import com.rappt.twitter.app.model.*;
import android.widget.TextView;
import com.rappt.twitter.app.*;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.maps.GoogleMap;
import org.androidannotations.annotations.res.StringRes;
import com.google.android.gms.maps.MapFragment;



@EActivity(R.layout.tweetdetails)

public class TweetDetailsActivity extends FragmentActivity  {

    @StringRes(R.string.marker_entryLocation_description)
    public String entryLocationDescription ;

    @StringRes(R.string.notificationId_title_string)
    public String notificationIdTitleResource ;

    @StringRes(R.string.marker_entryLocation_title)
    public String entryLocationTitle ;

    @ViewById
    public ImageView tweetDetailUrlId ;

    @ViewById
    public TextView tweetDetailTxtId ;

    @ViewById
    public TextView tweetDetailRetweetId ;

    public AlertDialog dialog ;

    @StringRes(R.string.notificationId_content_string)
    public String notificationIdContentResource ;

    @App
    public TwitterApplication app ;

    public GoogleMap googleMap ;

    @ViewById
    public TextView tweetDetailCreatedAtId ;

    @ViewById
    public TextView message ;

    @ViewById
    public TextView tweetDetailNameId ;

    @Extra
    public String passedIdPassed ;

    @FragmentById
    public MapFragment mapId3 ;

    public FragmentActivity context ;


    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        context = this;

    }

    void mapId3Method ( ) {
        notificationIdMethod(0, notificationIdTitleResource, notificationIdContentResource);
    }

    @AfterViews
    void initMap ( ) {
        googleMap = mapId3.getMap();
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mapId3Method();
            }
        });
        googleMap.addMarker(new MarkerOptions()
                            .title(entryLocationTitle)
                            .snippet(entryLocationDescription)
                            .position(new LatLng(-37.702225, 144.57202)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-37.702225, 144.57202), 13));
    }


    @Background
    void callTwitterApigetTweet ( ) {
        try {
            handleResponse(app.twitterApi.getTweet(passedIdPassed));
        } catch (Exception e) {
            ErrorDialog.showError(context, e);
        }
        loadingFinished();
    }

    @UiThread
    void handleResponse (Show data) {
        this.tweetDetailNameId.setText(data.user.screenName);
        this.tweetDetailCreatedAtId.setText(data.createdAt);
        this.tweetDetailRetweetId.setText(data.retweetCount);
        this.tweetDetailUrlId.setText(data.user.profileImageUrlHttps);


    }

    @AfterViews
    void init ( ) {
        callTwitterApigetTweet();
        loadingStarted();
    }

    void loadingStarted() {
        dialog = ProgressDialog.show(context, "", "Please Wait...");
    }

    @UiThread
    void loadingFinished() {
        dialog.dismiss();
    }

    void notificationIdMethod (int id   , String  title, String  content) {
        NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_launcher)
        .setContentTitle(title)
        .setContentText(content);
        NotificationManager mNotifyMgr =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(id, mBuilder.build());
    }


}
