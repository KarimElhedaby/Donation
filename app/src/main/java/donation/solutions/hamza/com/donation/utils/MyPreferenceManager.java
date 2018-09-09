package donation.solutions.hamza.com.donation.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import donation.solutions.hamza.com.donation.model.User;
import donation.solutions.hamza.com.donation.model.UserResponce;

/**
 * Created by karim on 4/15/18.
 */

public class MyPreferenceManager {

    private String TAG = MyPreferenceManager.class.getSimpleName();
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Sharedpref file name
    private static final String PREF_NAME = "Donation_Pref";

    // All Shared Preferences Keys
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_TOKEN = "user_token";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_PHONE = "user_phone";
    private static final String KEY_USER_GENDER = "user_gender";


    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, 0);
        editor = pref.edit();
    }


    public void storeUser(UserResponce user) {
        editor.putString(KEY_USER_TOKEN, user.getToken());
        editor.putString(KEY_USER_ID, user.getUser().getUser_id());
        editor.putString(KEY_USER_NAME, user.getUser().getName());
        editor.putString(KEY_USER_EMAIL, user.getUser().getEmail());
        editor.putString(KEY_USER_PHONE, user.getUser().getPhone());
        editor.putString(KEY_USER_GENDER, user.getUser().getGender());
        editor.commit();

        Log.e(TAG, "User is stored in shared preferences. " + user.getUser().getName() + ", " + user.getUser().getEmail());
    }



    public UserResponce getUser() {
        if (pref.getString(KEY_USER_EMAIL, null) != null) {
            String token , id ,name, email, gender ,phone;
            token = pref.getString(KEY_USER_TOKEN, null);
            id = pref.getString(KEY_USER_ID, null);
            name = pref.getString(KEY_USER_NAME, null);
            email = pref.getString(KEY_USER_EMAIL, null);
             phone= pref.getString(KEY_USER_PHONE, null);
            gender = pref.getString(KEY_USER_GENDER, null);

            User user = new User(id,  name,email,phone);
            UserResponce userResponce=new UserResponce(user, token) ;
            return userResponce;
        }
        return null;
    }


    public void clear() {
        editor.clear();
        editor.commit();
    }

}