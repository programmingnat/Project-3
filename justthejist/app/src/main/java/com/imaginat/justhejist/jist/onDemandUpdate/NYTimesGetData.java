package com.imaginat.justhejist.jist.onDemandUpdate;

import android.os.AsyncTask;

import com.imaginat.justhejist.jist.api.nyt.JSONParser;
import com.imaginat.justhejist.jist.api.nyt.NYTApi;
import com.imaginat.justhejist.jist.api.nyt.NYTService;
import com.imaginat.justhejist.jist.api.nyt.Section;
import com.imaginat.justhejist.jist.models.NewsStory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by nat on 3/9/16.
 */
public class NYTimesGetData extends AsyncTask<String, Void, List<NewsStory>> {
  public interface NYTimesDataReceivedInterface{
    public void onCompleted(List<NewsStory>newStories);
  }
  String data = null;
  //Activity mActivity;
  NYTimesDataReceivedInterface mNYTimesDataReceivedInterface=null;
  public NYTimesGetData(NYTimesDataReceivedInterface a) { mNYTimesDataReceivedInterface = a; }

  @Override
  protected List<NewsStory> doInBackground(String... params) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(NYTApi.BASE_URL).build();
    NYTService service = retrofit.create(NYTService.class);
    List<NewsStory> stories = null;
    // NOTE(boloutaredoubeni): trying out one call now ...
    try {
      Call<ResponseBody> call = service.getTopStories(Section.TECHNOLOGY);
      ResponseBody body = call.execute().body();
      String json = body.string();
      stories = JSONParser.getStoriesFrom(json);
      // TODO(boloutaredoubeni): pass into adapter
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return stories;
  }

  @Override
  protected void onPostExecute(List<NewsStory> data) {
    super.onPostExecute(data);
    if (data == null) {

    }
    mNYTimesDataReceivedInterface.onCompleted(data);
    // mArrayAdapter.notifyDataSetChanged();
  }

  private String getInputData(InputStream inStream) throws IOException {
    StringBuilder builder = new StringBuilder();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
    String data;
    while ((data = reader.readLine()) != null) {
      builder.append(data);
    }
    reader.close();
    return builder.toString();
  }
}
