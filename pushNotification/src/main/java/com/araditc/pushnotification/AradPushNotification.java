package com.araditc.pushnotification;

import java.util.ArrayList;
import java.util.List;

public final class AradPushNotification {
    private static final List<DataObserver> dataObserverArrayList = new ArrayList<>();

    private AradPushNotification() {
    }

    public static void unregisterDataObserver(DataObserver dataObserver) {
        if (dataObserver == null) return;

        dataObserverArrayList.remove(dataObserver);
    }

    public static void registerDataObserver(DataObserver dataObserver) {
        if (dataObserver == null) return;

        dataObserverArrayList.add(dataObserver);
    }

    public static void fireMessage(Object message) {
        for (DataObserver dataObserver : dataObserverArrayList)
            dataObserver.onMessageReceived(message);
    }
}
