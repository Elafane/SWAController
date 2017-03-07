package com.example.waractivitycontroller.view.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.waractivitycontroller.R;
import com.example.waractivitycontroller.view.controller.PlayerListAdapter;
import com.example.waractivitycontroller.view.list.PlayerList;

/**
 * @author Oliver
 */

public class PlayerFragment extends Fragment {

    private ListView listView;
    private PlayerListAdapter listAdapter;
    private PlayerList listItems = new PlayerList();

    private static final String INIT_LIST_ITEMS = "player";
    private static final int INIT_TASK_FINISHED = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        listView = (ListView) view.findViewById(R.id.fragment_player_list);

        System.out.println(listView);
        new AsyncTask<Context, Void, Bundle>(){

            @Override
            protected Bundle doInBackground(Context... params) {
                Bundle bundle = new Bundle();
                bundle.putInt(INIT_LIST_ITEMS,INIT_TASK_FINISHED);
                listItems.update(params[0]);
                return bundle;
            }

            @Override
            protected void onPostExecute(Bundle bundle) {
                System.out.println(listView);
                listView.setAdapter(listAdapter = new PlayerListAdapter(getActivity(),listItems));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getActivity(),"Item " + position + " clicked", Toast.LENGTH_SHORT).show();
                    }
                });
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
