package com.rappt.seek.app.activities;

import com.rappt.seek.app.*;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import org.androidannotations.annotations.AfterViews;
import com.rappt.seek.app.fragments.*;
import org.androidannotations.annotations.EActivity;
import android.view.MenuItem;
import java.util.ArrayList;
import android.support.v4.view.GravityCompat;
import android.widget.ArrayAdapter;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import org.androidannotations.annotations.ViewById;
import android.support.v4.widget.DrawerLayout;



@EActivity(R.layout.drawer_layout)

public class DrawerActivity extends FragmentActivity  {

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private ActionBarDrawerToggle mDrawerToggle;
    private MenuItemAdapter mAdapter;

    @ViewById
    public DrawerLayout drawer_layout;

    @ViewById
    public ListView left_drawer;

    @ViewById
    ViewPager mViewPager;

    @AfterViews
    void afterViews() {
        mTitle = mDrawerTitle = getTitle();
        drawer_layout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mAdapter = new MenuItemAdapter(this, mViewPager);

        mAdapter.addMenuItem(SearchFragment_.class, R.string.firstTabId_string, null);


        left_drawer.setAdapter(new ArrayAdapter<Object>(this, R.layout.drawer_list_item, mAdapter.mMenuItems.toArray()));
        left_drawer.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
            this,
            drawer_layout,
            R.drawable.ic_drawer,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        drawer_layout.setDrawerListener(mDrawerToggle);
        left_drawer.setItemChecked(0, true);
        setTitle(mAdapter.mMenuItems.get(0).title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            left_drawer.setItemChecked(position, true);
            drawer_layout.closeDrawer(left_drawer);
            mAdapter.mViewPager.setCurrentItem(position);
            setTitle(mAdapter.mMenuItems.get(position).title);
        }
    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public class MenuItemAdapter extends FragmentPagerAdapter
                implements ViewPager.OnPageChangeListener {
        private final Context mContext;

        final class MenuItemInfo {
            private final Bundle args;
            private final Class<?> aClass;
            private final String title;

            MenuItemInfo(Class<?> _class, String _title, Bundle _args) {
                aClass = _class;
                args = _args;
                title = _title;
            }

            @Override
            public String toString() {
                return title;
            }
        }

        private ViewPager mViewPager;
        private ArrayList<MenuItemInfo> mMenuItems = new ArrayList<MenuItemInfo>();

        public MenuItemAdapter(FragmentActivity activity, ViewPager pager) {
            super(activity.getSupportFragmentManager());
            mContext = activity;
            mViewPager = pager;
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addMenuItem(Class<?> clss, int stringId, Bundle args) {
            MenuItemInfo info = new MenuItemInfo(clss, getResources().getString(stringId), args);
            mMenuItems.add(info);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mMenuItems.size();
        }

        @Override
        public Fragment getItem(int position) {
            MenuItemInfo info = mMenuItems.get(position);
            return Fragment.instantiate(mContext, info.aClass.getName(), info.args);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            left_drawer.setItemChecked(position, true);
            setTitle(mAdapter.mMenuItems.get(position).title);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

    }



}
