package com.alan.converter.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.alan.converter.R;
import com.alan.converter.fragments.DigitalStorageFragment;
import com.alan.converter.fragments.FragmentAbout;
import com.alan.converter.fragments.LengthConverterFragment;
import com.alan.converter.fragments.SpeedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        LengthConverterFragment.OnFragmentInteractionListener,
        DigitalStorageFragment.OnFragmentInteractionListener,
        SpeedFragment.OnFragmentInteractionListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentAbout fragmentAbout;

    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about = findViewById(R.id.about);
        fragmentAbout = FragmentAbout.newInstance("Alan Rizky Wardana");
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragmentAbout)
                        .commit();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmentAbout)
                .commit();
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_length:
                fragment = new LengthConverterFragment();
                break;
            case R.id.action_digital_storage:
                fragment = new DigitalStorageFragment();
                break;
            case R.id.action_speed:
                fragment = new SpeedFragment();
                break;
        }
        return loadFragment(fragment);
    }

    public void githubLink(View view) {
        String url = "http://www.github.com/alanrizky";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void instagramLink(View view) {
        String url = "http://www.instagram.com/alan_rzky";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    public void facebookLink(View view) {
        String url = "http://www.facebook.com/MustBeProtected";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}

