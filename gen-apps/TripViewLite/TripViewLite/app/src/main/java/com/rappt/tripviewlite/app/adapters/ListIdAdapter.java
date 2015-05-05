package com.rappt.tripviewlite.app.adapters;

import com.rappt.tripviewlite.app.activities.*;
import org.androidannotations.annotations.EBean;
import com.rappt.tripviewlite.app.views.*;
import android.view.View;
import com.rappt.tripviewlite.app.fragments.*;
import com.rappt.tripviewlite.app.model.*;
import org.androidannotations.annotations.res.StringRes;
import android.view.ViewGroup;
import com.rappt.tripviewlite.app.*;



@EBean
public class ListIdAdapter extends DefaultAdapter<Delays>  {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Delays item = getItem(position);
        RowIdItemView itemView;
        if (convertView == null) {
            itemView = RowIdItemView_.build(super.context);
        } else {
            itemView = (RowIdItemView) convertView;
        }
        itemView.bind(getItem(position));
        itemView.setTag(item);
        return itemView;


    }



}
