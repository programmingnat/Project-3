package com.imaginat.justhejist.jist.webCommunication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by nat on 3/9/16.
 */
public class NYTimesSyncService extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static NYTimesBreakingNewsAdapter sSyncAdapter = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null)
                sSyncAdapter = new NYTimesBreakingNewsAdapter(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}