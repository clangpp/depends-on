package com.clangpp.depends_on.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.clangpp.depends_on.data.ChecklistContact.DependencyEntry;
import com.clangpp.depends_on.data.ChecklistContact.ItemEntry;

/**
 * Manages a local database for checklist data.
 */
public class ChecklistDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "checklist.db";

    public ChecklistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_ITEM_TABLE = "CREATE TABLE " + ItemEntry.TABLE_NAME + " (" +
                ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ItemEntry.COLUMN_STATUS + "INTEGER NOT NULL, " +
                ItemEntry.COLUMN_DESCRIPTION + "TEXT NOT NULL);";


        final String SQL_CREATE_DEPENDENCY_TABLE = "CREATE TABLE " +
                DependencyEntry.TABLE_NAME + " (" +
                DependencyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DependencyEntry.COLUMN_DEPENDS + " INTEGER NOT NULL, " +
                DependencyEntry.COLUMN_TRIGGERS + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" + DependencyEntry.COLUMN_DEPENDS + ") REFERENCES " +
                ItemEntry.TABLE_NAME + " (" + ItemEntry._ID + "), " +
                " FOREIGN KEY (" + DependencyEntry.COLUMN_TRIGGERS + ") REFERENCES " +
                ItemEntry.TABLE_NAME + " (" + ItemEntry._ID + "), " +
                " UNIQUE (" + DependencyEntry.COLUMN_DEPENDS + ", " +
                DependencyEntry.COLUMN_TRIGGERS + ") ON CONFLICT REPLACE);";

        db.execSQL(SQL_CREATE_ITEM_TABLE);
        db.execSQL(SQL_CREATE_DEPENDENCY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DependencyEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ItemEntry.TABLE_NAME);
        onCreate(db);
    }
}
