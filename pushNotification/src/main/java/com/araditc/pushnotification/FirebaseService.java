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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public final class FirebaseService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (!remoteMessage.getData().get("data").equals("")) {
            AradPushNotification.fireMessage(getMainLooper(),remoteMessage.getData().get("data"));
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
