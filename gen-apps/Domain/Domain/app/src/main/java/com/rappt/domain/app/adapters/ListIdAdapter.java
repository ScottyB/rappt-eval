package com.rappt.domain.app.adapters;

import org.androidannotations.annotations.EBean;
import com.rappt.domain.app.model.*;
import com.rappt.domain.app.*;
import android.view.View;
import com.rappt.domain.app.activities.*;
import com.rappt.domain.app.fragments.*;
import com.rappt.domain.app.views.*;
import org.androidannotations.annotations.res.StringRes;
import android.view.ViewGroup;



@EBean
public class ListIdAdapter extends DefaultAdapter<Recent>  {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Recent item = getItem(position);
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
