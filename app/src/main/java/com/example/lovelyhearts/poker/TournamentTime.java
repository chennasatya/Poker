package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TournamentTime extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournament_time);
        TextView text1 = (TextView) findViewById(R.id.list_content1);
        TextView text2 = (TextView) findViewById(R.id.list_content2);
        text1.setText("a");
        text2.setText("b");
    }
}
