package com.imaginat.justhejist.jist.customLayouts;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imaginat.justhejist.jist.R;

/**
 * Created by nat on 3/6/16.
 */
public class NewsArticleListAdapter extends RecyclerView.Adapter<NewsArticleListAdapter.ViewHolder> {
    private String[] mDataset;

//    Picasso.with(MainActivity.this).load(fullResource).error(R.drawable.android_placeholder)
//    .placeholder(R.drawable.android_placeholder)
//    .into(thumbnail);

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.news_article_item_text);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsArticleListAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NewsArticleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        Log.d("NewsArticleListAdapter","inside news article list adapter viewholder");
        // create a new view
       View v = LayoutInflater.from(parent.getContext())
         .inflate(R.layout.my_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}