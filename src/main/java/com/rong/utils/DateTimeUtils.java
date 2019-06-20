package com.rong.utils;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateTimeUtils {
    //将数据库中的时间戳转换成格式为"yyyy-MM-dd HH:mm:ss"的时间
    public static String  getFormatTime(int time){
        long t = (long)time*1000;

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss");//将毫秒级long值转换成日期格式

        GregorianCalendar gc = new GregorianCalendar();

        gc.setTimeInMillis(t);
        String dateStr = dateformat.format(gc.getTime());
        return  dateStr;
    }

    public static String  getTime(int time){
        long t = (long)time*1000;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");//将毫秒级long值转换成日期格式
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(t);
        String dateStr = dateformat.format(gc.getTime());
        return  dateStr;
    }
    /**
     * 获取当前的时间戳
     *
     * @return
     */
    public static int getCurrentTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}