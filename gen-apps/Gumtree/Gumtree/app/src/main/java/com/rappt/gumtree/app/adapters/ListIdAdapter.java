package com.rappt.gumtree.app.adapters;

import com.rappt.gumtree.app.views.*;
import com.rappt.gumtree.app.model.*;
import org.androidannotations.annotations.EBean;
import com.rappt.gumtree.app.activities.*;
import android.view.View;
import com.rappt.gumtree.app.*;
import com.rappt.gumtree.app.fragments.*;
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
