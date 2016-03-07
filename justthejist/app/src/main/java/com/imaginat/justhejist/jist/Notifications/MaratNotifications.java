package com.imaginat.justhejist.jist.Notifications;

import android.app.Activity;
import android.support.v4.app.NotificationCompat;

import java.net.URL;

/**
 * Created by generalassembly on 3/7/16.
 */
public class MaratNotifications {
    private Activity mActivity = null;
    private String nameOfArticle;
    private URL mUrl;

    public MaratNotifications(Activity a, String articleName, URL url){
        mActivity = a;
        nameOfArticle = articleName;
        mUrl = url;
    }
    public void createNotificationForNewArticle () {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mActivity);
        builder.setSmallIcon(android.R.drawable.ic_lock_idle_lock);
        builder.setContentTitle("New Article: " + nameOfArticle);
        builder.setContentText("Check Out This New Interesting Story");
    }
}
