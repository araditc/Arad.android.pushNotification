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

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.araditc.pushnotification.provider.GsonParserProvider;
import com.araditc.pushnotification.struct.AudioStruct;
import com.araditc.pushnotification.struct.ContactStruct;
import com.araditc.pushnotification.struct.CustomStruct;
import com.araditc.pushnotification.struct.DocumentStruct;
import com.araditc.pushnotification.struct.ImageStruct;
import com.araditc.pushnotification.struct.LocationStruct;
import com.araditc.pushnotification.struct.MessageTemplate;
import com.araditc.pushnotification.struct.TextStruct;
import com.araditc.pushnotification.struct.VideoStruct;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import static com.araditc.pushnotification.consts.MessageTypes.AUDIO;
import static com.araditc.pushnotification.consts.MessageTypes.CONTACT;
import static com.araditc.pushnotification.consts.MessageTypes.CUSTOM;
import static com.araditc.pushnotification.consts.MessageTypes.DOCUMENT;
import static com.araditc.pushnotification.consts.MessageTypes.IMAGE;
import static com.araditc.pushnotification.consts.MessageTypes.LOCATION;
import static com.araditc.pushnotification.consts.MessageTypes.TEXT;
import static com.araditc.pushnotification.consts.MessageTypes.VIDEO;

public final class FirebaseService extends FirebaseMessagingService {

    private final String NOTIFICATION_TYPE_MESSAGE_TEXT = "MESSAGE_TEXT";
    private final String NOTIFICATION_TYPE_MESSAGE_IMAGE = "MESSAGE_IMAGE";
    private final String NOTIFICATION_TYPE_MESSAGE_VIDEO = "MESSAGE_VIDEO";
    private final String NOTIFICATION_TYPE_MESSAGE_AUDIO = "MESSAGE_AUDIO";
    private final String NOTIFICATION_TYPE_MESSAGE_DOCUMENT = "MESSAGE_DOCUMENT";
    private final String NOTIFICATION_TYPE_MESSAGE_LOCATION = "MESSAGE_LOCATION";
    private final String NOTIFICATION_TYPE_MESSAGE_CONTACT = "MESSAGE_CONTACT";
    private final String NOTIFICATION_TYPE_MESSAGE_CUSTOM = "MESSAGE_CUSTOM";
    private Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        gson = GsonParserProvider.provideMessageTemplate();
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (!remoteMessage.getData().get("data").equals("")) {
            try {
                String dataString = remoteMessage.getData().get("data");
                int type=new JSONObject(dataString).getInt("type");
                MessageTemplate messageTemplate;

                switch (type) {

                    case TEXT:
                        messageTemplate = gson.fromJson(dataString, TextStruct.class);
                        break;

                    case IMAGE:
                        messageTemplate = gson.fromJson(dataString, ImageStruct.class);
                        break;

                    case VIDEO:
                        messageTemplate = gson.fromJson(dataString, VideoStruct.class);

                        break;

                    case AUDIO:
                        messageTemplate = gson.fromJson(dataString, AudioStruct.class);

                        break;

                    case LOCATION:
                        messageTemplate = gson.fromJson(dataString, LocationStruct.class);

                        break;

                    case CONTACT:
                        messageTemplate = gson.fromJson(dataString, ContactStruct.class);

                        break;

                    case DOCUMENT:
                        messageTemplate = gson.fromJson(dataString, DocumentStruct.class);

                        break;

                    case CUSTOM:
                        messageTemplate = gson.fromJson(dataString, CustomStruct.class);

                        break;

                    default:
                        return;

                }

                AradPushNotification.fireMessage(getMainLooper(), messageTemplate);
            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            AppUtil.runOnUIThread(getMainLooper(), () -> Glide.with(FirebaseService.this)
                    .asBitmap()
                    .load(remoteMessage.getNotification().getImageUrl().toString())
                    .into(new CustomTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            NotificationBuilder.showNotification(FirebaseService.this,
                                    R.drawable.common_google_signin_btn_icon_dark,
                                    resource,
                                    remoteMessage.getNotification().getTitle(),
                                    remoteMessage.getNotification().getBody());
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                            NotificationBuilder.showNotification(FirebaseService.this,
                                    R.drawable.common_google_signin_btn_icon_dark,
                                    null,
                                    remoteMessage.getNotification().getTitle(),
                                    remoteMessage.getNotification().getBody());
                        }
                    }), 100);
        }
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

}
