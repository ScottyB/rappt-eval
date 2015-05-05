package com.rappt.domain.app.fragments;

import org.androidannotations.annotations.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.Fragment;
import com.rappt.domain.app.*;
import com.rappt.domain.app.activities.*;
import com.google.android.gms.maps.GoogleMap;
import org.androidannotations.annotations.res.StringRes;
import com.google.android.gms.maps.MapFragment;



@EFragment(R.layout.search)
@OptionsMenu( {R.menu.search})

public class SearchFragment extends Fragment  {

    public GoogleMap googleMap ;

    @StringRes(R.string.marker_sydneyId_title)
    public String sydneyIdTitle ;

    @FragmentById
    public MapFragment mapId ;


    @AfterViews
    void initMap ( ) {
        googleMap = mapId.getMap();
        googleMap.addMarker(new MarkerOptions()
                            .title(sydneyIdTitle)
                            .position(new LatLng(-33.867, 151.206)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.867, 151.206), 13));
    }

    @Click
    void registerBttn ( ) {}

    @Click
    void signInBttn ( ) {}

    @OptionsItem
    void notificationId ( ) {
        NotificationsActivity_.intent(getActivity()).start();

    }


}
