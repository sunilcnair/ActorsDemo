package com.sunil.actorsdemo.ui.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sunil.actorsdemo.R;
import com.sunil.actorsdemo.business.model.ActorsDataObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 01-01-2018.
 */

public class ActorItem extends RecyclerView.ViewHolder {

    @BindView(R.id.actor_name)
    TextView mActorNameTextView;
    @BindView(R.id.actor_image)
    ImageView mActorImageView;
    @BindView(R.id.actor_dob)
    TextView mActorDobTextView;

    private Context mContext;

    public ActorItem(View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(ActorsDataObject mActor)
    {
        mActorNameTextView.setText(mActor.getmName());
        mActorDobTextView.setText(String.format(mContext.getString(R.string.actor_dob), mActor.getmDob()));
        Picasso.with(mContext).load(mActor.getmImage()).into(mActorImageView);
    }
}
