package com.hello.world.javacore.dateprocess;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xing
 */
public class AddDate {
    public static void main(String[] args) {
        //毫秒数转日期，加1年
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println((startTime+"").substring(4,13));

        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(startTime);
        calendar.add(Calendar.DAY_OF_WEEK,1);
        System.out.println(formater.format(calendar.getTime()));
        System.out.println(calendar.getTime().getTime());
        System.out.println((calendar.getTime().getTime()+"").substring(4,13));

    }
}
