package com.jutech.besi.Activities;

import android.app.Fragment;
import android.app.ListFragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.jutech.besi.R;

/**
 * Created by Jawari on 6/15/2015.
 */
public class Morning_Activity_Panel extends ListFragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.morning_activity_panel,
                container, false);

        return view;

    }
//    private void updateUI() {
//        helper = new TaskDBHelper(Morning_Activity_Panel.this);
//
//        SQLiteDatabase sqlDB = helper.getReadableDatabase();
//        Cursor cursor = sqlDB.query(TaskContract.TABLE,
//                new String[]{TaskContract.Columns._ID, TaskContract.Columns.TASK},
//                null,null,null,null,null);
//
//        listAdapter = new SimpleCursorAdapter( this,
//                R.layout.morning_activities_view,
//                cursor,
//                new String[] { TaskContract.Columns.TASK},
//                new int[] { R.id.morning_activitiescheckbox},
//                0
//        );
//        this.setListAdapter(listAdapter);
    }
//}