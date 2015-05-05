package com.rappt.seek.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import java.util.List;

@EBean
public abstract class DefaultAdapter<T> extends BaseAdapter {

    List<T> items;

    @RootContext
    public Context context;

    public void setData(List<T> items) {
        this.items = items;
    }

    public boolean hasNoData() {
        return items == null || items.isEmpty();
    }

    @Override
    public int getCount() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }

    @Override
    public T getItem(int position) {
        if (items != null)  {
            return items.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (items != null) {
            return items.get(position).hashCode();
        }
        return 0;
    }

    @Override
    abstract public View getView(int position, View convertView, ViewGroup parent);

}
