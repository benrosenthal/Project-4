package com.example.selfreportrefactor;

/**
 * Created by User_1_Benjamin_Rosenthal on 4/3/16.
 */

import android.app.Application;

import com.firebase.client.Firebase;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}//Firebase.getAndroidContext()