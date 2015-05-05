package com.rappt.gumtree.app.views;

import android.content.Context;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.gumtree.app.model.*;
import com.rappt.gumtree.app.*;
import android.widget.*;



@EViewGroup(R.layout.rowid)

public class RowIdItemView extends LinearLayout  {

    @ViewById
    public TextView dateId ;

    @ViewById
    public TextView locationId ;

    @ViewById
    public TextView sortId ;

    @ViewById
    public TextView headerId ;


    public RowIdItemView(Context context) {
        super(context);
    }

    public void bind (Recent recent) {
        this.headerId.setText(recent.header);
        this.locationId.setText(recent.location);
        this.sortId.setText(recent.sort);
        this.dateId.setText(recent.date);


    }


}
