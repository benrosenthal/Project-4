package com.nychareport.backlog;

import com.firebase.client.Firebase;

/**
 * Created by User_1_Benjamin_Rosenthal on 4/5/16.
 */
public class BackLogApplication extends android.app.Application {


    private static BackLogApplication currentInstance = null;
    @Override
    public void onCreate() {
        super.onCreate();
        currentInstance = this;
        /* Initialize Firebase */
        Firebase.setAndroidContext(this);
        /* Enable disk persistence  */
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

    public static synchronized BackLogApplication    getCurrentInstance() {
        return currentInstance;
    }

}
