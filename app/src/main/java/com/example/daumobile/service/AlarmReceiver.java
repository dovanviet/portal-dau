package com.example.daumobile.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.daumobile.R;
import com.example.daumobile.database.Constants;
import com.example.daumobile.ui.home.HomeActivity;
import com.example.daumobile.ui.login.LoginActivity;
import com.example.daumobile.utils.SharePrefUtils;

/**
 * Created by TranTien on 2/25/21.
 */

public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "__AlarmReceiver";

    Intent notificationIntent;
    PendingIntent contentIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Constants.BC_NOTIFY)){
            String title = intent.getStringExtra(Constants.IT_NOTIFY_TITLE);
            String content = intent.getStringExtra(Constants.IT_NOTIFY_CONTENT);

            notificationIntent = new Intent(context, HomeActivity.class);
            if (SharePrefUtils.getInstance(context).isDestroy()) {
                notificationIntent = new Intent(context, LoginActivity.class);
            }

            notificationIntent
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            int requestID = (int) System.currentTimeMillis();
            contentIntent = PendingIntent
                    .getActivity(context, requestID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(title)
                            .setContentText(content)
                            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                            .setDefaults(Notification.DEFAULT_SOUND)
                            .setAutoCancel(true)
                            .setPriority(6)
                            .setContentIntent(contentIntent);
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        }
    }

    public void showNoti() {

    }
}
