package com.example.dellll.test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELLLL on 5/7/2017.
 */
public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context,"DELLphatam.sqlite",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public Cursor DELl_GetData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(sql,null);
        return c;
    }

    public void DELL_QueryData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
