package com.nychareport.backlog.adapter;

import android.support.v7.widget.RecyclerView;

import com.nychareport.backlog.R;
import com.nychareport.backlog.models.Problem;
import com.nychareport.backlog.viewholder.PostProblemViewHolder;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Ben Rosenthal on 5/06/16.
 */
public class ProblemPostAdapter extends RecyclerView.Adapter<PostProblemViewHolder> {

    private List<Problem> mDataSet;
    /**
     * Called when a view has been clicked.
     *
     * @param problemSet Dataset of posts made by users
     */
    public ProblemPostAdapter(List<Problem> problemSet) {
        mDataSet = problemSet;
    }

    @Override
    public PostProblemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostProblemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.problem_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostProblemViewHolder holder, int position) {
        Problem problem = mDataSet.get(position);
        holder.problemTitle.setText(problem.getProblem());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
