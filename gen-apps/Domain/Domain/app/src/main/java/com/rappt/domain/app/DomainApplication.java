package com.rappt.domain.app;

import org.androidannotations.annotations.EApplication;
import retrofit.RequestInterceptor;
import android.app.Application;
import com.rappt.domain.app.model.*;
import retrofit.RestAdapter;



@EApplication
public class DomainApplication extends Application  {

    public String DOMAINAPI_SERVICE = "http://mock-domain-api-url";

    public static boolean IS_OFFLINE = true;

    public DomainAPIApi domainAPI ;


    public DomainAPIApi setupDomainAPIApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(DOMAINAPI_SERVICE)
        .build();
        return restAdapter.create(DomainAPIApi.class);
    }


    public DomainApplication () {
        domainAPI = IS_OFFLINE ? new OfflineDomainAPIApi(this) : setupDomainAPIApi();
    }


}
