package com.sunil.actorsdemo.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sunil.actorsdemo.DI.ActorComponent;
import com.sunil.actorsdemo.DI.ActorsModule;

import com.sunil.actorsdemo.DI.DaggerActorComponent;
import com.sunil.actorsdemo.R;
import com.sunil.actorsdemo.business.data.ActorsUseCase;
import com.sunil.actorsdemo.business.model.ActorsDataObject;
import com.sunil.actorsdemo.business.model.ActorsDomainModel;
import com.sunil.actorsdemo.ui.activity.ActorDetailsActivity;
import com.sunil.actorsdemo.ui.mvp.ActorListAdapter;
import com.sunil.actorsdemo.ui.mvp.ActorListContract;
import com.sunil.actorsdemo.ui.mvp.ActorListPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Sunil C - 30-12-2017.
 */
public class ActorsListFragment extends Fragment implements ActorListContract.View{

    private static final String TAG = ActorsListFragment.class.getSimpleName();

    @Inject
    ActorsUseCase mActorsUsecase;

    @BindView(R.id.rootView)
    ViewGroup mRootView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.actors_rv)
    RecyclerView mActorRecyclerView;

    private ActorListContract.Presenter mPresenter;
    private ActorListAdapter mAdapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment
     * @return A new instance of fragment ActorsListFragment.
     */
    public static ActorsListFragment newInstance() {
        return new ActorsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mRoot = inflater.inflate(R.layout.fragment_actors_list, container, false);
        ButterKnife.bind(this,mRoot);
        ActorComponent mActorComponent = DaggerActorComponent.builder().actorsModule(new ActorsModule(getContext())).build();
        mActorComponent.inject(this);
        return mRoot;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mPresenter = new ActorListPresenter(mActorsUsecase, this);
        mActorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ActorListAdapter(mPresenter, getContext());
        mActorRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override

    public void onResume()
    {
        super.onResume();
        mPresenter.getActorsList();
    }

    @Override
    public void loadActorList(ActorsDomainModel actorList) {
        hideLoading();
        mAdapter.displayActors(actorList.getmActor());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void openActorDetails(ActorsDataObject mActor) {
        startActivity(new Intent(getContext(), ActorDetailsActivity.class)
                .putExtra(ActorsDataObject.class.getSimpleName(), mActor));
    }

    @Override
    public void displayErrorResponse(String errorMessage) {
        hideLoading();
        Toast.makeText(getContext(),errorMessage,Toast.LENGTH_SHORT).show();
        Log.e(TAG, errorMessage);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }


}
