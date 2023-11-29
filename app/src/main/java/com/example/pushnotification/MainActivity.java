package com.example.pushnotification;

import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set up Notification Channel.  Takes 3 params
        // IMPORTANCE_HIGH = Make a sound and appears as heads up notification
        // IMPORTANCE_DEFAULT = Makes a sound
        // IMPORTANCE_LOW = Makes no sound
        // IMPORTANCE_MIN = Makes no sound and doesn't appear in status bar
        // IMPORTANCE_NONE = Makes no sound and doesn't appear in status bar or shade

        String channelId  = "HEADS_UP_NOTIFICATION";
        String channelName = "Heads Up Channel";
        NotificationManager notificationManager =
                getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                channelName, NotificationManager.IMPORTANCE_HIGH));


    }


}