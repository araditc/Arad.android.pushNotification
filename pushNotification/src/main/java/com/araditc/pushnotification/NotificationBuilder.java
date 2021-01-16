/*
 * Copyright 2013 Square, Inc.
 *
 * Licensed under the Arad License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://arad-itc.com/%D8%AF%D8%B1%D8%A8%D8%A7%D8%B1%D9%87-%D9%85%D8%A7/%DA%AF%D9%88%D8%A7%D9%87%DB%8C%D9%86%D8%A7%D9%85%D9%87-%D8%A7%DB%8C%D8%B2%D9%88-90012008
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.araditc.pushnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public final class NotificationBuilder {
    public static final int NOTIFY_ID = 1002;
    public static final int REQUEST_CODE = 1003;
    public static String ID = "21458752";

    public static void showNotification(Context context, int iconId, Bitmap largeIcon, String title, String body) {

        String description = "سیستم نوتیفیکیشن آراد";

        NotificationCompat.Builder builder;
        NotificationManager notifManager;
        notifManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String packageName = context.getPackageName();
        Intent notificationIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(context, REQUEST_CODE,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = notifManager.getNotificationChannel(ID);
            if (mChannel == null) {
                mChannel = new NotificationChannel(ID, title, importance);
                mChannel.setDescription(description);
                mChannel.enableVibration(true);
                mChannel.setSound(null, null);
                mChannel.setLightColor(Color.GREEN);
                mChannel.setVibrationPattern(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0});

                notifManager.createNotificationChannel(mChannel);
            }

            builder = new NotificationCompat.Builder(context, ID);
            builder.setContentTitle(title)
                    .setSmallIcon(iconId)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setPriority(Notification.PRIORITY_MAX)
                    .setShowWhen(false);
        } else {
            builder = new NotificationCompat.Builder(context);

            builder.setContentTitle(title)
                    .setSmallIcon(iconId) // required
                    .setContentText(body)  // required
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setShowWhen(false);
        }

        if (largeIcon != null)
            builder.setLargeIcon(largeIcon);

        builder.setContentIntent(contentIntent);
        notifManager.notify(NOTIFY_ID, builder.build());
    }
}
