package com.sunil.actorsdemo.business.data;

import com.sunil.actorsdemo.business.model.ActorsDomainModel;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by sunil on 01-01-2018.
 */

public class ActorsUseCase {

    private static final String TAG = ActorsUseCase.class.getSimpleName();

    private ActorsApi mActorsApi;

    public ActorsUseCase(ActorsApi actorsApi) {
        if(actorsApi != null)
        {
            mActorsApi = actorsApi;
        }

    }

    /**
     * Retrieves the list of actors from the server using Rxjava observable and
     * the result is published.
     * @return {@link ActorsDomainModel}
     */
    public Observable<ActorsDomainModel> getActors() {
        return Observable.defer(() -> {
            return mActorsApi.getActors();
        })
                .subscribeOn(Schedulers.io())
                .map(Response::body);
    }
}
