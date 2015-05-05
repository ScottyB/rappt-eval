package com.rappt.spotify.app.adapters;

import com.rappt.spotify.app.fragments.*;
import com.rappt.spotify.app.activities.*;
import com.rappt.spotify.app.model.*;
import com.rappt.spotify.app.views.*;
import org.androidannotations.annotations.EBean;
import android.view.View;
import com.rappt.spotify.app.*;
import org.androidannotations.annotations.res.StringRes;
import android.view.ViewGroup;



@EBean
public class ListIdAdapter extends DefaultAdapter<Results>  {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Results item = getItem(position);
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
