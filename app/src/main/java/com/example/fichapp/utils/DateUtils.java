package com.example.fichapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static String completeDateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(completeDate, localeDefault);
        return format.format(date);
    }

    public static String toDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat, localeDefault);
        return format.format(date);
    }

    public static String toTimeString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", localeDefault);
        return format.format(date);
    }

    public static Date stringToDate(String dateString) {
        Date date;
        try {
            date = new SimpleDateFormat(completeDate, localeDefault).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }
        return date;
    }

    public static String differenceBetweenTwoDates(Date firstDate, Date secondDate){
        TimeUnit timeUnit = TimeUnit.HOURS;
        long diffInMillies = firstDate.getTime() - secondDate.getTime();
        timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private static final String completeDate = "dd/MM/yyyy HH:mm:ss";
    private static final String dateFormat = "dd/MM/yyyy";
    private static final Locale localeDefault = Locale.getDefault();
}
