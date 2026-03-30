package com.example.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CUTOMER_TABLE = "CUTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        // FACTORY - ADD THE DOCUMENTION //
        super(context, "costomer.db", null, 1);
    }

    // This is called the first time a database is acessesd. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CUTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL)";

        db.execSQL(createTableStatement);
    }

    // This is called if the database version number changes. It prevents previous users appps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CostumerModel costumerModel){
        SQLiteDatabase db = this.getWritableDatabase();

        // CONTENT-VALUES STORES DATA IN PAIRS
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME, costumerModel.getNome());
        cv.put(COLUMN_CUSTOMER_AGE, costumerModel.getNome());

        long insert = db.insert(CUTOMER_TABLE, null, cv);

        if(insert == -1){
            return false;
        }

        else{
            return true;
        }
    }
}
