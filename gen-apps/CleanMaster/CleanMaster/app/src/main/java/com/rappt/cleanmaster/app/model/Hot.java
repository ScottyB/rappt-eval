package com.rappt.cleanmaster.app.model;

import com.google.gson.annotations.SerializedName;



public class Hot   {

    public String picture ;

    @SerializedName("number_likes")
    public String numberLikes ;

    public String content ;

    @SerializedName("number_comments")
    public String numberComments ;


}
