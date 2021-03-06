package com.example.mudit.notepad2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mudit on 26-01-2018.
 */

public class DBHelperClass extends SQLiteOpenHelper {


    public static final String name = "note.db";
    public static final String id = "_ID";
    public static final String title = "Title";
    public static final String note = "Note";
    public static final String pics = "Pics";
    public static final String Table_Name = "notetable";
    public static final int version = 1;
    SQLiteDatabase db;
    public DBHelperClass(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Table_Name+" ("+id+" INTEGER Primary Key AUTOINCREMENT, "+title+" TEXT, "+note+" TEXT, "+pics+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }

    public void open()
    {
        db=this.getWritableDatabase();
    }

    public void close()
    {
        db.close();
    }

    public long insertData(String ititle, String inote, String picpath)
    {
        ContentValues values = new ContentValues();
        values.put(title,ititle);
        values.put(note,inote);
        values.put(pics,picpath+",");
        long result=db.insert(Table_Name,null,values);
        return result;
    }

    public Cursor getData()
    {
        Cursor result = db.rawQuery("Select * from "+Table_Name, null);
        return result;
    }
    public boolean updateData(Integer ID,String ititle, String inote, String picpath) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(title, ititle);
        values.put(note, inote);
        values.put(pics, picpath + ",");
        db.update(Table_Name, values, "ID = ?", new String[]{String.valueOf(ID)});
        return true;
    }
    public boolean deleteNote(int ID)
    {

    }

    public class ImagePicker {
        private static final int DEFAULT_MIN_WIDTH_QUALITY = 400;        // min pixels
        private static final String TAG = "ImagePicker";
        private static final String TEMP_IMAGE_NAME = "tempImage";

        public static int minWidthQuality = DEFAULT_MIN_WIDTH_QUALITY;


        public static Intent getPickImageIntent(Context context) {
            Intent chooserIntent= null;
            List<Intent> intentList = new ArrayList<>();

            Intent pickIntent= new Intent();
        }
}
