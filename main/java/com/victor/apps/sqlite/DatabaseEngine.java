package com.victor.apps.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by victor on 3/19/2016.
 */
public class DatabaseEngine extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "info_database";
    private static final int DATABASE_VERSION = 1;

    public DatabaseEngine(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableSchemas.Information.SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
