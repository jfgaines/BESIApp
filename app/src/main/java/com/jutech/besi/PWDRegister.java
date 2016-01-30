package com.jutech.besi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "PWD")
public class PWDRegister extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwdregister_activity);
    }

    public void CreateAccountonClick(View view){
        Intent i = new Intent(this,HomeScreen.class);
        startActivity(i);
    }
}
