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

import android.os.Looper;

import com.araditc.pushnotification.struct.AudioStruct;
import com.araditc.pushnotification.struct.ContactStruct;
import com.araditc.pushnotification.struct.CustomStruct;
import com.araditc.pushnotification.struct.DocumentStruct;
import com.araditc.pushnotification.struct.ImageStruct;
import com.araditc.pushnotification.struct.LocationStruct;
import com.araditc.pushnotification.struct.MessageTemplate;
import com.araditc.pushnotification.struct.TextStruct;
import com.araditc.pushnotification.struct.VideoStruct;

import java.util.ArrayList;
import java.util.List;

import static com.araditc.pushnotification.consts.MessageTypes.AUDIO;
import static com.araditc.pushnotification.consts.MessageTypes.CONTACT;
import static com.araditc.pushnotification.consts.MessageTypes.CUSTOM;
import static com.araditc.pushnotification.consts.MessageTypes.DOCUMENT;
import static com.araditc.pushnotification.consts.MessageTypes.IMAGE;
import static com.araditc.pushnotification.consts.MessageTypes.LOCATION;
import static com.araditc.pushnotification.consts.MessageTypes.TEXT;
import static com.araditc.pushnotification.consts.MessageTypes.VIDEO;

public final class AradPushNotification extends DataObserver{
    @Override
    public void onImageReceived(ImageStruct imageStruct) {
        super.onImageReceived(imageStruct);
    }

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

    public static void fireMessage(Looper looper, MessageTemplate message) {
        AppUtil.runOnUIThread(looper, () -> {
            for (DataObserver dataObserver : dataObserverArrayList) {
                switch (message.getType()) {

                    case TEXT:
                        dataObserver.onTextReceived((TextStruct) message);
                        break;

                    case IMAGE:
                        dataObserver.onImageReceived((ImageStruct) message);
                        break;

                    case VIDEO:
                        dataObserver.onVideoReceived((VideoStruct) message);
                        break;

                    case AUDIO:
                        dataObserver.onAudioReceived((AudioStruct) message);

                        break;

                    case LOCATION:
                        dataObserver.onLocationReceived((LocationStruct) message);

                        break;

                    case CONTACT:
                        dataObserver.onContactReceived((ContactStruct) message);

                        break;

                    case DOCUMENT:
                        dataObserver.onDocumentReceived((DocumentStruct) message);
                        break;

                    case CUSTOM:
                        dataObserver.onCustomReceived((CustomStruct) message);
                        break;

                    default:
                        return;

                }
            }
        }, 0);

    }


}
