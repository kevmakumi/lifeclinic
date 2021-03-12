package com.example.splashapplication;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.splashapplication.ui.main.SectionsPagerAdapter;

public class Description_BookActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description__book);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        appBarLayout=(AppBarLayout)findViewById(R.id.appbar);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        //adding fragments
        adapter.AddFragment(new FragmentBook(),"Book");
        adapter.AddFragment(new FragmentDescription(),"Description");
        //adapter Setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}