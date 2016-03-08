package com.imaginat.justhejist.jist.customLayouts.webCommunication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by nat on 3/8/16.
 */
public class JistSyncAdapter extends Service {

    private static final Object sSyncAdapterLock = new Object();
    private static SyncAdapter sSyncAdapter = null;

    @Override
    public void onCreate() {
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null)
                sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }

}
