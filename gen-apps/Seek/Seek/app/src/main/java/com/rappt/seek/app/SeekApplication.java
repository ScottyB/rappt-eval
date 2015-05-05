package com.rappt.seek.app;

import org.androidannotations.annotations.EApplication;
import retrofit.RequestInterceptor;
import android.app.Application;
import com.rappt.seek.app.model.*;
import retrofit.RestAdapter;



@EApplication
public class SeekApplication extends Application  {

    public String SEEKAPIMOCK_SERVICE = "http://mock-seek-api-url";

    public SeekAPIMockApi seekAPIMock ;

    public static boolean IS_OFFLINE = true;


    public SeekAPIMockApi setupSeekAPIMockApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(SEEKAPIMOCK_SERVICE)
        .build();
        return restAdapter.create(SeekAPIMockApi.class);
    }


    public SeekApplication () {
        seekAPIMock = IS_OFFLINE ? new OfflineSeekAPIMockApi(this) : setupSeekAPIMockApi();
    }


}
