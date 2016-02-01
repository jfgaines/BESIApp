package com.jutech.besi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OpenHelperManager;

//model class for Caregiver
//@DatabaseTable(tableName = "Caregiver")
public class CaregiverRegister extends Activity implements View.OnClickListener {

    //Reference of DatabaseHelper class to access its DOA and other components
    private DatabaseHelper databaseHelper = null;

    //Reference of widgets
    EditText CaregiverFirstNameText, CaregiverLastNameText,CaregiverUsernameText,CaregiverPasswordText,CaregiverConfirmPasswordText,CaregiverMobileNumberText;
    Button CaregiverAccountCreateBtn,ContactNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregiver_register_activity);

        //Get References of Views
        //@DatabaseField(id = true)
        CaregiverFirstNameText = (EditText)findViewById(R.id.CaregiverFirstNameText);
        CaregiverLastNameText = (EditText)findViewById(R.id.CaregiverLastNameText);
        CaregiverUsernameText = (EditText)findViewById(R.id.CaregiverUsernameText);
        CaregiverPasswordText = (EditText)findViewById(R.id.CaregiverPasswordText);
        CaregiverConfirmPasswordText = (EditText)findViewById(R.id.CaregiverConfirmPasswordText);
        CaregiverMobileNumberText = (EditText)findViewById(R.id.CaregiverMobileNumberText);
        CaregiverAccountCreateBtn = (Button)findViewById(R.id.CaregiverAccountCreateBtn);

        CaregiverAccountCreateBtn.setOnClickListener(this); }

    //How DatabaseHelper can be initialized for future use
    private DatabaseHelper getHelper(){
        if(databaseHelper == null){
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
    //test

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //needed to release helper when done
        if(databaseHelper !=null){
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

    @Override
    public void onClick(View view) {
        if(view == CaregiverAccountCreateBtn){
            //all input fields are mandatory, made check
            if(CaregiverFirstNameText.getText().toString().trim().length() > 0 && CaregiverLastNameText.getText().toString().trim().length() > 0
                    && CaregiverFirstNameText.getText().toString().trim().length() > 0 && CaregiverUsernameText.getText().toString().trim().length() > 0
                    && CaregiverPasswordText.getText().toString().trim().length() > 0 && CaregiverConfirmPasswordText.getText().toString().trim().length() > 0
                    && CaregiverMobileNumberText.getText().toString().trim().length() > 0){
                //Once next clicked, creates Caregiver detail object
                //check this might be setup wrong
                final CaregiverRegister caregiverDetails  = new CaregiverRegister();

                //Set all values from caregiver input
                
            }
        }

    }

    public void NextonClick(View view){
        Intent i = new Intent(this,PWDRegister.class);
        startActivity(i);

    }

    public void ConfirmonClick(View view){
        final Dialog dialog = new Dialog(CaregiverRegister.this);
        dialog.setContentView(R.layout.registerconfirm);
        dialog.show();
    }


}
