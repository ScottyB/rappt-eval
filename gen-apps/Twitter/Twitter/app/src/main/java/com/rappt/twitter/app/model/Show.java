package com.rappt.twitter.app.model;

import com.google.gson.annotations.SerializedName;



public class Show   {

    @SerializedName("created_at")
    public String createdAt ;

    public User user = new User();

    @SerializedName("retweet_count")
    public String retweetCount ;


}
