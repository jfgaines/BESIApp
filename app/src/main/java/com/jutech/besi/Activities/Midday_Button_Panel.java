package com.jutech.besi.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jutech.besi.HomeScreen;
import com.jutech.besi.R;

/**
 * Created by Jawari on 7/15/2015.
 */
public class Midday_Button_Panel extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.midday_button_panel,
                container, false);
        return view;
    }


}
