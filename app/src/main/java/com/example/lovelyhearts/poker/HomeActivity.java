package com.example.lovelyhearts.poker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class HomeActivity extends ActionBarActivity {
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Retrieve current user from cache (done automatically by Parse when
        // any login or signup activity
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        name = currentUser.getUsername();
        //name = MainActivity.username.getText().toString();

        Button buttonAccount = (Button) findViewById(R.id.btn_account);
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, DetailaccountActivity.class);
                intent.putExtra("_userName",name);

                startActivity(intent);
            }
        });


        Button buttonTournament = (Button) findViewById(R.id.btn_tournament);
        buttonTournament.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TournamentActivity.class);
                startActivity(intent);
            }

        });





        Button buttonRankings = (Button) findViewById(R.id.btn_rankings);
        buttonRankings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RankingsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
