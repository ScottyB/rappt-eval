package com.rappt.centrelink.app.fragments;

import com.rappt.centrelink.app.*;
import org.androidannotations.annotations.*;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.app.Fragment;
import com.google.android.gms.maps.GoogleMap;
import com.rappt.centrelink.app.activities.*;
import org.androidannotations.annotations.res.StringRes;
import com.google.android.gms.maps.MapFragment;



@EFragment(R.layout.mapscreen)

public class MapScreenFragment extends Fragment  {

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


}
