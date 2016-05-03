package com.nychareport.backlog.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User_1_Benjamin_Rosenthal on 4/5/16.
 */
public class Problem implements Parcelable {

    private String mProblem;
    private String mProblemDescription;
    private String mProblemLocation;
    private int mProblemPic;

    public Problem(String problem, String problemDescription, String problemLocation, int problemPic) {
        mProblem = problem;
        mProblemDescription = problemDescription;
        mProblemLocation = problemLocation;
        mProblemPic = problemPic;
    }

    public String getProblem() {
        return mProblem;
    }

    public void setProblem(String problem) {
        mProblem = problem;
    }

    public String getProblemDescription() {
        return mProblemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        mProblemDescription = problemDescription;
    }

    public String getProblemLocation() {
        return mProblemLocation;
    }

    public void setProblemLocation(String problemLocation) {
        mProblemLocation = problemLocation;
    }

    public int getProblemPic() {
        return mProblemPic;
    }

    public void setProblemPic(int problemPic) {
        mProblemPic = problemPic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mProblem);
        dest.writeString(mProblemDescription);
        dest.writeString(mProblemLocation);
        dest.writeInt(mProblemPic);
    }

    private Problem(Parcel in){
        mProblem = in.readString();
        mProblemDescription = in.readString();
        mProblemLocation = in.readString();
        mProblemPic = in.readInt();
    }

    public Problem(){}

    public static final Creator<Problem> CREATOR = new Creator<Problem>() {
        @Override
        public Problem createFromParcel(Parcel source) {
            return new Problem(source);
        }

        @Override
        public Problem[] newArray(int size) {
            return new Problem[size];
        }
    };
}

