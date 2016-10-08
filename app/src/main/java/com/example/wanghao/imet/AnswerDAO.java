package com.example.wanghao.imet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wanghao on 10/6/16.
 */

public class AnswerDAO {
    private static DbHelper mDbHelper;

    public static long saveAnswer(Context context, int userId, int questionId, int answer, String date,
                                  long time) {
        mDbHelper = new DbHelper(context);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DbHelper.FeedEntry.COLUMN_NAME_TITLE, userId);
        values.put(DbHelper.FeedEntry.COLUMN_NAME_SUBTITLE, questionId);
        values.put(DbHelper.FeedEntry.COLUMN_NAME_SUBTITLE1, answer);
        values.put(DbHelper.FeedEntry.COLUMN_NAME_SUBTITLE2, date);
        values.put(DbHelper.FeedEntry.COLUMN_NAME_SUBTITLE3, time);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DbHelper.FeedEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public static long saveTime(Context context, int userId, int questionId, String answer, String time) {
        mDbHelper = new DbHelper(context);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DbHelper.TimeEntry.COLUMN_NAME_USERID, userId);
        values.put(DbHelper.TimeEntry.COLUMN_NAME_QUESTIONID, questionId);
        values.put(DbHelper.TimeEntry.COLUMN_NAME_ANSWER, answer);
        values.put(DbHelper.TimeEntry.COLUMN_NAME_TIME, time);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DbHelper.TimeEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public static String getTime(Context context, int userId, int questionId) {
        mDbHelper = new DbHelper(context);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DbHelper.TimeEntry._ID,
                DbHelper.TimeEntry.COLUMN_NAME_TIME,
        };

        // Filter results
        String selection = DbHelper.TimeEntry.COLUMN_NAME_USERID + " = ? and " + DbHelper.TimeEntry.COLUMN_NAME_QUESTIONID
                + " = ?";
        String[] selectionArgs = { String.valueOf(userId), String.valueOf(questionId) };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                DbHelper.TimeEntry._ID + " DESC";

        Cursor c = db.query(
                DbHelper.TimeEntry.TABLE_NAME,            // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            return c.getString(1);
        }
        else return "";
    }
}
