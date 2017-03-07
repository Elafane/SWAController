package com.example.waractivitycontroller.view.list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.waractivitycontroller.model.persistence.DatabaseHelper;
import com.example.waractivitycontroller.model.persistence.object.Player;

import java.util.ArrayList;

/**
 * @author Oliver
 */
public class PlayerList extends ArrayList<Player> {

    public int update(Context context){
        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase db = helper.openDatabase();

        // Get Entries from db and add to this list

        return size();
    }
}
