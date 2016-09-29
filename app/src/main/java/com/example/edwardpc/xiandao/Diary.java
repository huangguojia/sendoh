package com.example.edwardpc.xiandao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by EdwardPC on 2016/9/27.
 */
public class Diary {
    boolean IsWrite=false;
    int Month;
    int Year;
    String WriteLog;
    int Today;

    Diary(int year,int month,int today,String log){
        Year=year;
        Month=month;
        Today=today;
        this.WriteLog=log;
        IsWrite=true;
    }
    public int getDate() {
        return Year*10000+Month*100+Today;
    }
    public String getWriteLog(){
        return WriteLog;
    }

    /**
     * 判断当前日期是星期几
     *
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
}
