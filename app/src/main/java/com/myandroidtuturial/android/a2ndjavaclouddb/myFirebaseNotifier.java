package com.myandroidtuturial.android.a2ndjavaclouddb;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Jossy on 16/05/2018.
 */

public class myFirebaseNotifier extends FirebaseInstanceIdService {
    private static final String Tag = "myFirebaseIDService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String  refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(Tag, "New Token: "+ refreshedToken);
    }


}
