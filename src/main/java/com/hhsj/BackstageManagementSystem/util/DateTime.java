package com.hhsj.BackstageManagementSystem.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 12789 on 2019/7/19.
 */
public class DateTime {
    public static Date getNextDay(Date date,Integer day){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,+day);//今天的时间加一天
        date=calendar.getTime();
        return date;
    }
}
