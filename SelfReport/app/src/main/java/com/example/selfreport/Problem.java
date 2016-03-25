package com.example.selfreport;

import java.util.Timer;

/**
 * Created by User_1_Benjamin_Rosenthal on 3/22/16.
 */
public class Problem {

    String mProblemType;
    Timer mTimer;
    String mDevelopment;
    String mBuilding;
    String mFloor;
    int mSeverity;

    public String getProblemType() {
        return mProblemType;
    }

    public void setProblemType(String problemType) {
        mProblemType = problemType;
    }

    public Timer getTimer() {
        return mTimer;
    }

    public void setTimer(Timer timer) {
        mTimer = timer;
    }

    public String getDevelopment() {
        return mDevelopment;
    }

    public void setDevelopment(String development) {
        mDevelopment = development;
    }

    public String getBuilding() {
        return mBuilding;
    }

    public void setBuilding(String building) {
        mBuilding = building;
    }

    public String getFloor() {
        return mFloor;
    }

    public void setFloor(String floor) {
        mFloor = floor;
    }

    public int getSeverity() {
        return mSeverity;
    }

    public void setSeverity(int severity) {
        mSeverity = severity;
    }
}
