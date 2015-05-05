package com.rappt.spotify.app.views;

import android.content.Context;
import org.androidannotations.annotations.*;
import com.rappt.spotify.app.model.*;
import android.widget.TextView;
import com.rappt.spotify.app.*;
import android.widget.*;



@EViewGroup(R.layout.rowid)

public class RowIdItemView extends LinearLayout  {

    @ViewById
    public TextView songNameId ;


    public RowIdItemView(Context context) {
        super(context);
    }

    public void bind (Results results) {
        this.songNameId.setText(results.name);


    }


}
