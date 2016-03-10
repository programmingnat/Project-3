package com.imaginat.justhejist.jist.customLayouts;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imaginat.justhejist.jist.R;
import com.imaginat.justhejist.jist.models.NewsStory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nat on 3/6/16.
 */
public class NewsArticleListAdapter
    extends RecyclerView.Adapter<NewsArticleListAdapter.ViewHolder> {
  private ArrayList<NewsStory> mNewsStories;
  private static Context mContext;

    public void swap(ArrayList<NewsStory> datas){
        if(mNewsStories!=null && datas!=null) {
            mNewsStories.clear();
            mNewsStories.addAll(datas);
            notifyDataSetChanged();
        }
    }
  //    Picasso.with(MainActivity.this).load(fullResource).error(R.drawable.android_placeholder)
  //    .placeholder(R.drawable.android_placeholder)
  //    .into(thumbnail);

  // Provide a reference to the views for each data item
  // Complex data items may need more than one view per item, and
  // you provide access to all the views for a data item in a view holder
  public static class ViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView mMainTextView=null;
      public ImageView mImageView=null;

    public ViewHolder(View v) {
      super(v);
      CardView cardView = (CardView)v.findViewById(R.id.card_view);
      LinearLayout rl = (LinearLayout)cardView.findViewById(R.id.relativeInsideward);
      mImageView =
          (ImageView)rl.findViewById(R.id.theMainImage);
                  Picasso
                          .with(mContext)
                          .load(R.drawable.ted_cruz2_nyt)
                          .fit()
                            //.centerInside()      // call .centerInside() or
                            .centerCrop() //to avoid a stretched image
                          .into(mImageView);
         mMainTextView =
                (TextView)rl.findViewById(R.id.theMainText);
        mMainTextView.setTextColor(Color.rgb(255, 255, 255));
        mMainTextView.setText("HELLO HELLO");
    }
  }

  // Provide a suitable constructor (depends on the kind of dataset)
  public NewsArticleListAdapter(ArrayList<NewsStory> myDataset, Context context) {
    mNewsStories = myDataset;
    mContext = context;
  }

  // Create new views (invoked by the layout manager)
  @Override
  public NewsArticleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
    Log.d("NewsArticleListAdapter",
          "inside news article list adapter viewholder");
    // create a new view
    View v = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.my_text_view, parent, false);
    // set the view's size, margins, paddings and layout parameters
//    CardView cardView = (CardView)v.findViewById(R.id.card_view);
//
//    ImageView imgMain =
//        (ImageView)cardView.findViewById(R.id.theMainImage);
//
//    imgMain.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Toast.makeText(mContext, "CLICKED NEWS ARTICLE ITEM",
//                       Toast.LENGTH_SHORT)
//            .show();
//      }
//    });

    ViewHolder vh = new ViewHolder(v);
    return vh;
  }

  // Replace the contents of a view (invoked by the layout manager)
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    // holder.mTextView.setText(mDataset[position]);
      NewsStory newsStory = mNewsStories.get(position);
      holder.mMainTextView.setText(newsStory.getSummary());
  }

  // Return the size of your dataset (invoked by the layout manager)
  @Override
  public int getItemCount() {
      if(mNewsStories ==null){
          return 0;
      }
    return mNewsStories.size();
  }


}