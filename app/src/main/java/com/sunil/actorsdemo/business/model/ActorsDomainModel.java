package com.sunil.actorsdemo.business.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunil on 01-01-2018.
 */

public class ActorsDomainModel {

    @SerializedName("actors")
    private List<ActorsDataObject> mActor;

    public List<ActorsDataObject> getmActor() {
        return mActor;
    }

    public void setmActor(List<ActorsDataObject> mActor) {
        this.mActor = mActor;
    }
}
