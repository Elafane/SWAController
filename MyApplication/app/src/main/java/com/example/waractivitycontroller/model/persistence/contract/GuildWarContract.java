package com.example.waractivitycontroller.model.persistence.contract;

import android.provider.BaseColumns;

/**
 * @author Oliver
 */

public class GuildWarContract {

    private GuildWarContract(){

    }

    private static class GuildWarEntry implements BaseColumns {
        private static final String TABLE_NAME = "gw";
    }

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String PRIMARY_KEY = "PRIMARY KEY";
    private static final String AUTOINCREMENT = "AUTOINCREMENT";
    private static final String NOT_NULL = "NOT NULL";
    private static final String UNIQUE = "UNIQUE";
    private static final String COMMA_SEP = ",";
    private static final String SPACE = " ";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + GuildWarEntry.TABLE_NAME + "(" + SPACE +
                    GuildWarEntry._ID + SPACE + INTEGER_TYPE + SPACE + PRIMARY_KEY + SPACE + AUTOINCREMENT + COMMA_SEP +
                    //Tabellen einträge
                    SPACE + ")";

    public static final String SQL_DROP_ENTRIES =
            "DROP TABLE IF EXISTS " + GuildWarEntry.TABLE_NAME;
}
