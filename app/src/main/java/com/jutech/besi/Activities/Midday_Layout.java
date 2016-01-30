package com.jutech.besi.Activities;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jutech.besi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jawari on 5/20/2015.
 */
public class Midday_Layout extends ListActivity {


    /**
     * Items entered by the user is stored in this ArrayList variable
     */
    ArrayList<String> list = new ArrayList<>();

    /**
     * Declaring an ArrayAdapter to set items to ListView
     */
    ArrayAdapter<String> adapter;

    //    TextView text1;
    Boolean isPressed = false;
    Boolean btnmoni2 = true;
    ImageButton importance_circle1;
    ImageButton add_more_checks02;
    TextView date_time02;
    TextView month_date02;

    Button Done_Button02;

    Button Check_Tasks_Button02;
    Button Back_To_DailyTasks_Button02;
    Button Add_Midday_Activity_Button;

//    private int currentImage = 0;
//    int[] images = { R.drawable.green_circle, R.drawable.orange_circle, R.drawable.red_circle };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.midday_layout);

        final Intent intent = new Intent(this, CountrycodeActivity.class);
        adapter = new ArrayAdapter<String>(this, R.layout.row, R.id.text1, list);
//        importance_circle1 = (ImageButton)findViewById(R.id.importance_circle);
        add_more_checks02 = (ImageButton) findViewById(R.id.add_more_checks02);


//        text1 = (TextView)findViewById(R.id.text1);
        date_time02 = (TextView) findViewById(R.id.date_time02);
        month_date02 = (TextView) findViewById(R.id.month_date02);
        Done_Button02 = (Button) findViewById(R.id.Done_Button02);

        setListAdapter(adapter);
        Add_Midday_Activity_Button = (Button) findViewById(R.id.Add_Midday_Activity_Button);


        SimpleDateFormat sdf02 = new SimpleDateFormat("EEEE");
        Date d02 = new Date();
        String currentDateTimeString02 = sdf02.format(d02);

        SimpleDateFormat sdd02 = new SimpleDateFormat("MMMM dd");
        Date g02 = new Date();
        String currentDateTimeString202 = sdd02.format(g02);

        date_time02.setText(currentDateTimeString02);
        month_date02.setText(currentDateTimeString202);

        Check_Tasks_Button02 = (Button) findViewById(R.id.Check_Tasks_Button02);
        Back_To_DailyTasks_Button02 = (Button) findViewById(R.id.Back_To_DailyTasks_Button2);

        Back_To_DailyTasks_Button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back_To_DailyTasks_Button02.setBackgroundResource(R.drawable.button_selector2);
                startActivity(new Intent(getApplicationContext(), DailyTask.class));
            }
        });
        addListenerOnButtonClick();

        add_more_checks02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 1);
            }

//            @Override
//            public void onClick(View v) {
//                final CharSequence[] items = {"India", "US", "UK", "Australia"};
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(Midday_Layout.this);
//                builder.setTitle("Alert Dialog with ListView and Radio button");
//
//                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int item) {
//                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                builder.setPositiveButton("Yes",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Toast.makeText(Midday_Layout.this, "Success", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                builder.setNegativeButton("No",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Toast.makeText(Midday_Layout.this, "Fail", Toast.LENGTH_SHORT).show();
//                            }
//
//                        });
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
        });

//        registerForContextMenu(importance_circle1);



    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            String countryCode = data.getStringExtra(CountrycodeActivity.RESULT_CONTRYCODE);
            Toast.makeText(this, "You have selected " + countryCode, Toast.LENGTH_LONG).show();
            list.add(countryCode.toString());
            adapter.notifyDataSetChanged();
        }
    }
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo) {
//
//                super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.importance_menu, menu);
//        }
//
//
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_red:
//                Toast.makeText(this, "red called", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.menu_blue:
//                Toast.makeText(this, "blue called", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.menu_green:
//                Toast.makeText(this, "green called", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
//int i = 0;
//    if (i == 0){
//        importance_circle1.setBackgroundResource(R.drawable.red_circle);
//        i = 1;
//
//    }
//    if (i == 1){
//        importance_circle1.setBackgroundResource(R.drawable.orange_circle);
//
//    }
//
//    if (i == 2){
//        importance_circle1.setBackgroundResource(R.drawable.red_circle);
//        i = 0;
//    }

    public void addListenerOnButtonClick() {
        Check_Tasks_Button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "This will check or uncheck all of the activities", Toast.LENGTH_LONG).show();
                if (btnmoni2 == true) {
                    Check_Tasks_Button02.setText("Uncheck All Activities");
                    Check_Tasks_Button02.setBackgroundResource(R.drawable.button_selector2);

//                    Check_Tasks_Button02.setBackgroundResource(R.drawable.button_selector1);
                    btnmoni2 = false;
                } else {
                    Check_Tasks_Button02.setText("Check All Activities");
                    Check_Tasks_Button02.setBackgroundResource(R.drawable.button_selector1);
                    btnmoni2 = true;
                }
            }
        });


        /*Done_Button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This will remove all checked activities", Toast.LENGTH_LONG).show();
                View v = (View) view.getParent();
                CheckBox taskTextView = (CheckBox) v.findViewById(R.id.checkky);
                TextView text1 = (TextView)v.findViewById(R.id.text1);
                if (taskTextView.isChecked()) {

                    adapter.notifyDataSetChanged();
                }
//                SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
//                int itemCount = getListView().getCount();
//
//
//                for (int i = itemCount - 1; i >= 0; i--) {
//                    if (checkedItemPositions.get(i)) {
//                        adapter.remove(list.get(i));
//                    }
//                }
//                checkedItemPositions.clear();



            }


        });*/


        Add_Midday_Activity_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Midday_Activity_Button.setBackgroundResource(R.drawable.button_selector2);
                AlertDialog.Builder builder = new AlertDialog.Builder(Midday_Layout.this);
                builder.setTitle("Add New Activity");
                builder.setMessage("Type Activity Below!");
                final EditText inputField = new EditText(Midday_Layout.this);

                builder.setView(inputField);
                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        list.add(inputField.getText().toString());
                        inputField.setText("");
                        adapter.notifyDataSetChanged();


                    }
                });

                builder.setNegativeButton("Cancel", null);
                Add_Midday_Activity_Button.setBackgroundResource(R.drawable.button_selector1);
                builder.create().show();
                return;


            }


        });
    }

    public void circlebutton(View view) {

        Toast.makeText(getApplicationContext(), "User will change importance indicator to different color to help determine importance of activity ", Toast.LENGTH_LONG).show();

    }



}