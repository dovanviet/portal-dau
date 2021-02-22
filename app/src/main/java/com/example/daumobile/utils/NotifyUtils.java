package com.example.daumobile.utils;

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
        Intent intent = new Intent(mContext, HomeActivity.class);
        // use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(mContext, (int) System.currentTimeMillis(), intent, 0);

        Notification mBuilder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(content)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();
        NotificationManager notificationManager = (NotificationManager)
                mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, mBuilder);
    }
}
