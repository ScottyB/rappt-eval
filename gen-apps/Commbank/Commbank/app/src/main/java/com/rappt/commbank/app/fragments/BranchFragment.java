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



@EFragment(R.layout.branch)

public class BranchFragment extends Fragment  {

    public GoogleMap googleMap ;

    @FragmentById
    public MapFragment branchMapId ;

    @StringRes(R.string.marker_branchMarker_title)
    public String branchMarkerTitle ;

    @StringRes(R.string.marker_branchMarker_description)
    public String branchMarkerDescription ;


    @AfterViews
    void initMap ( ) {
        googleMap = branchMapId.getMap();
        googleMap.addMarker(new MarkerOptions()
                            .title(branchMarkerTitle)
                            .snippet(branchMarkerDescription)
                            .position(new LatLng(-33.867, 151.206)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.867, 151.206), 13));
    }


}
