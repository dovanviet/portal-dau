package com.example.daumobile.utils;

import android.annotation.SuppressLint;

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
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date(time));
    }
}
