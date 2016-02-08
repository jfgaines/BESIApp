package com.jutech.besi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jutech.besi.Activities.DailyTask;


public class HomeScreen extends ActionBarActivity {

    Button Logout;
    SharedPreferences mPreferences;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen_activity);

        //receiving usersname from UserId
        final TextView UserName = (TextView) findViewById(R.id.username);
        Bundle usernamedata = getIntent().getExtras();
        if (usernamedata == null) {
            return;
        }

        String UserId = usernamedata.getString("UserId");
        UserName.setText(UserId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout HomeScreen = (RelativeLayout) findViewById(R.id.HomeScreen);

        //Menu for background color
        switch(item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                HomeScreen.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                HomeScreen.setBackgroundColor(Color.GREEN);
                return true;
         //   case R.id.menu_yellow:
           //     if(item.isChecked())
             //       item.setChecked(false);
               // else
                 //   item.setChecked(true);
                //HomeScreen.setBackgroundColor(Color.YELLOW);
                //return true;
            case R.id.menu_blue:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                HomeScreen.setBackgroundColor(Color.BLUE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void LogoutonClick(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void ReportsonClick(View view){
        Intent i = new Intent(this,Reports.class);
        startActivity(i);
    }

    public void DailyTaskonClick(View view){
        Intent i = new Intent(this,DailyTask.class);
        startActivity(i);
    }
}
