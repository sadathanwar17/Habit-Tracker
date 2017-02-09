package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitTrackerHelperClass extends SQLiteOpenHelper {



    public HabitTrackerHelperClass(Context context) {
        super(context, HabitTrackerContractClass.DATABASE_NAME, null, HabitTrackerContractClass.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(HabitTrackerContractClass.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HabitTrackerContractClass.TABLE_NAME);
        onCreate(db);
    }

    public void write(String date, int gym, String books, String games) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HabitTrackerContractClass.COLUMN_DATE, date);
        cv.put(HabitTrackerContractClass.COLUMN_GYM, gym);
        cv.put(HabitTrackerContractClass.COLUMN_BOOKS, books);
        cv.put(HabitTrackerContractClass.COLUMN_GAMES, games);
        db.insert(HabitTrackerContractClass.TABLE_NAME, null, cv);
        db.close();
    }

    public Cursor read(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(HabitTrackerContractClass.TABLE_NAME, new String[]{HabitTrackerContractClass.COLUMN_ID, HabitTrackerContractClass.COLUMN_BOOKS, HabitTrackerContractClass.COLUMN_GYM, HabitTrackerContractClass.COLUMN_GAMES, HabitTrackerContractClass.COLUMN_DATE},HabitTrackerContractClass.COLUMN_ID + " = " + id, null, null, null, null);
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from " + HabitTrackerContractClass.TABLE_NAME);
        db.close();
    }

    public void update(String date, int gym, String books) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HabitTrackerContractClass.COLUMN_GYM, gym);
        cv.put(HabitTrackerContractClass.COLUMN_BOOKS, books);
        db.update(HabitTrackerContractClass.TABLE_NAME, cv, HabitTrackerContractClass.COLUMN_DATE + " = " + date, null);
        db.close();
    }


}
