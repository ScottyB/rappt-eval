package com.rappt.tripviewlite.app.views;

import android.content.Context;
import org.androidannotations.annotations.*;
import android.widget.TextView;
import com.rappt.tripviewlite.app.model.*;
import android.widget.*;
import com.rappt.tripviewlite.app.*;



@EViewGroup(R.layout.rowid)

public class RowIdItemView extends LinearLayout  {

    @ViewById
    public TextView headingLabel ;

    @ViewById
    public TextView timeLabelId ;

    @ViewById
    public TextView msgLabelId ;


    public RowIdItemView(Context context) {
        super(context);
    }

    public void bind (Delays delays) {
        this.headingLabel.setText(delays.heading);
        this.timeLabelId.setText(delays.time);
        this.msgLabelId.setText(delays.message);


    }


}
