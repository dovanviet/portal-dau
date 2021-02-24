package com.example.daumobile.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static DateUtils mInstance;

    private DateUtils() {}

    public static DateUtils getInstance() {
        if (mInstance == null) {
            mInstance = new DateUtils();
        }
        return mInstance;
    }

    public String formatFullDate(long time) {
        time = time * 1000;

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(time);
        Log.d("____", "formatFullDate: ??? " + time + " date = " + date.toString());
        return dateFormat.format(new Date(time));
    }
}
