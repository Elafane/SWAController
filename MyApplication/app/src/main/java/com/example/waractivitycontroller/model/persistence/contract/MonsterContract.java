package com.example.waractivitycontroller.model.persistence.contract;

import android.provider.BaseColumns;

/**
 * @author Oliver
 */

public class MonsterContract {

    private MonsterContract(){

    }

    private static class MonsterEntry implements BaseColumns{
        private static final String TABLE_NAME = "mons";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_LEVEL = "lvl";
        private static final String COLUMN_ELEMENT = "element";
        private static final String COLUMN_RANK = "rank";
        private static final String COLUMN_HP_TOTAL = "hptotal";
        private static final String COLUMN_HP_BASE = "hpbase";
        private static final String COLUMN_HP_BONUS = "hpbonus";
        private static final String COLUMN_ATK_TOTAL = "atktotal";
        private static final String COLUMN_ATK_BASE = "atkbase";
        private static final String COLUMN_ATK_BONUS = "atkbonus";
        private static final String COLUMN_DEF_TOTAL = "deftotal";
        private static final String COLUMN_DEF_BASE = "defbase";
        private static final String COLUMN_DEF_BONUS = "defbonus";
        private static final String COLUMN_SPD_TOTAL = "spdtotal";
        private static final String COLUMN_SPD_BASE = "spdbase";
        private static final String COLUMN_SPD_BONUS = "spdbonus";
        private static final String COLUMN_CRIRATE = "crirate";
        private static final String COLUMN_CRIDMG = "cridmg";
        private static final String COLUMN_RES = "res";
        private static final String COLUMN_ACC = "acc";
    }

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String PRIMARY_KEY = "PRIMARY KEY";
    private static final String NOT_NULL = "NOT NULL";
    private static final String UNIQUE = "UNIQUE";
    private static final String COMMA_SEP = ",";
    private static final String SPACE = " ";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MonsterEntry.TABLE_NAME + "(" + SPACE +
                    MonsterEntry._ID + SPACE + INTEGER_TYPE + SPACE + PRIMARY_KEY + SPACE + UNIQUE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME + SPACE + TEXT_TYPE + SPACE + NOT_NULL + COMMA_SEP +
                    MonsterEntry.COLUMN_LEVEL + SPACE + INTEGER_TYPE + SPACE + NOT_NULL + COMMA_SEP +
                    MonsterEntry.COLUMN_ELEMENT + SPACE + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_RANK + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_HP_BASE + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_HP_BONUS + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_HP_TOTAL + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_ATK_BASE + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_ATK_BONUS + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_ATK_TOTAL + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_DEF_BASE + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_DEF_BONUS + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_DEF_TOTAL + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_SPD_BASE + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_SPD_BONUS + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_SPD_TOTAL + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_CRIRATE + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_CRIDMG + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_RES + SPACE + INTEGER_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_ACC + SPACE + INTEGER_TYPE + COMMA_SEP +
                    SPACE + ")";

    public static final String SQL_DROP_ENTRIES =
            "DROP TABLE IF EXISTS " + MonsterEntry.TABLE_NAME;
}
