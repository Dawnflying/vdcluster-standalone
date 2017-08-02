package com.xh.vdcluster.common;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by bloom on 2017/7/16.
 */
public class DateUtils {

    public static Date getFromMills(long mills){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        return calendar.getTime();
    }

    public static Date getNow(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.getTime();
    }

}
