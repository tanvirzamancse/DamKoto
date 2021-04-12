package com.damkoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Toolbar toolbar=findViewById(R.id.toolberID);
        drawerLayout=findViewById(R.id.drawerId);
        navigationView=findViewById(R.id.navigationViewID);
        navigationView.setNavigationItemSelectedListener(this);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.Home:
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
//                Intent intent=new Intent(getApplicationContext(),HomePage.class);
//                startActivity(intent);
                break;
            case R.id.About:
                Toast.makeText(this, "ClassUp helps students(university, college, school)" +
                        " manage classes, organize notes, track tasks, and communicate with classmates." +
                        " - Easily manage classes(courses, lesson, lectures) by searching for and" +
                        " adding classes entered by other users.", Toast.LENGTH_LONG).show();
                break;
            case R.id.Contact:
                Toast.makeText(this, "Name: Md.Musaddikul islam Mishon\n"+
                        "Id: 171-15-9127\n" +
                        "Email: musaddikul15-9127@diu.edu.bd\n" +
                        "Phone: 01842020064\n" +
                        "Name: Md.Juavaraj Nilay\n" +
                        "Id: 171-15-8967\n" +
                        "Email: juvaraj15-8967@diu.edu.bd\n" +
                        "Name: Manira Afruz\n" +
                        "Id: 171-15-9161\n" +
                        "Email: manira15-9161@diu.edu.bd\n", Toast.LENGTH_LONG).show();
                break;
            case R.id.Share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps");
                startActivity(Intent.createChooser(shareIntent, "Share..."));
                break;
            case R.id.Rating:
                Uri uri=Uri.parse("https://play.google.com/store/apps");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
                break;
        }
        return true;

    }
}