package com.example.mypc.universitymanagement3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MY PC on 11-04-2018.
 */
public class instructordb extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "instructor.db";
    public static final String TABLE_NAME = "INSTRUCTOR_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SUB1";
    public static final String COL_4 = "MARKS1";
    public static final String COL_5 = "SUB2";
    public static final String COL_6 = "MARKS2";
    public static final String COL_7 = "SUB3";
    public static final String COL_8 = "MARKS3";

    public instructordb(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER,NAME TEXT,SUB1 TEXT,MARKS1 TEXT,SUB2 TEXT,MARKS2 TEXT,SUB3 TEXT,MARKS3 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP table IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String id,String name, String sub1, String marks1,String sub2, String marks2,String sub3, String marks3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, sub1);
        contentValues.put(COL_4, marks1);
        contentValues.put(COL_5, sub2);
        contentValues.put(COL_6, marks2);
        contentValues.put(COL_7, sub3);
        contentValues.put(COL_8, marks3);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else
            return true;
    }
    public Cursor getAlldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;

    }
}
