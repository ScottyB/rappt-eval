package com.rappt.twitter.app;

import android.content.Context;
import com.squareup.picasso.Picasso;
import android.widget.ImageView;



public class Utils   {

    static public void loadImage(String image, ImageView imageView, Context c) {
        Picasso.with(c).load(image).resize(100, 100).into(imageView);
    }


}
