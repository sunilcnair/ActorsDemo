package com.sunil.actorsdemo.business.data;

import com.sunil.actorsdemo.business.model.ActorsDomainModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by sunil on 01-01-2018.
 */



public interface ActorsApi {

    /**
     * Get list of actors
     * @return {@link ActorsDomainModel} with all details
     */
    @GET("jsonActors")
    Observable<Response<ActorsDomainModel>> getActors();

}
