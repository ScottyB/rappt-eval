package com.rappt.spotify.app;

import com.rappt.spotify.app.model.*;
import retrofit.http.*;


public interface SpotifyApiApi {


    @GET("/browse")

    Browse browseEndpoint ( );
}
