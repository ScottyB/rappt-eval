package com.rappt.commbank.app.fragments;

import com.rappt.commbank.app.activities.*;
import org.androidannotations.annotations.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.rappt.commbank.app.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.Fragment;
import com.google.android.gms.maps.GoogleMap;
import org.androidannotations.annotations.res.StringRes;
import com.google.android.gms.maps.MapFragment;



@EFragment(R.layout.atm)

public class ATMFragment extends Fragment  {

    public GoogleMap googleMap ;

    @StringRes(R.string.marker_atmMarker_description)
    public String atmMarkerDescription ;

    @FragmentById
    public MapFragment mapId ;

    @StringRes(R.string.marker_atmMarker_title)
    public String atmMarkerTitle ;


    @AfterViews
    void initMap ( ) {
        googleMap = mapId.getMap();
        googleMap.addMarker(new MarkerOptions()
                            .title(atmMarkerTitle)
                            .snippet(atmMarkerDescription)
                            .position(new LatLng(-33.867, 151.206)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.867, 151.206), 13));
    }


}
