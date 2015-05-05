package com.rappt.cleanmaster.app;

import java.util.List;
import com.rappt.cleanmaster.app.model.*;
import retrofit.http.*;


public interface CleanMasterApiApi {


    @GET("/hot")

    List<Hot> hotApps ( );
}
