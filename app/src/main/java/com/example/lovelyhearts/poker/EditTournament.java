package com.example.lovelyhearts.poker;

import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class EditTournament extends ActionBarActivity {

    String tournamentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tournament);

        tournamentLocation = getIntent().getExtras().getString("_locationName");
        TournamentManager um = new TournamentManager();
        Tournament mTournament = um.GetTournament(tournamentLocation);

        ((EditText) findViewById(R.id.et_tournament_locationNameText)).setText(mTournament.getLocation());
        ((EditText) findViewById(R.id.et_locationDate)).setText(mTournament.getDate());
        ((EditText) findViewById(R.id.et_Time)).setText(mTournament.getTime());
        ((EditText) findViewById(R.id.et_MaxPlayer)).setText(String.valueOf(mTournament.getMaxPlayers()));
        ((EditText) findViewById(R.id.et_BuyIn)).setText(String.valueOf(mTournament.getBuyIn()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_tournament, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
