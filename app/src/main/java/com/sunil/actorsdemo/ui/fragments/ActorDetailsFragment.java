package com.sunil.actorsdemo.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunil.actorsdemo.R;
import com.sunil.actorsdemo.business.model.ActorsDataObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ActorDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ActorDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActorDetailsFragment extends Fragment {

    @BindView(R.id.actor_image)
    ImageView mActorImageView;
    @BindView(R.id.actor_description)
    TextView mDescription;
    @BindView(R.id.actor_dob)
    TextView mDob;
    @BindView(R.id.actor_country)
    TextView mCountry;
    @BindView(R.id.actor_height)
    TextView mHeight;
    @BindView(R.id.actor_spouse)
    TextView mSpouse;
    @BindView(R.id.actor_children)
    TextView mChildren;


    private ActorsDataObject mActor;

    public static ActorDetailsFragment newInstance() {
        return new ActorDetailsFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View mRoot = inflater.inflate(R.layout.fragment_actor_details, container, false);
        ButterKnife.bind(this, mRoot);
        mActor = (ActorsDataObject) getActivity().getIntent().getSerializableExtra(ActorsDataObject.class.getSimpleName());
        return mRoot;
    }
    /**
     * Lifecycle method
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Picasso.with(getContext()).load(mActor.getmImage()).into(mActorImageView);
        mDescription.setText(mActor.getmDescription());
        mDob.setText(String.format(getString(R.string.actor_dob), mActor.getmDob()));
        mCountry.setText(String.format(getString(R.string.actor_country), mActor.getmCountry()));
        mHeight.setText(String.format(getString(R.string.actor_height), mActor.getmHeight()));
        mSpouse.setText(String.format(getString(R.string.actor_spouse), mActor.getmSpouse()));
        mChildren.setText(String.format(getString(R.string.actor_children), mActor.getmChildren()));
    }

}
