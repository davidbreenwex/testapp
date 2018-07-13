package com.dbreen.testapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.util.Log;

import com.swrve.sdk.SwrveSDK;
import com.swrve.sdk.config.SwrveConfig;

public class MyApplication extends Application {

    // TODO Enter your app_id and api_key here
    private int APP_ID = -1;
    private String API_KEY = "YOUR API KEY HERE";

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            SwrveConfig config = new SwrveConfig();

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("<notification-channel-id>", "<Notification-channel-description>", NotificationManager.IMPORTANCE_DEFAULT);
                config.setDefaultNotificationChannel(channel);
            }

            SwrveSDK.createInstance(this, APP_ID, API_KEY, config);
        } catch (IllegalArgumentException exp) {
            Log.e("SwrveDemo", "Could not initialize the Swrve SDK", exp);
        }
    }
}
