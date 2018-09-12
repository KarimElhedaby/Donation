package donation.solutions.hamza.com.donation.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

import java.util.ArrayList;

import donation.solutions.hamza.com.donation.R;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {


    private ArrayList<Fragment> mainPageFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainPageFragments.add(DonateProjectFragment.newInstance());
        mainPageFragments.add(HistoryFragment.newInstance());
        mainPageFragments.add(NotificationFragment.newInstance());
        mainPageFragments.add(ProfileFragment.newInstance());


        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);

        AHBottomNavigationAdapter ahBottomNavigationAdapter = new AHBottomNavigationAdapter(this, R.menu.navigation);
        bottomNavigation.setBehaviorTranslationEnabled(false);
        ahBottomNavigationAdapter.setupWithBottomNavigation(bottomNavigation);
        bottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent));
        bottomNavigation.setOnTabSelectedListener(this);
//
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cointaner, DonateProjectFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (position == mainPageFragments.size() - 1) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cointaner, ProfileFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        } else if (position == 0) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cointaner, DonateProjectFragment.newInstance())
                    .addToBackStack(null)
                    .commit();

        } else if (position == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cointaner, HistoryFragment.newInstance())
                    .addToBackStack(null)
                    .commit();

        } else if (position == 2) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cointaner, NotificationFragment.newInstance())
                    .addToBackStack(null)
                    .commit();

        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.cointaner, mainPageFragments.get(position))
                    .addToBackStack(null)
                    .commit();
        }
        return true;

    }

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.cointaner, DonateProjectFragment.newInstance())
//                            .addToBackStack(null)
//                            .commit();
//
//                    return true;
//
//                case R.id.navigation_History:
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.cointaner, HistoryFragment.newInstance())
//                            .addToBackStack(null)
//                            .commit();
//                    return true;
//
//                case R.id.navigation_notifications:
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.cointaner, NotificationFragment.newInstance())
//                            .addToBackStack(null)
//                            .commit();
//                    return true;
//            }
//            return false;
//        }
//    };


}
