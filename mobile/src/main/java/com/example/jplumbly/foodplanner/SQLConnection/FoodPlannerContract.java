package com.example.jplumbly.foodplanner.SQLConnection;

import android.provider.BaseColumns;

/**
 * Created by JPlumbly on 6/4/2017.
 */

public class FoodPlannerContract {
    private FoodPlannerContract(){};

    public static class TimeTable implements BaseColumns{
        public static final string TABLE_NAME = "timetable";
        public static final string COLUMN_NAME_TITLE = "title";
    }

    public static class RecipeTimeTableItem implements  BaseColumns {
        public static final string TABLE_NAME = "recipetimetableitem";
    }

    public static void up(){

    }
}
