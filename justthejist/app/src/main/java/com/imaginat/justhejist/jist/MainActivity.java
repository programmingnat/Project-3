package com.imaginat.justhejist.jist;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.imaginat.justhejist.jist.customLayouts.NewsArticleListAdapter;

import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //hash: Ra/aSVj6IEwD+XYG+5pLHo0J9tQ=
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    ContentResolver mResolver;

    public static final String AUTHORITY = "com.imaginat.justhejist.jist.webCommunication.StubProvider";
    public static final String ACCOUNT_TYPE = "example.com";
    public static final String ACCOUNT = "default_account";

    Account mAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mAccount = createSyncAccount(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
       mLayoutManager = new LinearLayoutManager(this);
       mRecyclerView.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
        String[] myDataset = new String[]{"test1","test2","test3","test4","test5"};
        mAdapter = new NewsArticleListAdapter(myDataset,this);
        mRecyclerView.setAdapter(mAdapter);
        //------------------------------------------------------------------

        //------------------------------------------------------------------------------
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Sync it up!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Bundle settingsBundle = new Bundle();
                settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL,true);
                settingsBundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED,true);

                //request to sync, puts in queue. when it gets to ours it calls onPerformSync from syncAdapter Class
                ContentResolver.requestSync(mAccount,AUTHORITY,settingsBundle);
            }
        });


        //------------------------FACEBOOK BUTTONS---------------------------------------------
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends","user_posts"));


         accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
            }
        };
        // If the access token is available already assign it.

        Button attemptNewsFeedPull = (Button)findViewById(R.id.attemptNewsFeedPull);
        attemptNewsFeedPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AccessToken token = AccessToken.getCurrentAccessToken();


                AccessToken accessToken = AccessToken.getCurrentAccessToken();
                Bundle params = new Bundle();
                params.putString("fields", "id,name,link");

               GraphRequest request= new GraphRequest(
                        accessToken,
                        "/5281959998/feed",
                        params,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                JSONObject nyTimesObject = response.getJSONObject();
                                Log.d("MainActivity","nyTimesObject "+nyTimesObject.toString());

                            }
                        }
                );
                request.executeAsync();


            }
        });
//        ShareLinkContent content = new ShareLinkContent.Builder()
//                .setContentUrl(Uri.parse("http://www.starwars.com/"))
//                .build();
//
//        final ShareButton postLinkButton = (ShareButton)findViewById(R.id.fb_share_button);
//        postLinkButton.setShareContent(content);
//
//
//        LikeView likeView = (LikeView) findViewById(R.id.testFacebookLikeButton);
//        likeView.setObjectIdAndType(
//                "http://www.starwars.com/",
//                LikeView.ObjectType.PAGE);
        //----------------------------------------------------------------------------------------

    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.test_animate_scroll_vertical){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }

    public static Account createSyncAccount(Context context) {
        Account newAccount = new Account(ACCOUNT, ACCOUNT_TYPE);
        AccountManager manager = (AccountManager)context.getSystemService(ACCOUNT_SERVICE);
        if (manager.addAccountExplicitly(newAccount, null, null)) {

        } else {

        }
        return newAccount;
    }
}
