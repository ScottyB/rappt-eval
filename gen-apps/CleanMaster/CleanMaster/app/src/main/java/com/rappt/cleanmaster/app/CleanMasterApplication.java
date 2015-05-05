package com.rappt.cleanmaster.app;

import org.androidannotations.annotations.EApplication;
import retrofit.RequestInterceptor;
import android.app.Application;
import com.rappt.cleanmaster.app.model.*;
import retrofit.RestAdapter;



@EApplication
public class CleanMasterApplication extends Application  {

    public String CLEANMASTERAPI_SERVICE = "http://mock-clean-master-api-url";

    public CleanMasterApiApi cleanMasterApi ;

    public static boolean IS_OFFLINE = true;


    public CleanMasterApiApi setupCleanMasterApiApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(CLEANMASTERAPI_SERVICE)
        .build();
        return restAdapter.create(CleanMasterApiApi.class);
    }


    public CleanMasterApplication () {
        cleanMasterApi = IS_OFFLINE ? new OfflineCleanMasterApiApi(this) : setupCleanMasterApiApi();
    }


}
