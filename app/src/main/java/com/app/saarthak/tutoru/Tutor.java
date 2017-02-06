package com.app.saarthak.tutoru;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Saarthak on 01/28/17.
 */

public class Tutor {
    private String mfullName;
    private String mEmail;
    private String mUsername;
    private String mPhonenumber;
    private String mPassword;
    private ArrayList<String> mSubjects;
    private URL mprofilePicture;

    public Tutor(String fullName, String email, String username, String phonenumber, String password, ArrayList<String> subjects)
    {
        mfullName = fullName;
        mEmail = email;
        mUsername = username;
        mPhonenumber = phonenumber;
        mPassword = password;
        mSubjects = subjects;
    }

    public Tutor(URL profilePicture, String fullName, String email, String username, String phonenumber, String password, ArrayList<String> subjects)
    {
        mprofilePicture = profilePicture;
        mfullName = fullName;
        mEmail = email;
        mUsername = username;
        mPhonenumber = phonenumber;
        mPassword = password;
        mSubjects = subjects;
    }

    public Tutor()
    {

    }

    public URL getMprofilePicture() {
        return mprofilePicture;
    }

    public void setMprofilePicture(URL mprofilePicture) {
        this.mprofilePicture = mprofilePicture;
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

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public ArrayList<String> getmSubjects() {
        return mSubjects;
    }

    public void setmSubjects(ArrayList<String> mSubjects) {
        this.mSubjects = mSubjects;
    }
}
