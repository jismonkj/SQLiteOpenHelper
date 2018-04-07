package com.ajce.blake.sqliteopenhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by blake on 5/4/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "studentDb";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "student";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+TABLE_NAME+"(id integer primary key, name varchar(15))");
    }

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //insert data
    public long insertData(ContentValues values, SQLiteDatabase db)
    {
        return db.insert(TABLE_NAME,null, values);
    }

    //view data
    public ArrayList<String>  viewData(SQLiteDatabase db){
        Cursor cursor;
        ArrayList<String> list = new ArrayList<String>();

        cursor = db.query(true, TABLE_NAME, null, null, null, null, null, null, null, null);
        if(cursor.getCount()>0)
        {
            int c = cursor.getCount();
            while(c>0)
            {
                cursor.moveToFirst();
                list.add(cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
                c--;
            }


        }

        return  list;
    }
}
