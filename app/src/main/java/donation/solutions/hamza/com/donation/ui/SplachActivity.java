package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import donation.solutions.hamza.com.donation.R;


public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent intent = new Intent(SplachActivity.this, LoginActivity.class);
                    startActivity(intent);



                finish();
            }
        }, 1000);


    }
}
