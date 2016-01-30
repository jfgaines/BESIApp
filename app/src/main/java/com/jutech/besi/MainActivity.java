package com.jutech.besi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.SQLException;

//Login Screen
public class MainActivity extends Activity {

    Button btnSignIn,btnSignUp;
    LoginDatabaseAdapter loginDataBaseAdapter;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // create a instance of SQLite Database
        loginDataBaseAdapter = new LoginDatabaseAdapter(this);
        try {
            loginDataBaseAdapter = loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Get the reference Of Buttons
        btnSignIn=(Button)findViewById(R.id.SigninBtn);
        btnSignUp=(Button)findViewById(R.id.RegisterBtn);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // Create Intent for SignUpActivity and Start The Activity
                Intent intentSignUP = new Intent(getBaseContext(), CaregiverRegister.class);
                startActivity(intentSignUP);
            }
        });
    }

    //Method to handleClick Event of Sign Up Button
    public void signUp(View V){
        // Create Intent for SignUpActivity and Start The Activity
        Intent intentSignUP = new Intent(getBaseContext(), CaregiverRegister.class);
        startActivity(intentSignUP);
    }
/*
    // Method to handleClick Event of Sign In Button
    public void signIn(View V)
    {
        final Dialog userdialog = new Dialog(MainActivity.this);
        final Dialog pwdialog = new Dialog(MainActivity.this);
        userdialog.setContentView(R.layout.usernamelogin);
        pwdialog.setContentView(R.layout.password_entry_activity);
        //dialog.setTitle("Login");

        // get the reference of views
        //final EditText editTextUserName=(EditText)userdialog.findViewById(R.id.editTextUserNameToLogin);
        //final  EditText editTextPassword=(EditText)pwdialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)userdialog.findViewById(R.id.buttonSignIn);
        //editTextPassword.setVisibility(View.GONE);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // get The User name and Password
                //String userName=editTextUserName.getText().toString();
                //String password_entry_activity=editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                //String storedPassword=loginDataBaseAdapter.getSingleEntry(userName);

                // check if the Stored password_entry_activity matches with  Password entered by user
                //if(password_entry_activity.equals(storedPassword))
                {
                    //Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_SHORT).show();
                }
                //else
                {
                    // Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }

                userdialog.dismiss();
            }
        });

        //Show dialog box
        userdialog.show();

        //login bypass
       // Intent i = new Intent(this,HomeScreen.class);
       // startActivity(i);
    }*/

    public void signIn(View view){
        Intent i = new Intent(this,usernamelogin.class);
        startActivity(i);
    }

    public void ConfirmonClick(View view){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.registerconfirm);
        dialog.show();
    }

    public void LoginonClick(View view){
        Intent i = new Intent(this,HomeScreen.class);
        startActivity(i);
    }

    public void bypass(View view){
        Intent i = new Intent(this,HomeScreen.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}

