package com.imaginat.justhejist.jist.onDemandUpdate;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.imaginat.justhejist.jist.api.nyt.NYTApi;
import com.imaginat.justhejist.jist.models.NewsStory;

import java.util.List;

/**
 * Created by nat on 3/9/16.
 */
public class NYTimesGetData extends AsyncTask<String, Void, List<NewsStory>> {

  public interface NYTimesDataReceivedInterface{
    void onCompleted(List<NewsStory>newStories);
    // `getContext' is a pretty common method
    Context resolveContext();
  }

  NYTimesDataReceivedInterface mNYTimesDataReceivedInterface=null;
  public NYTimesGetData(NYTimesDataReceivedInterface a) { mNYTimesDataReceivedInterface = a; }


  @Override
  protected List<NewsStory> doInBackground(String... params) {
    String section = params[0];


    try {
      return NYTApi.getStories(section);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  @Override
  protected void onPostExecute(List<NewsStory> stories) {
    super.onPostExecute(stories);
    if (stories == null) {
      Toast.makeText(mNYTimesDataReceivedInterface.resolveContext(), "ERROR: no connection found ",
          Toast.LENGTH_SHORT)
          .show();
    }
    mNYTimesDataReceivedInterface.onCompleted(stories);
    // mArrayAdapter.notifyDataSetChanged();
  }

}
