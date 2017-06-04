package com.example.jplumbly.foodplanner.SQLConnection;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JPlumbly on 6/3/2017.
 */

public class FoodPlannerDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FoodPlannerDB";

    private static final int DATABASE_VERSION = 2;

    public FoodPlannerDBHelper(){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String ConstructCreateTableString(String tableName){
        return "";
    }
}
