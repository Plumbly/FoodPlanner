package com.example.jplumbly.foodplanner.TimeTabling;

import java.util.Date;

/**
 * Created by JPlumbly on 6/3/2017.
 */

public abstract class TimeTableItem implements ITimeTableItem {
    public final Date StartDate;

    public final Date EndDate;

    public TimeTableItem(Date startDate, Date endDate){
        StartDate = startDate;
        EndDate = endDate;
    }

}
