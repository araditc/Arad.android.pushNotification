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
            AradPushNotification.fireMessage(remoteMessage.getData().get("data"));
        } else {
            AppUtil.runOnUIThread(this, () -> Glide.with(FirebaseService.this)
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
