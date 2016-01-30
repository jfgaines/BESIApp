package com.jutech.besi;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.sql.Date;


public class PWDetails implements Serializable {
    //Model class for PWD details database table
    private static final long serialVersionUID = -222864131214757024L;

    //using shimmer device numer as pwd identification
    public static final String ID_FIELD = "pwd_id";
    public static final String CAREGIVER_ID_FIELD = "caregiver_id";

    //Primary key defined as an auto generated integer
    //If the database table column name differs then the model class var. name, use columnName to map database
    @DatabaseField(generatedId = true, columnName = "ID_FIELD")
    public int PwdID;

    //Define a String type field to hold PWD's name
    @DatabaseField(columnName = "pwd_name")
    public String PwdName;

    //Define string to hold PWD's address
    public String PwdAddress;

    //Define string to hold PWD's contact number
    public int PwdNumber;

    //Define string to hold Shimmer device number
    public int ShimmerNumber;

    //Foreign key defined to hold associations
    //double check this to see if correct
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    public CaregiverDetails caregiver;

    //Define a String type field to hold insertion date
    @DatabaseField(columnName = "added_date")
    public Date addedDate;

    //Default constructor is needed for SQLite
    public PWDetails(){}

    //com.jutech.besi.PWDetails object
    public PWDetails(final String pwdname, final String address, final int shimmernumber, final int pwdcontactnumber){
        this.PwdName = pwdname;
        this.PwdAddress = address;
        this.PwdNumber = pwdcontactnumber;
        this.ShimmerNumber = shimmernumber;
    }
}
