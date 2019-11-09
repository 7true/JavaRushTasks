package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("Jan 1 2019"));
    }

    public static boolean isDateOdd(String date) {

        Date startYear = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        try {
            Date today = format.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
            if (dayOfYear % 2 == 1)
                return true;
            else
                return false;
            //System.out.println(dayOfYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }
}
