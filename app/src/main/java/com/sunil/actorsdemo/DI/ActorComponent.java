package com.sunil.actorsdemo.DI;

import com.sunil.actorsdemo.ui.fragments.ActorsListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunil on 01-01-2018.
 */

@Singleton
@Component(modules = ActorsModule.class)
public interface ActorComponent {
    void inject(ActorsListFragment actors);

}
