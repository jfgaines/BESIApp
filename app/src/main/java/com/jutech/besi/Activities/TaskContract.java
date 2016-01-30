package com.jutech.besi.Activities;

/**
 * Created by Jawari on 6/15/2015.
 */
import android.provider.BaseColumns;

public class TaskContract {
    public static final String DB_NAME = "com.jutech.besi.Activities.tasks";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "tasks";

    public class Columns {
        public static final String TASK = "task";
        public static final String _ID = BaseColumns._ID;
    }
}