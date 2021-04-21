package com.damkoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class AdminPanel extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    AdminViewPager adminViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view);

        adminViewPager = new AdminViewPager(getSupportFragmentManager());
        viewPager.setAdapter(adminViewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
}