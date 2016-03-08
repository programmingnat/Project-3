package com.imaginat.justhejist.jist.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

/**
 * Copyright 2016 Boloutare Doubeni
 */
public class TopStoriesSyncAdapter extends AbstractThreadedSyncAdapter {

  private static final String AUTHORITY = "com.imaginat.justthejist.jist"; // TODO(boloutaredoubeni): this may be wrong
  private static final String PREFIX = "content://" + AUTHORITY + '/';

  public TopStoriesSyncAdapter(Context context, boolean autoInitialize) {
    super(context, autoInitialize);
  }

  @Override
  public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
    SyncResult result = new SyncResult();
    try {
      // TODO(boloutaredoubeni): do the sync
      // pass the bundle data and get it
      // delete the old data
      // insert the new stuff
    } catch (Throwable e) {
      e.printStackTrace();
      result.hasHardError();
    }
  }

  private void insertTopStories(ContentProviderClient client) {

  }

  private void deleteOldStories(ContentProviderClient client) {
  }

}
