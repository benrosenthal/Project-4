package com.nychareport.backlog;

/**
 * Created by User_1_Benjamin_Rosenthal on 4/5/16.
 */

/**
 * Constants class store most important strings and paths of the app
 */
public final class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where user lists are stored (ie "userLists")
     */
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_LOCATION_UID_MAPPINGS = "uidMappings";
    public static final String FIREBASE_LOCATION_POSTS = "problems";



    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";
    public static final String FIREBASE_PROPERTY_EMAIL = "email";
    public static final String FIREBASE_PROPERTY_USER_HAS_LOGGED_IN_WITH_PASSWORD = "hasLoggedInWithPassword";
    public static final String FIREBASE_PROPERTY_HOUSING_DEVELOPMENT = "housingDevelopment";


    public static final String FIREBASE_PROPERTY_PROBLEM = "problem";
    public static final String FIREBASE_PROPERTY_PROBLEM_DESCRIPTION = "description";
    public static final String FIREBASE_PROPERTY_PROBLEM_LOCATION = "location";
    public static final String FIREBASE_PROPERTY_PROBLEM_PIC = "problemPic";


    /**
     * Constants for Firebase URL
     */
//    public static final String FIREBASE_URL = BuildConfig.UNIQUE_FIREBASE_ROOT_URL;
    public static final String FIREBASE_URL = "https://nychareport.firebaseio.com";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String FIREBASE_URL_POSTS = FIREBASE_URL + "/" + FIREBASE_LOCATION_POSTS;

    /**
     * Constants for bundles, extras and shared preferences keys
     */
    public static final String KEY_SIGNUP_EMAIL = "SIGNUP_EMAIL";
    public static final String KEY_PROVIDER = "PROVIDER";
    public static final String KEY_ENCODED_EMAIL = "ENCODED_EMAIL";
    public static final String KEY_HOUSING_DEVELOPMENT = "HOUSING_DEVELOPMENT";


    /**
     * Constants for Firebase login
     */
    public static final String PASSWORD_PROVIDER = "password";

    /**
     * Activity request codes
     */
    public static final int REQUEST_CODE_LOAD_FROM_CAMERA = 0;
    public static final int REQUEST_CODE_LOAD_FROM_GALLERY = 1;
}
