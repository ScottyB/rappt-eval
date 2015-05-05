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



@EFragment(R.layout.store)

public class StoreFragment extends Fragment  {

    public GoogleMap googleMap ;

    @StringRes(R.string.marker_storesId_title)
    public String storesIdTitle ;

    @FragmentById
    public MapFragment storeMapId ;


    @AfterViews
    void initMap ( ) {
        googleMap = storeMapId.getMap();
        googleMap.addMarker(new MarkerOptions()
                            .title(storesIdTitle)
                            .position(new LatLng(-33.867, 151.206)));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.867, 151.206), 13));
    }


}
