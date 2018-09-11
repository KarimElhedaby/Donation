package donation.solutions.hamza.com.donation.service.firebase;


import com.google.firebase.messaging.FirebaseMessagingService;

import donation.solutions.hamza.com.donation.utils.MyApplication;


public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseIIDService";


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        MyApplication.getPrefManager(getApplicationContext()).storeNotificationToken(s);

    }


}