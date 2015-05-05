package com.rappt.gumtree.app;

import java.util.List;
import com.rappt.gumtree.app.model.*;
import retrofit.http.*;


public interface GumtreeMockApi {


    @GET("/recent")

    List<Recent> recentSearches ( );
}
