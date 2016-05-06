package com.nychareport.backlog.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nychareport.backlog.R;

/**
 * Created by Ben Rosenthal on 06/05/16.
 */
public class PostProblemViewHolder extends RecyclerView.ViewHolder {

    public ImageView attachedProblemImage;
    public TextView problemTitle;
    public TextView problemDescription;
    public TextView problemLocation;
    public TextView timeCreated;

    public PostProblemViewHolder(View itemView) {
        super(itemView);
        initializeViews();
    }

    private void initializeViews() {
        problemTitle = (TextView) itemView.findViewById(R.id.problem_title);
    }
}
