package com.rappt.cleanmaster.app.views;

import android.content.Context;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.cleanmaster.app.*;
import com.rappt.cleanmaster.app.model.*;
import android.widget.ImageView;
import android.widget.*;



@EViewGroup(R.layout.rowid)

public class RowIdItemView extends LinearLayout  {

    public Context context ;

    @ViewById
    public TextView likes ;

    @ViewById
    public ImageView img ;

    @ViewById
    public TextView comments ;

    @ViewById
    public TextView heading ;


    public RowIdItemView(Context context) {
        super(context);
        this.context = context;
    }


    public void bind (Hot hot) {
        this.heading.setText(hot.content);
        this.likes.setText(hot.numberLikes);
        this.comments.setText(hot.numberComments);
        Utils.loadImage(hot.picture, this.img, context);


    }


}
