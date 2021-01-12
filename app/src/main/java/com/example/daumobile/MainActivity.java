package com.example.daumobile;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView mBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        config();
    }

    private void config() {
        configBottomNavigation();
    }

    private void configBottomNavigation() {
        mBottomNavigation.setOnNavigationItemSelectedListener(this);
//        mBottomNavigation.setSelectedItemId(R.id.nav_chart);
        mBottomNavigation.setSelectedItemId(R.id.nav_point);
    }

    private void initialization() {
        mapp();
    }

    private void mapp() {
        mBottomNavigation = findViewById(R.id.navigation);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.nav_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.frm_container, new ScheduleFragment()).commit();
                return true;
            case R.id.nav_chart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frm_container, new ChartFragment()).commit();
                return true;
            case R.id.nav_point:
                getSupportFragmentManager().beginTransaction().replace(R.id.frm_container, new PointFragment()).commit();
                return true;
            case R.id.nav_program:
                getSupportFragmentManager().beginTransaction().replace(R.id.frm_container, new ProgramFragment()).commit();
                return true;
            case R.id.nav_user:
                getSupportFragmentManager().beginTransaction().replace(R.id.frm_container, new UserFragment()).commit();
                return true;
        }
        return false;
    }
}
