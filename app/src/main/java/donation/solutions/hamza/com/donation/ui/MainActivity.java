package donation.solutions.hamza.com.donation.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.ui.DonateProjectFragment;
import donation.solutions.hamza.com.donation.ui.HistoryFragment;
import donation.solutions.hamza.com.donation.ui.NotificationFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cointaner, DonateProjectFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.cointaner, DonateProjectFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

                    return true;

                case R.id.navigation_History:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.cointaner, HistoryFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                    return true;

                case R.id.navigation_notifications:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.cointaner, NotificationFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                    return true;
            }
            return false;
        }
    };

}
