package com.example.waractivitycontroller.model.persistence.contract;

import android.provider.BaseColumns;

/**
 * @author Oliver
 */

public class PlayerContract {

    private PlayerContract(){

    }

    static class PlayerEntry implements BaseColumns{
        static final String TABLE_NAME = "player";
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
                    PlayerEntry.COLUMN_LEVEL + SPACE + INTEGER_TYPE + COMMA_SEP +
                    SPACE + ")";

    public static final String SQL_DROP_ENTRIES =
            "DROP TABLE IF EXISTS " + PlayerEntry.TABLE_NAME;
}
