package com.jutech.besi.Activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jutech.besi.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jawari on 5/20/2015.
 */
public class Morning_Layout extends ListActivity {

    Button Morining_Tasks_Button;

    private ListAdapter listAdapter;
    private TaskDBHelper helper;
    Boolean btnmoni = true;
    CheckBox Breakfast_Example_Checkbox;
    CheckBox Medicine_Example_Checkbox;

    Button Done_Button;
    Button Add_Morning_Activity_Button;
    Button Check_Tasks_Button;
    //    Button Back_To_DailyTasks_Button;
    TextView date_time;
    TextView month_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morning_layout);
        Morining_Tasks_Button = (Button)findViewById(R.id.Morning_Tasks_Button);

        updateUI();
        date_time = (TextView) findViewById(R.id.date_time);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String currentDateTimeString = sdf.format(d);

        month_date = (TextView) findViewById(R.id.month_date);
        SimpleDateFormat sdd = new SimpleDateFormat("MMMM dd");
        Date g = new Date();
        String currentDateTimeString2 = sdd.format(g);



// textView is the TextView view that should display it
        date_time.setText(currentDateTimeString);
        month_date.setText(currentDateTimeString2);
        final Vibrator vibe = (Vibrator) Morning_Layout.this.getSystemService(Context.VIBRATOR_SERVICE);
//        Back_To_DailyTasks_Button = (Button)findViewById(R.id.Back_To_DailyTasks_Button);
//        Back_To_DailyTasks_Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vibe.vibrate(80);
//                Back_To_DailyTasks_Button.setBackgroundResource(R.drawable.button_selector2);
//                startActivity(new Intent(getApplicationContext(),MainActivity.class) );
//            }
//        });
//        addListenerOnButtonClick();
//
//
//
//    }
//    public void addListenerOnButtonClick() {
//        final Vibrator vibe = (Vibrator) Morning_Layout.this.getSystemService(Context.VIBRATOR_SERVICE);
//        Breakfast_Example_Checkbox = (CheckBox)findViewById(R.id.PrepareBreakfast_Example_Checkbox);
//        Medicine_Example_Checkbox = (CheckBox)findViewById(R.id.Chores_Example_Checkbox);
        Add_Morning_Activity_Button = (Button) findViewById(R.id.Add_Morning_Activity_Button);
        Add_Morning_Activity_Button.setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View v) {
                                                               AlertDialog.Builder builder = new AlertDialog.Builder(Morning_Layout.this);
                                                               builder.setTitle("Add New Activity");
                                                               builder.setMessage("Type Activity Below!");
                                                               final EditText inputField = new EditText(Morning_Layout.this);
                                                               builder.setView(inputField);
                                                               builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                                                   @Override
                                                                   public void onClick(DialogInterface dialogInterface, int i) {
                                                                       String task = inputField.getText().toString();
                                                                       Log.d("MainActivity", task);

                                                                       helper = new TaskDBHelper(Morning_Layout.this);
                                                                       SQLiteDatabase db = helper.getWritableDatabase();
                                                                       ContentValues values = new ContentValues();

                                                                       values.clear();
                                                                       values.put(TaskContract.Columns.TASK, task);

                                                                       db.insertWithOnConflict(TaskContract.TABLE, null, values,
                                                                               SQLiteDatabase.CONFLICT_IGNORE);
                                                                       updateUI();

                                                                   }
                                                               });

                                                               builder.setNegativeButton("Cancel", null);

                                                               builder.create().show();
                                                               return;


                                                           }
                                                       }
        );
        Check_Tasks_Button = (Button) findViewById(R.id.Check_Tasks_Button);
        Check_Tasks_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                Check_Tasks_Button.setBackgroundResource(R.drawable.button_selector2);

                if (btnmoni == true) {
                    Check_Tasks_Button.setText("Uncheck All Activities");
                    Breakfast_Example_Checkbox.setChecked(true);
                    Medicine_Example_Checkbox.setChecked(true);
                    Check_Tasks_Button.setBackgroundResource(R.drawable.button_selector1);
                    btnmoni = false;
                } else {
                    Check_Tasks_Button.setText("Check All Activities");
                    Breakfast_Example_Checkbox.setChecked(false);
                    Medicine_Example_Checkbox.setChecked(false);
                    btnmoni = true;
                }
            }
        });
        Done_Button = (Button) findViewById(R.id.Done_Button);
        Done_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog diaBox = makeAndShowDialogBox();

                diaBox.show();
                final Vibrator vibe = (Vibrator) Morning_Layout.this.getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(80);
                Done_Button.setBackgroundResource(R.drawable.button_selector2);
                startActivity(new Intent(getApplicationContext(), DailyTask.class));
                if (Breakfast_Example_Checkbox.isChecked()) {

                    Toast.makeText(getApplicationContext(), "Remember to Administer Medicine", Toast.LENGTH_SHORT).show();
                }
                if (Medicine_Example_Checkbox.isChecked()) {

                    Toast.makeText(getApplicationContext(), "Remember to Serve Breakfast", Toast.LENGTH_SHORT).show();
                }
                if (Medicine_Example_Checkbox.isChecked() && Breakfast_Example_Checkbox.isChecked()) {

                    Toast.makeText(getApplicationContext(), "You have completed all tasks this morning!", Toast.LENGTH_SHORT).show();
                }


            }


        });}





    private void updateUI() {
        helper = new TaskDBHelper(Morning_Layout.this);
        SQLiteDatabase sqlDB = helper.getReadableDatabase();
        Cursor cursor = sqlDB.query(TaskContract.TABLE,
                new String[]{TaskContract.Columns._ID, TaskContract.Columns.TASK},
                null,null,null,null,null);

        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.morning_activities_view,
                cursor,
                new String[] { TaskContract.Columns.TASK},
                new int[] { R.id.morning_activitiescheckbox},
                0
        );
        this.setListAdapter(listAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    private AlertDialog makeAndShowDialogBox() {

        AlertDialog myQuittingDialogBox =

                new AlertDialog.Builder(this)
                        //set message, title, and icon
                        .setTitle("Terminator")
                        .setMessage("Are you sure that you want to quit?")
                        .setIcon(R.drawable.add_checklist)

                                //set three option buttons
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })//setPositiveButton
        /*	.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int whichButton) {
            	 //whatever should be done when answering "NO" goes here
        		 msg = "Cancel " + Integer.toString(whichButton);
        		 txtMsg.setText(msg);
        		}
        		})*/


                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        })//setNegativeButton

                        .create();

        return myQuittingDialogBox;
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
    public void addchecklist(View view) {
        Toast.makeText(getApplicationContext(), "Open Window with checklist preferences", Toast.LENGTH_LONG).show();
    }


}






