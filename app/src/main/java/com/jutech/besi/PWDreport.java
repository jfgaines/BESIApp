package com.jutech.besi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PWDreport extends Activity implements View.OnClickListener {
    Button DepressionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwd_report);
    }

    public void AgitationonClick(View view){
        Intent i = new Intent(this,AgitationChecklist.class);
        startActivity(i);
    }

    public void DepressiononClick(View view){
        Intent i = new Intent(this,DepressionChecklist.class);
        startActivity(i);
    }

    public void SleeponClick(View view){
        Intent i = new Intent(this,SleepQuality.class);
        startActivity(i);
    }

    /*public void SummaryonClick(View view){
        Intent i = new Intent(this,PWDSummary.class);
        startActivity(i);
    }*/

    public void CommentsonClick(View view){
        Intent i = new Intent(this,CommentsScreen.class);
        startActivity(i);
    }

    public void HomeonClick(View view){
        Intent i = new Intent(this,HomeScreen.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pwdreport, menu);
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

    @Override
    public void onClick(View view) {
        //if (view.getId() == R.id.popupbutton) {
        //    popupMessage.showAsDropDown(popupButton, 0, 0); }
        //else { popupMessage.dismiss(); }

    }
}
