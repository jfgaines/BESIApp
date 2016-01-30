package com.jutech.besi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.File;
import java.sql.SQLException;


//DatabaseHelper creates and upgrades the database; provide DOA for the app
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "besidatabase.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<CaregiverDetails, Integer> caregiverDao;
    private Dao<PWDetails, Integer> pwdDao;

    public DatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, File configFile) {
        super(context, databaseName, factory, databaseVersion, configFile);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            //Create tables
            TableUtils.createTable(connectionSource, CaregiverDetails.class);
            TableUtils.createTable(connectionSource, PWDetails.class);
        } catch (SQLException e){
            Log.e(DatabaseHelper.class.getName(), "Unable to create database", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //update table if there is a change
            TableUtils.dropTable(connectionSource, CaregiverRegister.class,true);
            TableUtils.dropTable(connectionSource, PWDRegister.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e){
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVersion + " to new " + newVersion, e);
        }
    }


    //Create the getDao methods of all the database tables
    //Insert, delete, read, update everything will happen through DAOs
    public Dao<PWDetails, Integer> getPwdDao() throws SQLException{
        if (pwdDao == null){
            pwdDao = getDao(PWDetails.class);
        }
        return pwdDao;
    }

    public Dao<CaregiverDetails, Integer> getCaregiverDao() throws SQLException{
        if (caregiverDao == null){
            caregiverDao = getDao(CaregiverDetails.class);
        }
        return caregiverDao;
    }
}

