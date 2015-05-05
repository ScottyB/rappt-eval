package com.rappt.tripviewlite.app;

import org.androidannotations.annotations.EApplication;
import retrofit.RequestInterceptor;
import android.app.Application;
import com.rappt.tripviewlite.app.model.*;
import retrofit.RestAdapter;



@EApplication
public class TripViewLiteApplication extends Application  {

    public String TRIPVIEWAPI_SERVICE = "http://mock-tripview-api-url";

    public TripViewAPIApi tripViewAPI ;

    public static boolean IS_OFFLINE = true;


    public TripViewAPIApi setupTripViewAPIApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(TRIPVIEWAPI_SERVICE)
        .build();
        return restAdapter.create(TripViewAPIApi.class);
    }


    public TripViewLiteApplication () {
        tripViewAPI = IS_OFFLINE ? new OfflineTripViewAPIApi(this) : setupTripViewAPIApi();
    }


}
