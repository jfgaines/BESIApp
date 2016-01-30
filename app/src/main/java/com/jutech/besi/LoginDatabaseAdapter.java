package com.jutech.besi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

//This file is required to handle all Database operations like (create DB, Insert record,
// update record, Delete record, Close DB, and Cursor related stuffs.
public class LoginDatabaseAdapter {

    //name of main database for BESI app
    public static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    /*public static final String TABLE_NAME = "dementia_table";
    public static final String COL_1 = "DATE";
    public static final String COL_2 = "CARETAKER";
    public static final String COL_3 = "EMOTION";
    public static final String COL_4 = "LOVABLE";
    public static final String COL_5 = "AGITATION";
    public static final String COL_6 = "DEPRESSION";
    public static final String COL_7 = "SLEEPING_PATTERN";
    public static final String COL_8 = "SUMMARY";*/

    // Create public field for each column in your table.
    //SQL Statement to create a new database
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( " + "ID"
            + " integer primary key autoincrement," + "USERNAME text,PASSWORD text); ";

    //Variable to hold the database instance
    public SQLiteDatabase db;
    //Context of the application using the database
    private final Context context;
    //Database open/upgrade helper
    private DatabaseHelper dbHelper;
    public LoginDatabaseAdapter(Context _context) {
        //this.context = context;
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public LoginDatabaseAdapter open()throws SQLException{
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance(){
        return db;
    }

    public void insertEntry(String userName, String password){
        ContentValues newValues = new ContentValues();
        //Assign values for each row
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);

        //Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public int deleteEntry(String UserName){
        //String id=String.valueOf(ID);
        String where = "USERNAME=?";
        int numberOfEntriesDeleted = db.delete("LOGIN", where, new String[]{UserName});
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOfEntriesDeleted;
    }

    public String getSingleEntry(String userName){
        Cursor cursor = db.query("LOGIN",null,"USERNAME=?", new String[]{userName},null,null,null);
        if(cursor.getCount()<1){ //UserName Not Exist
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName, String password){
        //Define the updated row content
        ContentValues updatedValues = new ContentValues();
        //Assign values for each row
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where = "USERNAME=?";
        db.update("LOGIN",updatedValues,where, new String[]{userName});
    }
}
