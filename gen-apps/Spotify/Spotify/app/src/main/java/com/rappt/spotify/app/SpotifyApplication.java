package com.rappt.spotify.app;

import org.androidannotations.annotations.EApplication;
import com.rappt.spotify.app.model.*;
import retrofit.RequestInterceptor;
import android.app.Application;
import retrofit.RestAdapter;



@EApplication
public class SpotifyApplication extends Application  {

    public SpotifyApiApi spotifyApi ;

    public String SPOTIFYAPI_SERVICE = "http://mock-spotify-api-url";

    public static boolean IS_OFFLINE = true;


    public SpotifyApiApi setupSpotifyApiApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(SPOTIFYAPI_SERVICE)
        .build();
        return restAdapter.create(SpotifyApiApi.class);
    }


    public SpotifyApplication () {
        spotifyApi = IS_OFFLINE ? new OfflineSpotifyApiApi(this) : setupSpotifyApiApi();
    }


}
