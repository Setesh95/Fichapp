package com.example.fichapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.getDefault());
        return format.format(date);
    }

    public static String toDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        return format.format(date);
    }

    public static String dateToClockString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return format.format(date);
    }
}
