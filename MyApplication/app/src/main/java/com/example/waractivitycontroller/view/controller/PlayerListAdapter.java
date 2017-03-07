package com.example.waractivitycontroller.view.controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.waractivitycontroller.R;
import com.example.waractivitycontroller.model.persistence.object.Player;
import com.example.waractivitycontroller.view.list.PlayerList;

/**
 * @author Oliver
 */
public class PlayerListAdapter extends ArrayAdapter<Player>{

    private PlayerList listItems;
    private Activity context;

    public PlayerListAdapter(Activity context, PlayerList listItems){
        super(context, R.layout.list_single_player_item, listItems);
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(R.layout.list_single_player_item, parent, false);
        }

        TextView mNameText = (TextView) convertView.findViewById(R.id.list_single_drawerItem_drawerText);
        TextView mLevelText = (TextView) convertView.findViewById(R.id.list_single_player_level);
        TextView mYearText = (TextView) convertView.findViewById(R.id.list_single_player_year);
        TextView mMonthText = (TextView) convertView.findViewById(R.id.list_single_player_month);
        TextView mDayText = (TextView) convertView.findViewById(R.id.list_single_player_day);
        
        mNameText.setText(listItems.get(position).getName());
        mLevelText.setText(String.valueOf(listItems.get(position).getLevel()));
        mYearText.setText(String.valueOf(listItems.get(position).getYear()));
        mMonthText.setText(listItems.get(position).getMonthAsString());
        mDayText.setText(String.valueOf(listItems.get(position).getDay()));

        return convertView;
    }
}
