package com.jutech.besi;

import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;


public class CaregiverDetails implements Serializable {
    //Model class for com.jutech.besi.CaregiverDetails database table
    private static final long serialVersionUID = -222864131214757024L;

    //primary key defined as an integer = shimmer_id
    //If the database table column name differs then the model class var. name, use columnName to map database
    @DatabaseField(generatedId = false, columnName = "caregiver_id")
    public int CaregiverId;

    //Define a String type field to hold Caregiver's name
    @DatabaseField(columnName = "caregiver_name")
    public String CaregiverName;

    //Define a String type field to hold Caregiver's username
    @DatabaseField(columnName = "caregiver_username")
    public String CaregiverUsername;

    //Define a String type field to hold Caregiver's password
    @DatabaseField(columnName = "caregiver_pw")
    public String CaregiverPW;

    //Define a int type field to hold Caregiver's contact number
    @DatabaseField(columnName = "caregiver_contact")
    public int CaregiverContact;

    //Add other Caregiver inputs

    //Default constructor is needed for the SQLite, must have
    public CaregiverDetails(){}

    //Creating Caregiver Details object
    public CaregiverDetails(final String caregivername, final String username, final String password, final int caregivercontactnumber){
        this.CaregiverName = caregivername;
        this.CaregiverUsername = username;
        this.CaregiverPW = password;
        this.CaregiverContact = caregivercontactnumber;
    }
}
