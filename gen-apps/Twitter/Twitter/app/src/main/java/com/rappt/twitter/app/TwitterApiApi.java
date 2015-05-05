package com.rappt.twitter.app;

import com.rappt.twitter.app.model.*;
import java.util.List;
import android.net.Uri;
import retrofit.http.*;


public interface TwitterApiApi {


    @GET("/statuses/home_timeline.json")

    List<HomeTimeline> getHomeTimeline ( );
    @GET("/statuses/user_timeline.json")

    List<UserTimeline> getUserTimeline ( );
    @GET("/statuses/show/{id}.json")

    Show getTweet (@Path("id") String id);
    @POST("/statuses/update.json")

    Update postTweet (@Body Update update);
}
