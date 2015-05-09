package com.example.lovelyhearts.poker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class PlayActivity extends ActionBarActivity {
     String currentUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final String tournamentID = getIntent().getExtras().getString("_tournamentID");
        ParseUser user = ParseUser.getCurrentUser();
        currentUserName = user.getUsername();
        currentUserName = "u";

        final TournamentTable table = new TournamentTable();
        final Button buttonJoin = (Button) findViewById(R.id.btn_joingame);
        final Button buttonOut = (Button) findViewById(R.id.btn_out);

        buttonJoin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                table.SetTournamentId("122");
                table.SetUserName(currentUserName);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //get current date time with Date()
                Date date = new Date();

                //get current date time with Calendar()
                Calendar cal = Calendar.getInstance();

                table.SetJoined(dateFormat.format(cal.getTime()));
                buttonJoin.setEnabled(false);
                buttonOut.setEnabled(true);
                table.saveInBackground(new SaveCallback() {
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

        });


        buttonOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                table.SetTournamentId("122");
                table.SetUserName(currentUserName);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //get current date time with Date()
                Date date = new Date();


                //get current date time with Calendar()
                Calendar cal = Calendar.getInstance();

                table.SetOut(dateFormat.format(cal.getTime()));
                buttonJoin.setEnabled(true);
                buttonOut.setEnabled(false);
                table.saveInBackground(new SaveCallback() {
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

        });

        Button buttonTables = (Button) findViewById(R.id.btn_tables);
        buttonTables.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, TableActivity.class);
                startActivity(intent);
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
