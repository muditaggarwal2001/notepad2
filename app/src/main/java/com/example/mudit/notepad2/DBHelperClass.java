package com.example.mudit.notepad2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mudit on 26-01-2018.
 */

public class DBHelperClass extends SQLiteOpenHelper {

    public static final String name = "note.db";
    public static final String id = "ID";
    public static final String title = "Title";
    public static final String note = "Note";
    public static final String pics = "Pics";
    public static final int version = 1;
    public DBHelperClass(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE notetable ("+id+" INTEGER Primary Key AUTOINCREMENT, "+title+" TEXT, "+note+" TEXT, "+pics+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS notetable");
        onCreate(db);
    }
}
