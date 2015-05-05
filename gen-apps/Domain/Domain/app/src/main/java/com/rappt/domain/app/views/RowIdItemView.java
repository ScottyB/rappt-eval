package com.rappt.domain.app.views;

import android.content.Context;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.domain.app.model.*;
import com.rappt.domain.app.*;
import android.widget.*;



@EViewGroup(R.layout.rowid)

public class RowIdItemView extends LinearLayout  {

    @ViewById
    public TextView headingLabel ;

    @ViewById
    public TextView filtersId ;


    public RowIdItemView(Context context) {
        super(context);
    }

    public void bind (Recent recent) {
        this.headingLabel.setText(recent.heading);
        this.filtersId.setText(recent.filter);


    }


}
