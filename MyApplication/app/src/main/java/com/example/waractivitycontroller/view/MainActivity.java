package com.example.waractivitycontroller.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.waractivitycontroller.R;
import com.example.waractivitycontroller.view.controller.DrawerListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ArrayList<String> drawerItems = new ArrayList<String>() {{
            add("Dummy1");
            add("Dummy2");
            add("Dummy3");
        }};

        mDrawerList = (ListView) findViewById(R.id.list_drawer);
        mDrawerList.setAdapter(new DrawerListAdapter(this, drawerItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        /*FrameLayout mFrameLayout = (FrameLayout) findViewById(R.id.activity_main_contentFrame);
        if (mFrameLayout != null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.activity_main_contentFrame, new QueryFragment()).commit();
        }*/

        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

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
        //Do stuff
    }
}
