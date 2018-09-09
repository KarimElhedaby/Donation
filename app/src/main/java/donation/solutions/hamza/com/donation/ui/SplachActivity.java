package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.utils.MyApplication;


public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MyApplication.getPrefManager(getApplicationContext()).getUser() == null) {
                    Intent intent = new Intent(SplachActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(SplachActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                finish();
            }
        }, 2000);


    }
}
