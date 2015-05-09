package com.example.lovelyhearts.poker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class DetailplayerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailplayer);

        //created a temp player
        ParseObject player = new ParseObject("Player");
        player.put("location", "2508 delaware st");
        player.put("wins", 10);
        player.put("losses", 5);
        player.put("percentage", "10%");
        player.put("rank",1);

        //changed
        String playerId = getIntent().getExtras().getString("id");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Player");

        query.getInBackground(playerId, new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    String location= object.getString("location");
                    String wins= object.getString("wins");
                    String losses= object.getString("losses");
                    String percentage= object.getString("percentage");
                    String rank= object.getString("rank");
                    ((EditText) findViewById(R.id.detailplayer_username)).setText(location);
                    ((EditText) findViewById(R.id.detailplayer_wins)).setText(wins);
                    ((EditText) findViewById(R.id.detailplayer_losses)).setText(losses);
                    ((EditText) findViewById(R.id.detailplayer_percentage)).setText(percentage);
                    ((EditText) findViewById(R.id.detailplayer_rank)).setText(rank);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailplayer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=null;
        int id = item.getItemId();
        switch (id){
            case R.id.action_edit:
                intent = new Intent(this,EditplayerActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
