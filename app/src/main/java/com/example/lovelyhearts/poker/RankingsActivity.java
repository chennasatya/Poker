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

public class RankingsActivity extends ActionBarActivity implements ActionBar.TabListener {
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    ActionBar actionBar;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.rankingspager);
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


        ActionBar.Tab playersTab= actionBar.newTab();
        playersTab.setTabListener(this);
        playersTab.setText("Players");

        ActionBar.Tab rankingsTab= actionBar.newTab();
        rankingsTab.setTabListener(this);
        rankingsTab.setText("Rankings");

        actionBar.addTab(playersTab);
        actionBar.addTab(rankingsTab);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_rankings, menu);
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

            Fragment fragment=null;
            if(i==0) {
                return new PlayersFragment();
            }
            if(i==1){
                return new RankingsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}

