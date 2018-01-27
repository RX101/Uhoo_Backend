package com.example.angruixian.u_hoo_backend;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomBar = (BottomNavigationView) findViewById(R.id.navigation);
        bottomBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomBar);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    fragment = new FragmentHome();
//                    fm = getSupportFragmentManager();
//                    trans = fm.beginTransaction();
//                    trans.replace(R.id.mainFrameLayout, fragment);
//                    trans.commit();
//                    return true;

                case R.id.navigation_history:
//                    fragment = new FragmentHistory();
//                    fm = getSupportFragmentManager();
//                    trans = fm.beginTransaction();
//                    trans.replace(R.id.mainFrameLayout, fragment);
//                    trans.commit();

            }
            return false;
        }
    };
}
