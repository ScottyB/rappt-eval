package com.rappt.tripviewlite.app;

import java.util.List;
import retrofit.http.*;
import com.rappt.tripviewlite.app.model.*;


public interface TripViewAPIApi {


    @GET("/delays")

    List<Delays> delays ( );
}
