package com.sunil.actorsdemo;

import com.sunil.actorsdemo.business.data.ActorsUseCase;
import com.sunil.actorsdemo.business.model.ActorsDataObject;
import com.sunil.actorsdemo.business.model.ActorsDomainModel;
import com.sunil.actorsdemo.ui.mvp.ActorListContract;
import com.sunil.actorsdemo.ui.mvp.ActorListPresenter;

import org.junit.Test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ActorListPresenterTest {

    @Mock
    private ActorListContract.View mMockView;

    @Mock
    private ActorsUseCase mMockActorUsecase;

    private ActorListPresenter mActorListPresenter;

    /**
     * Mockito setup
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mActorListPresenter = new ActorListPresenter(mMockActorUsecase, mMockView);
    }

    /**
     * Test success response for {@link ActorsUseCase#getActors()}
     */
    @Test
    public void testLoadActorsMethodIsCalledIfRequestSuccess() {
        when(mMockActorUsecase.getActors()).thenReturn(Observable.just(getActorsResponse()));
        mActorListPresenter.getActorsList();
        verify(mMockView).loadActorList(any());
    }

    /**
     * Mock data
     * @return {@link ActorsDomainModel}
     */
    private ActorsDomainModel getActorsResponse() {
        ActorsDomainModel actorsResponse = new ActorsDomainModel();
        List<ActorsDataObject> actors = new ArrayList<>();
        ActorsDataObject actor = new ActorsDataObject();
        actor.setmName("Test Actor");
        actor.setmDescription("Test Description");
        actor.setmDob("Test Dob");
        actor.setmCountry("Test Country");
        actor.setmHeight("Test Height");
        actor.setmSpouse("Test Spouse");
        actor.setmChildren("Test Children");
        actor.setmImage("Test Image Url");
        actors.add(actor);
        actorsResponse.setmActor(actors);

        return actorsResponse;
    }

}