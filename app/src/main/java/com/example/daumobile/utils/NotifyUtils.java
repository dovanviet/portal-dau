package com.example.daumobile.utils;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.daumobile.R;
import com.example.daumobile.database.Constants;
import com.example.daumobile.service.AlarmReceiver;
import com.example.daumobile.ui.home.HomeActivity;

public class NotifyUtils {
    private static NotifyUtils mInstance;
    private Context mContext;

    public static final String CHANNEL_ID = "PORTAL_DAU";

    private NotifyUtils(@NonNull Context context) {
        mContext = context;
    }

    public static NotifyUtils getInstance(@NonNull Context context) {
        if (mInstance == null) {
            mInstance = new NotifyUtils(context);
        }
        return mInstance;
    }

    public void showNotifyNow(String title, String content) {
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(mContext, AlarmReceiver.class);
        intent.setAction(Constants.BC_NOTIFY);
        intent.putExtra(Constants.IT_NOTIFY_TITLE, title);
        intent.putExtra(Constants.IT_NOTIFY_CONTENT, content);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        }
    }
}
