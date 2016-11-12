package com.example.wanghao.imet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wanghao on 11/10/16.
 */

public class SignUpDAO {
    private static DbHelper mDbHelper;

    public static long saveUserDetail(Context context, String mEmail, String mPassword, String mName, String mAddress,
                                      String mDOB, String mGender, String mPhone, String mEmergencyContact, String mDoctor,
                                      String mDoctorPhone, String mGuardian, String mGuardianPhone) {
        mDbHelper = new DbHelper(context);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_EMAIL, mEmail);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_PASSWORD, mPassword);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_NAME, mName);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_ADDRESS, mAddress);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_DOB, mDOB);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_GENDER, mGender);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_PHONE, mPhone);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_EMERGENCY, mEmergencyContact);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_DOCTOR, mDoctor);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_DOCTOR_PHONE, mDoctorPhone);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_GUARDIAN, mGuardian);
        values.put(DbHelper.SignUpEntry.COLUMN_NAME_GUARDIAN_PHONE, mGuardianPhone);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DbHelper.SignUpEntry.TABLE_NAME, null, values);
        return newRowId;
    }

    public static String getPass(Context context, String username) {
        mDbHelper = new DbHelper(context);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DbHelper.SignUpEntry.COLUMN_NAME_PASSWORD,
        };

        // Filter results
        String selection = DbHelper.SignUpEntry.COLUMN_NAME_EMAIL + " = ?";
        String[] selectionArgs = { username };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                DbHelper.SignUpEntry._ID + " DESC";

        Cursor c = db.query(
                DbHelper.SignUpEntry.TABLE_NAME,            // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            return c.getString(0);
        }
        else return null;
    }
}
