package com.nychareport.backlog;

import com.firebase.client.Firebase;

/**
 * Created by User_1_Benjamin_Rosenthal on 4/5/16.
 */
public class BackLogApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /* Initialize Firebase */
        Firebase.setAndroidContext(this);
        /* Enable disk persistence  */
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

}
