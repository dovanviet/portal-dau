package com.example.daumobile.utils;

import android.content.Context;
import android.content.ContextWrapper;

import androidx.annotation.NonNull;

import com.example.daumobile.database.Constants;
import com.pixplicity.easyprefs.library.Prefs;

public class SharePrefUtils {
    private static SharePrefUtils mInstance;
//    private Prefs.Builder mBuilder;

    private SharePrefUtils(@NonNull Context context) {
        new Prefs.Builder()
                .setContext(context)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(context.getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }

    public static SharePrefUtils getInstance(@NonNull Context context) {
        if (mInstance == null) {
            mInstance = new SharePrefUtils(context);
        }
        return mInstance;
    }

    public void saveSemester(int semester) {
        Prefs.putInt(Constants.PREF_SEMESTER, semester);
    }

    public int getSemester() {
        return Prefs.getInt(Constants.PREF_SEMESTER, 1);
    }

    public void saveYear(String year) {
        Prefs.putString(Constants.PREF_YEAR, year);
    }

    public String getYear() {
        return Prefs.getString(Constants.PREF_YEAR, "2018-2019");
    }

    public void saveWeek(int week) {
        Prefs.putInt(Constants.PREF_WEEK, week);
    }

    public int getWeek() {
        return Prefs.getInt(Constants.PREF_WEEK, 1);
    }

    public void saveClassStudent(String _class) { Prefs.putString(Constants.PREF_CLASS, _class);}

    public String getClassStudent() { return Prefs.getString(Constants.PREF_CLASS, "");}

    public void setIsDestroy(Boolean isDestroy) { Prefs.putBoolean(Constants.PREF_DESTROY, isDestroy);}

    public Boolean isDestroy() { return Prefs.getBoolean(Constants.PREF_DESTROY, true);}
}
