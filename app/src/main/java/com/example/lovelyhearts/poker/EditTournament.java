package com.example.lovelyhearts.poker;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class EditTournament extends ActionBarActivity {

    String tournamentLocation;
    Boolean bAddNew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tournament);

        bAddNew  = getIntent().getExtras().getBoolean("_addNew");

        if(bAddNew) {
            //this.getActionBar().setTitle(getString(R.string.title_AddTournament));
        }
        else {
            tournamentLocation = getIntent().getExtras().getString("_locationName");
            TournamentManager um = new TournamentManager();
            Tournament mTournament = um.GetTournament(tournamentLocation);

            ((EditText) findViewById(R.id.et_tournament_locationNameText)).setText(mTournament.getLocation());
            ((EditText) findViewById(R.id.et_locationDate)).setText(mTournament.getDate());
            ((EditText) findViewById(R.id.et_Time)).setText(mTournament.getTime());
            ((EditText) findViewById(R.id.et_MaxPlayer)).setText(String.valueOf(mTournament.getMaxPlayers()));
            ((EditText) findViewById(R.id.et_BuyIn)).setText(String.valueOf(mTournament.getBuyIn()));
        }
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
        if (id == R.id.action_save) {
            SaveChanges();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void SaveChanges()
    {
        Tournament tournament = new Tournament();
        tournament.setLocation(((TextView) findViewById(R.id.et_tournament_locationNameText)).getText().toString());
        tournament.setDate(((TextView) findViewById(R.id.et_locationDate)).getText().toString());
        tournament.setTime(((TextView) findViewById(R.id.et_Time)).getText().toString());
        tournament.setMaxPlayers(Integer.parseInt(((TextView) findViewById(R.id.et_MaxPlayer)).getText().toString()));
        tournament.setBuyIn(Integer.parseInt(((TextView) findViewById(R.id.et_BuyIn)).getText().toString()));

        tournament.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Show a simple Toast message upon successful registration
                    ShowToast("Tournament Saved");
                } else {
                    ShowToast("Tournament add Error:" + e.toString());
                }
            }
        });

    }

    void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
