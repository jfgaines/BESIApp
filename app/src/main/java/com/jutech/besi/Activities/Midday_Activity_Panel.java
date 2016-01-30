package com.jutech.besi.Activities;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jutech.besi.R;

/**
 * Created by Jawari on 7/15/2015.
 */
public class Midday_Activity_Panel extends ListFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.midday_activity_panel,
                container, false);

        return view;

    }
}