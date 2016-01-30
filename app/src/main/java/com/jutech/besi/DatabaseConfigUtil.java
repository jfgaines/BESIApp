package com.jutech.besi;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    public static void main(String[] args) throws SQLException, IOException{
        //provide the name of .txt file contained in res/raw directory
        writeConfigFile("ormlite_config.text");
    }
}
