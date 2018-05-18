package com.myandroidtuturial.android.a2ndjavaclouddb;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Jossy on 16/05/2018.
 */

public class FCMServices extends FirebaseMessagingService {
    private static final String TAG = "myFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "FRCM: " + remoteMessage.getFrom());

        if(remoteMessage.getData().size() > 0){
            Log.d(TAG, "Message data: "+ remoteMessage.getData());
        }
        //check if the message contains notification
        if(remoteMessage.getNotification()!= null){
            Log.d(TAG, "Message body: "+ remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());

        }
    }
    // to display the notification
    private void sendNotification(String body) {
        Intent intent = new Intent(this, BodyActivity.class);
      //  intent.putExtra("myBody", body);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).putExtra("myBody", body);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        //get sound for the notification
        Uri notifications = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifiBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase CLoud Messaging")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notifications)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notifiBuilder.build());

    }
}
