package com.example.pushnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.Manifest;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

// TODO ADD THIS CLASS
public class PushNotificationService extends FirebaseMessagingService {

    private static final int PERMISSION_REQUEST_CODE = 123;


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //Get title and body of notification
        String title = remoteMessage.getNotification().getTitle();
        String text = remoteMessage.getNotification().getBody();

        //Set up Notification Channel.  Takes 3 params
        // IMPORTANCE_HIGH = Make a sound and appears as heads up notification
        // IMPORTANCE_DEFAULT = Makes a sound
        // IMPORTANCE_LOW = Makes no sound
        // IMPORTANCE_MIN = Makes no sound and doesn't appear in status bar
        // IMPORTANCE_NONE = Makes no sound and doesn't appear in status bar or shade
        final String CHANNEL_ID = "HEADS_UP_NOTIFICATION";
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "Heads up notification",
                NotificationManager.IMPORTANCE_HIGH
        );
        //Add channel to Android device
        getSystemService(NotificationManager.class).createNotificationChannel(channel);

        //Create notification
        Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID);

        //Set title and text
        notification.setContentTitle(title);
        notification.setContentText(text);

        //Provide small icon for notification
        notification.setSmallIcon(R.drawable.firebase_small);

        //Make notification go away when we tap on it
        notification.setAutoCancel(true);

        //Send notification through channel so that it gets displayed
        int notificationId = 1; // Unique identifier for the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, notification.build());
    }
}
