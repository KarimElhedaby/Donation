package donation.solutions.hamza.com.donation.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import donation.solutions.hamza.com.donation.ui.LoginActivity;

/**
 * Created by karim on 4/15/18.
 */

public class MyApplication extends Application {

    private static MyPreferenceManager pref;
    Context context ;
    @Override
    public void onCreate() {
        super.onCreate();

        getPrefManager (getApplicationContext());
        logout();
    }

    public static MyPreferenceManager getPrefManager(Context context) {
        if (pref == null) {
            pref = new MyPreferenceManager(context);
        }
        return pref;
    }

    public void logout() {
        pref.clear();
//        Intent intent = new Intent(context, LoginActivity.class);
////        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
    }

}
