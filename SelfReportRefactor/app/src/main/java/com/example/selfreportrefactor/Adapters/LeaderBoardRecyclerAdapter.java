package com.example.selfreportrefactor.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.selfreportrefactor.Classes.Problem;
import com.example.selfreportrefactor.R;

import java.util.ArrayList;

/**
 * Created by User_1_Benjamin_Rosenthal on 3/29/16.
 */
public class LeaderBoardRecyclerAdapter extends RecyclerView.Adapter<LeaderBoardRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    //private ArrayList<ViewModel> items;
    private ArrayList<Problem> items = new ArrayList<>();
//    public String[] items = {"Item1", "Item2", "Item3", "Item4", "Item5", "Item6",
//            "Item7", "Item8", "Item9", "Item10"};
//    public String [] itemDetails = {"Item1Details", "Item2Details", "Item3Details",
//            "Item4Details", "Item5Details", "Item6Details", "Item7Details", "Item8Details", "Item9Details", "Item10Details"};
//    public String [] itemLocations = {"Item1Loc", "Item2Loc", "Item3Loc", "Item4Loc", "Item5Loc", "Item6Loc",
//            "Item7Loc", "Item8Loc", "Item9Loc", "Item10Loc"};
//    public int[] itemPics = {android.R.drawable.arrow_up_float, android.R.drawable.btn_plus, android.R.drawable.star_big_on,
//            android.R.drawable.arrow_up_float, android.R.drawable.btn_plus, android.R.drawable.star_big_on,
//            android.R.drawable.arrow_up_float, android.R.drawable.btn_plus, android.R.drawable.star_big_on, android.R.drawable.alert_light_frame};


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView mProblemImage;
        public TextView mProblemTextView;
        public TextView mLocationTextView;
        public TextView mProblemTimeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mProblemImage = (ImageView)itemView.findViewById(R.id.problem_image_view);
            mProblemTextView = (TextView) itemView.findViewById(R.id.prob_desc_text_view);
            mLocationTextView = (TextView) itemView.findViewById(R.id.development_text_view);
            mProblemTimeTextView = (TextView) itemView.findViewById(R.id.time_elapsed_text_view);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
////                    Snackbar.make(v, "Click detected on item " + position,
////                            Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
//                }
//            });

        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_list_item, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        viewHolder.mProblemImage.setImageResource(items.get(position).getProblemPic());
        viewHolder.mProblemTextView.setText(items.get(position).getProblem());
        viewHolder.mLocationTextView.setText(items.get(position).getProblemDescription());
        viewHolder.mProblemTimeTextView.setText(items.get(position).getProblemLocation());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View v) {

    }

    public void addItem(Problem problem){
        items.add(problem);
    }



}

