package com.example.lovelyhearts.poker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TableActivity extends ActionBarActivity implements ActionBar.TabListener {
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    ActionBar actionBar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.tablepager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                }
                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                }
                if (state == ViewPager.SCROLL_STATE_SETTLING) {
                }
            }
        });


        ActionBar.Tab roundTab1 = actionBar.newTab();
        roundTab1.setTabListener(this);
        roundTab1.setText("Round 1");

        ActionBar.Tab roundTab2 = actionBar.newTab();
        roundTab2.setTabListener(this);
        roundTab2.setText("Round 2");

        ActionBar.Tab roundTab3 = actionBar.newTab();
        roundTab3.setTabListener(this);
        roundTab3.setText("Round 3");

        actionBar.addTab(roundTab1);
        actionBar.addTab(roundTab2);
        actionBar.addTab(roundTab3);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_table, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    public static class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                 return new Round1Fragment();
            }
            if (i == 1) {
                 return new Round2Fragment();
            }
            if (i == 2) {
                 return new Round3Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}