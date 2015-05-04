package com.example.lovelyhearts.poker;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TournamentdetailActivity extends ActionBarActivity {
    List<Tournament> tournamentList ;
    private static List<Location> locations;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentdetail);

        tournamentList = new ArrayList<Tournament>();

        Tournament t = new Tournament();
        t.setLocation("Corner bar");
        t.setDate("5/10/2015");
        t.setTime("8 PM");
        t.setWeek("Friday");
        t.setBuyIn(10);
        t.setPosition(0);

        tournamentList.add(t);



        Tournament t2 = new Tournament();
        t2.setLocation("Corner bar");
        t2.setDate("4/13/2015");
        t2.setTime("9 PM");
        t2.setWeek("Monday");
        t2.setBuyIn(20);
        t2.setPosition(1);
        tournamentList.add(t2);


        String locationName = getIntent().getExtras().getString("_locationId");
        int position = getIntent().getExtras().getInt("_positionId");

        for(Tournament tor: tournamentList)
        {
            String loc = tor.getLocation().trim();

            if(tor.getLocation().equals(locationName) && tor.getPosition() == position) {

                ((EditText) findViewById(R.id.editLocation)).setText(tor.getLocation());
                ((EditText) findViewById(R.id.editTime)).setText(tor.getTime());
                ((EditText) findViewById(R.id.editDate)).setText(tor.getDate());
                ((EditText) findViewById(R.id.editBuyin)).setText(String.valueOf(tor.getBuyIn()));
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tournamentdetail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent=null;
        switch(id){
            //player
            case R.id.action_play:
                intent = new Intent(this,PlayActivity.class);
                startActivity(intent);
                return true;
            //admin
            case R.id.action_assigntable:
                intent = new Intent(this,TableActivity.class);
                startActivity(intent);
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
