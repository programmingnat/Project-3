package com.imaginat.justhejist.jist.onDemandUpdate;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.imaginat.justhejist.jist.api.nyt.NYTApi;
import com.imaginat.justhejist.jist.api.nyt.NYTService;
import com.imaginat.justhejist.jist.api.nyt.Section;
import com.imaginat.justhejist.jist.api.nyt.gson.Result;
import com.imaginat.justhejist.jist.api.nyt.gson.TopStoriesResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nat on 3/9/16.
 */
public class NYTimesGetData extends AsyncTask<String, Void, Void> {
    String data = null;
    Activity mActivity;

    public NYTimesGetData(Activity a){
        mActivity=a;
    }

    @Override
    protected Void doInBackground(String... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NYTApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NYTService service = retrofit.create(NYTService.class);
        // NOTE(boloutaredoubeni): trying out one call now ...
        try {
            Call<TopStoriesResponse> call = service.listResults(Section.TECHNOLOGY);
            TopStoriesResponse topStoriesResponse = call.execute().body();
            List<Result> results = topStoriesResponse.getResults();
            for (Result result : results) {
                if (result.getSection().equals(Section.TECHNOLOGY)) {
                    throw new Exception("Wrong section");
                }
                Log.v("Title", result.getTitle());
                Log.v("URL", result.getUrl());
//                List<Multimedia> media = Arrays.asList(result.getMultimedia());
//                Log.v("Media", "It is " + media.size());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void data) {
        super.onPostExecute(data);
        if (data == null) {
            Toast.makeText(mActivity, "ERROR: no connectino found ", Toast.LENGTH_SHORT).show();
        }
        //mArrayAdapter.notifyDataSetChanged();
    }

    private String getInputData(InputStream inStream) throws IOException{
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        String data;
        while((data=reader.readLine())!=null){
            builder.append(data);
        }
        reader.close();
        return builder.toString();
    }
}
