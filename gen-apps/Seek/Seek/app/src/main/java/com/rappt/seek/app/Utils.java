package com.rappt.seek.app;

import android.content.Context;
import com.squareup.picasso.Picasso;
import android.widget.ImageView;
import java.io.IOException;
import android.graphics.drawable.Drawable;
import java.io.InputStream;



public class Utils   {

    static public void loadImage(String image, ImageView imageView, Context c) {
        if (SeekApplication.IS_OFFLINE) {
            final float scale = c.getResources().getDisplayMetrics().density;
            int pixels = (int) (100 * scale + 0.5f);
            try {
                InputStream ims = c.getAssets().open(image);
                Drawable d = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(d);
                imageView.getLayoutParams().height = pixels;
                imageView.getLayoutParams().width = pixels;
            }
            catch (IOException ex) {
            }
        } else {
            Picasso.with(c).load(image).resize(100, 100).into(imageView);
        }
    }


}
