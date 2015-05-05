package com.rappt.domain.app;

import java.util.List;
import com.rappt.domain.app.model.*;
import retrofit.http.*;


public interface DomainAPIApi {


    @GET("/recent")

    List<Recent> recentResults ( );
}
