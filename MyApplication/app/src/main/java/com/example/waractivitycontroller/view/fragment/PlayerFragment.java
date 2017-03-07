package com.example.waractivitycontroller.view.fragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.waractivitycontroller.R;
import com.example.waractivitycontroller.model.persistence.DatabaseHelper;
import com.example.waractivitycontroller.view.controller.PlayerListAdapter;
import com.example.waractivitycontroller.view.list.PlayerList;

import java.util.ArrayList;

/**
 * @author Oliver
 */

public class PlayerFragment extends Fragment {

    private ListView listView;
    private PlayerListAdapter listAdapter;
    private PlayerList listItems = new PlayerList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        listView = (ListView) container.findViewById(R.id.fragment_player_list);

        new AsyncTask<Context, Void, Bundle>(){

            @Override
            protected Bundle doInBackground(Context... params) {
                listItems.update(params[0]);
                return null;
            }
        }.execute(getActivity());

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.player_fragment_menu, menu);
    }

}
