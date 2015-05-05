package com.rappt.seek.app;

import java.util.List;
import retrofit.http.*;
import com.rappt.seek.app.model.*;


public interface SeekAPIMockApi {


    @GET("/search")

    List<Search> searchResults ( );
}
