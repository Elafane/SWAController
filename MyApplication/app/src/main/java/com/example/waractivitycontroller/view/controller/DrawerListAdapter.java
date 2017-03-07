package com.example.waractivitycontroller.view.controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.waractivitycontroller.R;

import java.util.ArrayList;

/**
 * @author Oliver
 */
public class DrawerListAdapter extends ArrayAdapter<String> {

    private final ArrayList<String> listItems;
    private final Activity context;

    public DrawerListAdapter(Activity context, ArrayList<String> drawerItems) {
        super(context, R.layout.list_single_drawer_item, drawerItems);
        this.listItems = drawerItems;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(R.layout.list_single_drawer_item, parent, false);
        }

        TextView drawerText = (TextView) convertView.findViewById(R.id.list_single_drawerItem_drawerText);
        drawerText.setText(listItems.get(position));

        return convertView;
    }
}
