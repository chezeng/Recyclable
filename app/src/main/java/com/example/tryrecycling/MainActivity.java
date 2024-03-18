package com.example.tryrecycling;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_location:
                selectedFragment = new LocationFragment();
                break;
            case R.id.navigation_recycling:
                selectedFragment = new RecyclingFragment();
                break;
            case R.id.navigation_survey:
                // replace with your survey fragment
                selectedFragment = new SurveyFragment();
                break;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
        }

        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Place To Recycle");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Show the first fragment initially
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new LocationFragment())
                .commit();
    }
}