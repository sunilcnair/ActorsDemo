package com.sunil.actorsdemo.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sunil on 01-01-2018.
 */

public class ActorsDataObject implements Serializable {

    @SerializedName("name")
    private String mName;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("dob")
    private String mDob;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("height")
    private String mHeight;

    @SerializedName("spouse")
    private String mSpouse;

    @SerializedName("children")
    private String mChildren;

    @SerializedName("image")
    private String mImage;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDob() {
        return mDob;
    }

    public void setmDob(String mDob) {
        this.mDob = mDob;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmHeight() {
        return mHeight;
    }

    public void setmHeight(String mHeight) {
        this.mHeight = mHeight;
    }

    public String getmSpouse() {
        return mSpouse;
    }

    public void setmSpouse(String mSpouse) {
        this.mSpouse = mSpouse;
    }

    public String getmChildren() {
        return mChildren;
    }

    public void setmChildren(String mChildren) {
        this.mChildren = mChildren;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
