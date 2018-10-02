package com.example.mypc.universitymanagement3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class feedbackdb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "feedback.db";
    public static final String TABLE_NAME = "FEEDBACK_TABLE";
    public static final String COL_1 = "FEEDBACK";

    public feedbackdb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (FEEDBACK TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP table IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String feedback) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, feedback);
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
