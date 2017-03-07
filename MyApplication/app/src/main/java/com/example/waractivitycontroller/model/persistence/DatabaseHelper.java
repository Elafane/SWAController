package com.example.waractivitycontroller.model.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.waractivitycontroller.model.persistence.contract.GuildWarContract;
import com.example.waractivitycontroller.model.persistence.contract.MonsterContract;
import com.example.waractivitycontroller.model.persistence.contract.PlayerContract;

/**
 * @author Oliver Rohr
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wac.db";
    private SQLiteDatabase mDatabaseInstance;
    private int mOpenDatabaseCounter = 0;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        callCreateQueries(sqLiteDatabase);
    }

    private void callCreateQueries(SQLiteDatabase sqLiteDatabase) {
        mDatabaseInstance.execSQL(PlayerContract.SQL_CREATE_ENTRIES);
        mDatabaseInstance.execSQL(GuildWarContract.SQL_CREATE_ENTRIES);
        mDatabaseInstance.execSQL(MonsterContract.SQL_CREATE_ENTRIES);
    }

    private void callDeleteQueries(SQLiteDatabase sqLiteDatabase) {
        mDatabaseInstance.execSQL(PlayerContract.SQL_DROP_ENTRIES);
        mDatabaseInstance.execSQL(GuildWarContract.SQL_DROP_ENTRIES);
        mDatabaseInstance.execSQL(MonsterContract.SQL_DROP_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        callDeleteQueries(sqLiteDatabase);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    /**
     * This method is used to return an open database.
     * Only one database instance is created.
     *
     * @return database instance
     */
    public synchronized SQLiteDatabase openDatabase() {
        mOpenDatabaseCounter++;
        if (mOpenDatabaseCounter == 1) {
            mDatabaseInstance = getWritableDatabase();
        }
        return mDatabaseInstance;
    }

    /**
     * This method is used to close the open database.
     * Only the last call closes the database.
     */
    public synchronized void closeDatabase() {
        if (mOpenDatabaseCounter > 0) {
            mOpenDatabaseCounter--;
        }
        if (mOpenDatabaseCounter == 0) {
            mDatabaseInstance.close();
        }
    }
}
