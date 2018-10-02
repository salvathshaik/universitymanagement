package com.example.mypc.universitymanagement3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MY PC on 17-04-2018.
 */

public class userdbdb extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "USERDB.db";
    public static final String TABLE_NAME = "REQUEST_RESULT_TABLE";
    public static final String COL_1 = "REQUESTRESULTS";

    public userdbdb(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + "(REQUESTRESULTS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP table IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public Cursor getAlldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;

    }
}
