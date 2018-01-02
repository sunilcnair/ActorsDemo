package com.sunil.actorsdemo.ui.mvp;

import com.sunil.actorsdemo.business.model.ActorsDataObject;
import com.sunil.actorsdemo.business.model.ActorsDomainModel;

/**
 * Created by sunil on 31-12-2017.
 */

public interface ActorListContract {

    interface View extends BaseView<Presenter> {
        /**
         * Display actors
         * @param actorList list
         */
        void loadActorList(ActorsDomainModel actorList);

        /**
         * Open actor details page
         * @param mActor object
         */
        void openActorDetails(ActorsDataObject mActor);

        /**
         * Display error message
         * @param errorMessage string
         */
        void displayErrorResponse(String errorMessage);

        /**
         * Show a loading view with a progress bar indicating a loading process.
         */
        void showLoading();

        /**
         * Hide a loading view.
         */
        void hideLoading();


    }

    interface Presenter extends BasePresenter {
        /**
         * Method to get actor list
         */
        void getActorsList();

        /**
         * Handle actor item click
         * @param mActor object
         */
        void onActorClicked(ActorsDataObject mActor);

    }
}

