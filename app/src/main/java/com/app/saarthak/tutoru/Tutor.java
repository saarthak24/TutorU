package com.app.saarthak.tutoru;

/**
 * Created by Saarthak on 01/28/17.
 */

public class Tutor {
    private String mfullName;
    private String mEmail;
    private String mUsername;
    private String mPhonenumber;
    private String[] mSubjects;

    public Tutor(String fullName, String email, String username, String phonenumber, String[] subjects)
    {
        mfullName = fullName;
        mEmail = email;
        mUsername = username;
        mPhonenumber = phonenumber;
        mSubjects = subjects;
    }

    public String getmfullName() {
        return mfullName;
    }

    public void setmfullName(String mfullName) {
        this.mfullName = mfullName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPhonenumber() {
        return mPhonenumber;
    }

    public void setmPhonenumber(String mPhonenumber) {
        this.mPhonenumber = mPhonenumber;
    }

    public String[] getmSubjects() {
        return mSubjects;
    }

    public void setmSubjects(String[] mSubjects) {
        this.mSubjects = mSubjects;
    }
}
