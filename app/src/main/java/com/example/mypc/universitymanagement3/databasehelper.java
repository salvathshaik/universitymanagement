package com.example.mypc.universitymanagement3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MY PC on 09-04-2018.
 */

public class databasehelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "STUDENT_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SNAME";
    public static final String COL_4 = "MARKS";


    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER,NAME TEXT,SNAME TEXT,MARKS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP table IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id,String name, String sname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, sname);
        contentValues.put(COL_4, marks);
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
    public boolean updateData(String id,String name,String sname,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, sname);
        db.update(TABLE_NAME,contentValues,"id=?",new String[] {id});
        return true;
    }
    public Integer deleteData(String Id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id=?",new String[] {Id});
    }
}
