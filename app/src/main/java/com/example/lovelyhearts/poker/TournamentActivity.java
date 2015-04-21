package com.example.lovelyhearts.poker;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class TournamentActivity extends TabActivity {
    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tournament_tab);
        mTabHost=getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        intent= new Intent(this,TabTournamentTime.class);
        spec= mTabHost.newTabSpec("Date").setIndicator("Date").setContent(intent);
        mTabHost.addTab(spec);

        intent= new Intent(this,TabTournamentLocation.class);
        spec= mTabHost.newTabSpec("Location").setIndicator("Location").setContent(intent);
        mTabHost.addTab(spec);

        mTabHost.setCurrentTab(0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tournament, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

}
