package com.sunil.actorsdemo.ui.mvp;

import com.sunil.actorsdemo.business.data.ActorsUseCase;
import com.sunil.actorsdemo.business.model.ActorsDataObject;
import com.sunil.actorsdemo.business.model.ActorsDomainModel;

import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * Created by sunil on 01-01-2018.
 */

public class ActorListPresenter implements ActorListContract.Presenter{

    private ActorListContract.View mView;
    private ActorsUseCase mActorUsecase;

    public ActorListPresenter(final ActorsUseCase actorsUseCase , final ActorListContract.View actorView)
    {
        mActorUsecase = actorsUseCase;
        mView = actorView;
    }

    @Override
    public void getActorsList() {
        mActorUsecase.getActors()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> mView.loadActorList(response),
                        error -> mView.displayErrorResponse(error.getMessage())
                );
    }

    @Override
    public void onActorClicked(ActorsDataObject mActor) {
        mView.openActorDetails(mActor);
    }
}
