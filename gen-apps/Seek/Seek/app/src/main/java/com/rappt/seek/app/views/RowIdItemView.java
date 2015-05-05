package com.rappt.seek.app.views;

import com.rappt.seek.app.*;
import android.content.Context;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import android.widget.ImageView;
import com.rappt.seek.app.model.*;
import android.widget.*;



@EViewGroup(R.layout.rowid)

public class RowIdItemView extends LinearLayout  {

    public Context context ;

    @ViewById
    public TextView headingLabel ;

    @ViewById
    public ImageView imgLogo ;

    @ViewById
    public TextView locationLabel ;

    @ViewById
    public TextView descriptionLabel ;

    @ViewById
    public TextView companyLabel ;

    @ViewById
    public TextView typeLabel ;


    public RowIdItemView(Context context) {
        super(context);
        this.context = context;
    }


    public void bind (Search search) {
        this.headingLabel.setText(search.heading);
        this.companyLabel.setText(search.company);
        this.locationLabel.setText(search.location);
        this.typeLabel.setText(search.timeType);
        this.descriptionLabel.setText(search.description);
        Utils.loadImage(search.logo, this.imgLogo, context);


    }


}
