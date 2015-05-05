package com.rappt.gumtree.app;

import org.androidannotations.annotations.EApplication;
import retrofit.RequestInterceptor;
import com.rappt.gumtree.app.model.*;
import android.app.Application;
import retrofit.RestAdapter;



@EApplication
public class GumtreeApplication extends Application  {

    public GumtreeMockApi gumtreeMock ;

    public String GUMTREEMOCK_SERVICE = "http://mock-gumtree-api-url";

    public static boolean IS_OFFLINE = true;


    public GumtreeMockApi setupGumtreeMockApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(GUMTREEMOCK_SERVICE)
        .build();
        return restAdapter.create(GumtreeMockApi.class);
    }


    public GumtreeApplication () {
        gumtreeMock = IS_OFFLINE ? new OfflineGumtreeMockApi(this) : setupGumtreeMockApi();
    }


}
