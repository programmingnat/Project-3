package com.imaginat.justhejist.jist.Activities;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.imaginat.justhejist.jist.R;
import com.imaginat.justhejist.jist.api.nyt.WebScraper;

import java.io.IOException;

public class StoryActivity extends AppCompatActivity {

  private String mUrl;
  private TextView mTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_story);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

//    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//    fab.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show();
//      }
//    });
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    mUrl = getIntent().getExtras().getString("URL");

    mTextView = (TextView)findViewById(R.id.story_txt);
    // TODO(boloutaredoubeni): pull in the story object and use the members
    //facebook stuff-------
            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("http://www.starwars.com/"))
                    .build();

            final ShareButton postLinkButton =
            (ShareButton)findViewById(R.id.fb_share_button);
            postLinkButton.setShareContent(content);
  }

  @Override
  protected void onResume() {
    super.onResume();
    new HTMLParserTask().execute(mUrl);
  }

  private class HTMLParserTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
      String url = params[0];
      try {
        return WebScraper.parseHTML(url);
      } catch (IOException e) {
        return e.getMessage();
      }
    }

    @Override
    protected void onPostExecute(String s) {
      super.onPostExecute(s);
      mTextView.setText(s);
    }
  }
}
