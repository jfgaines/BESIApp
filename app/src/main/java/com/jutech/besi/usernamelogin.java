package com.jutech.besi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by NCAT on 9/6/2015.
 */
public class usernamelogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.username_entry_activity);

    }

    public void NextonClick(View view){
        Intent i = new Intent(this,pwlogin.class);
        startActivity(i);
    }

    public void LoginonClick(View view){
        Intent i = new Intent(this,HomeScreen.class);
        startActivity(i);
    }
}