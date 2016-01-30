package com.jutech.besi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Reports extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports_activity);
    }

    public void PWDonClick(View view){
        Intent i = new Intent(this,PWDreport.class);
        startActivity(i);

        //receiving usersname from UserId
        final TextView UserName = (TextView) findViewById(R.id.username);
        Bundle usernamedata = getIntent().getExtras();
        if (usernamedata == null) {
            return;
        }

        String UserId = usernamedata.getString("UserId");
        UserName.setText(UserId);

        /*PopupMenu popup = new PopupMenu(this,view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_reports, popup.getMenu());
        popup.show();*/
    }

    public void CareTakeronClick(View view) {
        Intent i = new Intent(this, UserReport.class);
        startActivity(i);
    }

    public void SummaryonClick(View view) {
        Intent i = new Intent(this, PWDSummary.class);
        startActivity(i);
    }

    public void HomeonClick(View view){
        Intent i = new Intent(this,HomeScreen.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reports, menu);
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
