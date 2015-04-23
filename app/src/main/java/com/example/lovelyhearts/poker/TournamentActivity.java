package com.example.lovelyhearts.poker;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;


public class TournamentActivity extends ActionBarActivity implements TabListener{
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    ActionBar actionBar;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
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
                if(state == ViewPager.SCROLL_STATE_IDLE){

                }
                if(state == ViewPager.SCROLL_STATE_DRAGGING){

                }
                if(state == ViewPager.SCROLL_STATE_SETTLING){

                }
            }
        });


        Tab timeTab= actionBar.newTab();
        timeTab.setTabListener(this);
        timeTab.setText("Time/Date");

        Tab locationTab= actionBar.newTab();
        locationTab.setTabListener(this);
        locationTab.setText("Location");

        actionBar.addTab(timeTab);
        actionBar.addTab(locationTab);

        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tournament, menu);
        return true;
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {

    }


    public static class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            Fragment fragment=null;
            if(i==0) {
                fragment = new TimeFragment();
            }
            else if(i==1){
                fragment = new LocationFragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}

