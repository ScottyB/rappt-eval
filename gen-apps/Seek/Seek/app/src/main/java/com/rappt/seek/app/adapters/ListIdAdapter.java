package com.rappt.seek.app.adapters;

import com.rappt.seek.app.*;
import com.rappt.seek.app.activities.*;
import org.androidannotations.annotations.EBean;
import com.rappt.seek.app.views.*;
import android.view.View;
import com.rappt.seek.app.model.*;
import com.rappt.seek.app.fragments.*;
import org.androidannotations.annotations.res.StringRes;
import android.view.ViewGroup;



@EBean
public class ListIdAdapter extends DefaultAdapter<Search>  {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Search item = getItem(position);
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
