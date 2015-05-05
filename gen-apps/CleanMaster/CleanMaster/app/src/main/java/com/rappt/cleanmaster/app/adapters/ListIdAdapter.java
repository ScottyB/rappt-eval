package com.rappt.cleanmaster.app.adapters;

import com.rappt.cleanmaster.app.*;
import org.androidannotations.annotations.EBean;
import com.rappt.cleanmaster.app.fragments.*;
import com.rappt.cleanmaster.app.model.*;
import android.view.View;
import org.androidannotations.annotations.res.StringRes;
import android.view.ViewGroup;
import com.rappt.cleanmaster.app.activities.*;
import com.rappt.cleanmaster.app.views.*;



@EBean
public class ListIdAdapter extends DefaultAdapter<Hot>  {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hot item = getItem(position);
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
