package com.araditc.pushnotification;

import android.content.Context;
import android.os.Handler;

public class AppUtil {
    public static void runOnUIThread(Context context, Runnable runnable, long delay) {
        Handler applicationHandler = new Handler(context.getMainLooper());

        if (delay == 0) {
            applicationHandler.post(runnable);
        } else {
            applicationHandler.postDelayed(runnable, delay);
        }
    }
}
