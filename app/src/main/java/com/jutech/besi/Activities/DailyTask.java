package com.jutech.besi.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.jutech.besi.Activities.Evening_Layout;
import com.jutech.besi.Activities.Midday_Layout;
import com.jutech.besi.Activities.Morning_Layout;
import com.jutech.besi.HomeScreen;
import com.jutech.besi.R;


public class DailyTask extends ActionBarActivity {

    Button Morining_Tasks_Button;
    Button Midday_Tasks_Button;
    Button Evening_Tasks_Button;
    ImageView Back_To_Home_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task);
        final Vibrator vibe = (Vibrator) DailyTask.this.getSystemService(Context.VIBRATOR_SERVICE);
        Morining_Tasks_Button = (Button)findViewById(R.id.Morning_Tasks_Button);
        Midday_Tasks_Button = (Button)findViewById(R.id.Midday_Tasks_Button);
        Evening_Tasks_Button = (Button)findViewById(R.id.Evening_Tasks_Button);
        Back_To_Home_Button = (ImageView)findViewById(R.id.Home_Button);

        Back_To_Home_Button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),HomeScreen.class) );                            }
                                               }

        );


        Morining_Tasks_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                Morining_Tasks_Button.setBackgroundResource(R.drawable.button_selector2);
                Toast.makeText(getApplicationContext(), "Use Afternoon Button for Demo", Toast.LENGTH_LONG).show();


            }
        });
        Midday_Tasks_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                Midday_Tasks_Button.setBackgroundResource(R.drawable.button_selector2);
                startActivity(new Intent(getApplicationContext(),Midday_Layout.class) ); }
        });
        Evening_Tasks_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                Evening_Tasks_Button.setBackgroundResource(R.drawable.button_selector2);
                Toast.makeText(getApplicationContext(), "Use Afternoon Button for Demo", Toast.LENGTH_LONG).show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}