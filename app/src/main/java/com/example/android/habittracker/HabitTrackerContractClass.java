package com.example.android.habittracker;

public final class HabitTrackerContractClass {

    private HabitTrackerContractClass(){}

    public static final String TABLE_NAME = "HabitTracker";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_GYM = "gym";
    public static final String COLUMN_BOOKS = "books";
    public static final String COLUMN_GAMES = "games";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HabitTracker.db";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DATE + " STRING, " + COLUMN_GAMES + " STRING, " + COLUMN_BOOKS + " STRING, " + COLUMN_GYM + " INT); ";
}
