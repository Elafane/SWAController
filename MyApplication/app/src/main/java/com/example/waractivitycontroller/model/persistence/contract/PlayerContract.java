package com.example.waractivitycontroller.model.persistence.contract;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.waractivitycontroller.model.persistence.object.Player;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Oliver
 */

public class PlayerContract {

    private PlayerContract(){

    }

    private static class PlayerEntry implements BaseColumns{
        private static final String TABLE_NAME = "player";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_JOIN_YEAR = "year";
        private static final String COLUMN_JOIN_MONTH = "month";
        private static final String COLUMN_JOIN_DAY = "day";
        private static final String COLUMN_LEVEL = "lvl";
    }

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String DATE_TYPE = "DATE";
    private static final String PRIMARY_KEY = "PRIMARY KEY";
    private static final String AUTOINCREMENT = "AUTOINCREMENT";
    private static final String NOT_NULL = "NOT NULL";
    private static final String UNIQUE = "UNIQUE";
    private static final String COMMA_SEP = ",";
    private static final String SPACE = " ";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlayerEntry.TABLE_NAME + "(" + SPACE +
                    PlayerEntry._ID + SPACE + INTEGER_TYPE + SPACE + PRIMARY_KEY + SPACE + AUTOINCREMENT + COMMA_SEP +
                    PlayerEntry.COLUMN_NAME + SPACE + TEXT_TYPE + SPACE + NOT_NULL + SPACE + UNIQUE + COMMA_SEP +
                    PlayerEntry.COLUMN_JOIN_YEAR + SPACE + INTEGER_TYPE + COMMA_SEP +
                    PlayerEntry.COLUMN_JOIN_MONTH + SPACE + INTEGER_TYPE + COMMA_SEP +
                    PlayerEntry.COLUMN_JOIN_DAY + SPACE + INTEGER_TYPE + COMMA_SEP +
                    PlayerEntry.COLUMN_LEVEL + SPACE + INTEGER_TYPE +
                    SPACE + ")";

    public static final String SQL_DROP_ENTRIES =
            "DROP TABLE IF EXISTS " + PlayerEntry.TABLE_NAME;

    private static final String SQL_SELECT_ENTRIES =
            "SELECT * FROM " + PlayerEntry.TABLE_NAME;

    //<editor-fold desc="Getter" defaultState="collapsed">

    public static Collection<? extends Player> getPlayer(SQLiteDatabase db) {
        ArrayList<Player> result = new ArrayList<>();

        Cursor c = db.rawQuery(SQL_SELECT_ENTRIES, null);
        while (c.moveToNext()){
            result.add(new Player(
                    c.getLong(c.getColumnIndexOrThrow(PlayerEntry._ID)),
                    c.getString(c.getColumnIndexOrThrow(PlayerEntry.COLUMN_NAME)),
                    c.getInt(c.getColumnIndexOrThrow(PlayerEntry.COLUMN_LEVEL)),
                    c.getInt(c.getColumnIndexOrThrow(PlayerEntry.COLUMN_JOIN_YEAR)),
                    c.getInt(c.getColumnIndexOrThrow(PlayerEntry.COLUMN_JOIN_MONTH)),
                    c.getInt(c.getColumnIndexOrThrow(PlayerEntry.COLUMN_JOIN_DAY))
            ));
        }
        c.close();
        return result;
    }

    //</editor-fold>
}
