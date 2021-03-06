package com.example.wanghao.imet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by wanghao on 10/6/16.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "answer";
        public static final String COLUMN_NAME_TITLE = "userId";
        public static final String COLUMN_NAME_SUBTITLE = "questionId";
        public static final String COLUMN_NAME_SUBTITLE1 = "answer";
        public static final String COLUMN_NAME_SUBTITLE2 = "date";
        public static final String COLUMN_NAME_SUBTITLE3 = "time";
    }

    public static class TimeEntry implements BaseColumns {
        public static final String TABLE_NAME = "time";
        public static final String COLUMN_NAME_USERID= "userId";
        public static final String COLUMN_NAME_QUESTIONID = "questionId";
        public static final String COLUMN_NAME_ANSWER = "answer";
        public static final String COLUMN_NAME_TIME = "time";
    }

    public static class SignUpEntry implements BaseColumns {
        public static final String TABLE_NAME = "signUp";

        public static final String COLUMN_NAME_EMAIL= "Email";
        public static final String COLUMN_NAME_PASSWORD= "Password";
        public static final String COLUMN_NAME_NAME = "Name";
        public static final String COLUMN_NAME_ADDRESS = "Address";
        public static final String COLUMN_NAME_DOB = "DOB";
        public static final String COLUMN_NAME_GENDER = "Gender";
        public static final String COLUMN_NAME_PHONE = "Phone";
        public static final String COLUMN_NAME_EMERGENCY = "EmergencyContact";
        public static final String COLUMN_NAME_DOCTOR = "Doctor";
        public static final String COLUMN_NAME_DOCTOR_PHONE = "DoctorPhone";
        public static final String COLUMN_NAME_GUARDIAN = "Guardian";
        public static final String COLUMN_NAME_GUARDIAN_PHONE = "GuardianPhone";
    }

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String LONG_TYPE = " LONG";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + INT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_SUBTITLE + INT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_SUBTITLE1 + INT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_SUBTITLE2 + TEXT_TYPE + COMMA_SEP +
                    FeedEntry.COLUMN_NAME_SUBTITLE3 + LONG_TYPE + " )";

    private static final String SQL_CREATE_TIME_TABLE =
            "CREATE TABLE " + TimeEntry.TABLE_NAME + " (" +
                    TimeEntry._ID + " INTEGER PRIMARY KEY," +
                    TimeEntry.COLUMN_NAME_USERID + INT_TYPE + COMMA_SEP +
                    TimeEntry.COLUMN_NAME_QUESTIONID + INT_TYPE + COMMA_SEP +
                    TimeEntry.COLUMN_NAME_ANSWER + TEXT_TYPE + COMMA_SEP +
                    TimeEntry.COLUMN_NAME_TIME + TEXT_TYPE + " )";

    private static final String SQL_CREATE_SIGNUP_TABLE =
            "CREATE TABLE " + SignUpEntry.TABLE_NAME + " (" +
                    SignUpEntry._ID + " INTEGER PRIMARY KEY," +
                    SignUpEntry.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_DOB + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_PHONE + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_EMERGENCY + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_DOCTOR + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_DOCTOR_PHONE + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_GUARDIAN + TEXT_TYPE + COMMA_SEP +
                    SignUpEntry.COLUMN_NAME_GUARDIAN_PHONE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    private static final String SQL_DELETE_TIME_TABLE =
            "DROP TABLE IF EXISTS " + TimeEntry.TABLE_NAME;
    private static final String SQL_DELETE_SIGNUP_TABLE =
            "DROP TABLE IF EXISTS " + SignUpEntry.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_TIME_TABLE);
        db.execSQL(SQL_CREATE_SIGNUP_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_TIME_TABLE);
        db.execSQL(SQL_DELETE_SIGNUP_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
