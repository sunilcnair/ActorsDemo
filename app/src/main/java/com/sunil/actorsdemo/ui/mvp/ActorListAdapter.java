package com.sunil.actorsdemo.ui.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.actorsdemo.R;
import com.sunil.actorsdemo.business.model.ActorsDataObject;

import java.util.List;

/**
 * Created by sunil on 01-01-2018.
 */

public class ActorListAdapter extends RecyclerView.Adapter<ActorItem>{

    private List<ActorsDataObject> mActorList;
    private ActorListContract.Presenter mPresenter;
    private Context mContext;


    public ActorListAdapter(ActorListContract.Presenter actorPresenter, Context cnt )
    {
        this.mPresenter = actorPresenter;
        this.mContext = cnt;
    }

    @Override
    public ActorItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_layout, parent, false);
        return new ActorItem(view, mContext);
    }

    @Override
    public void onBindViewHolder(ActorItem holder, int position) {
        ActorsDataObject mActor = mActorList.get(holder.getAdapterPosition());
        holder.bind(mActor);
        holder.itemView.setOnClickListener(v -> mPresenter.onActorClicked(mActor));
    }

    @Override
    public int getItemCount() {
        if (mActorList != null && !mActorList.isEmpty()) {
            return mActorList.size();
        } else {
            return 0;
        }
    }

    /**
     * Load actors in recycler adapter
     * @param mActorList list
     */
    public void displayActors(List<ActorsDataObject> mActorList) {
        this.mActorList = mActorList;
    }
}
