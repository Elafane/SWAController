package com.example.waractivitycontroller.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.waractivitycontroller.R;
import com.example.waractivitycontroller.view.controller.DrawerListAdapter;
import com.example.waractivitycontroller.view.fragment.PlayerFragment;
import com.example.waractivitycontroller.view.fragment.WarFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private static final String ACTIVE_FRAGMENT = "fragment";

    private static final int DRAWER_OPTION_PLAYER = 0;
    private static final int DRAWER_OPTION_WAR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ArrayList<String> drawerItems = new ArrayList<String>() {{
            add("Spieler");
            add("Kämpfe");
            add("Dummy3");
        }};

        mDrawerList = (ListView) findViewById(R.id.list_drawer);
        mDrawerList.setAdapter(new DrawerListAdapter(this, drawerItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        FrameLayout mFrameLayout = (FrameLayout) findViewById(R.id.activity_main_container);
        if (mFrameLayout != null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.activity_main_container, new PlayerFragment()).commit();
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        Fragment fragment;
        switch(position) {
            case DRAWER_OPTION_PLAYER:
                fragment = new PlayerFragment();
                break;
            case DRAWER_OPTION_WAR:
                fragment = new WarFragment();
                break;
            default:
                fragment = new PlayerFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_container, fragment, ACTIVE_FRAGMENT)
                .commit();

        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);

    }

    //<editor-fold desc"Menu Options", defaultState="collapsed">

    public void onAddPlayer(MenuItem item) {
    }

    //</editor-fold>

}
