package com.example.lovelyhearts.poker;

import android.content.Context;
import android.content.Intent;
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

import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;


public class TournamentActivity extends ActionBarActivity {

    private LayoutInflater inflater;
    private ParseQueryAdapter<Tournament> tournamentListAdapter;
    //private static final int LOGIN_ACTIVITY_CODE = 100;
    //private static final int EDIT_ACTIVITY_CODE = 200;

    private ListView tournamentListView;
    private LinearLayout noTournamentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        // set up the views
        tournamentListView = (ListView) findViewById(R.id.tournament_list_view);
        noTournamentView = (LinearLayout) findViewById(R.id.no_tournament_view);
        tournamentListView.setEmptyView(noTournamentView);

        // set up Parse query for adapter
        /*
        ParseQueryAdapter.QueryFactory<Tournament> factory = new ParseQueryAdapter.QueryFactory<Tournament>() {
            public ParseQuery<Tournament> create() {
                ParseQuery<Tournament> query = Tournament.getQuery();
                query.orderByAscending("date");
                //query.fromLocalDatastore();       //this should be included once DatabaseHelper func is implemented
                return query;
            }
        };
        */
        ParseQueryAdapter<Tournament> adapter = new ParseQueryAdapter<Tournament>(this, "Tournament");
        adapter.setTextKey("name");

        // set up adapter
        //inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //tournamentListAdapter = new TournamentListAdapter(this, factory);

        // attach query adapter to ListView
        //ListView tournamentListView = (ListView) findViewById(R.id.tournament_list_view);
        //tournamentListView.setAdapter(tournamentListAdapter);
        tournamentListView.setAdapter(adapter);

        tournamentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ParseObject tournament = (ParseObject)tournamentListView.getItemAtPosition(position);
                openDetailView(tournament);
            }
        });
    }

    private void openDetailView(ParseObject tournament) {
        Intent i = new Intent(TournamentActivity.this, TournamentdetailActivity.class);
        i.putExtra("ID", tournament.getObjectId());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tournament, menu);
        return true;
    }

    private class TournamentListAdapter extends ParseQueryAdapter<Tournament> {
        public TournamentListAdapter(Context context,
                                     QueryFactory<Tournament> queryFactory) {
            super(context, queryFactory);
        }

        @Override
        public View getItemView(Tournament tournament, View view, ViewGroup parent) {
           // ViewHolder holder;

            if (view == null) {
                view = View.inflate(getContext(), R.layout.row_two_column, null);
                //view = getLayoutInflater().inflate(R.layout.row_two_column, parent, false);
                //holder = new ViewHolder();

                //holder.tournamentName = (TextView)view.findViewById(R.id.column1);
                //holder.tournamentDateTime=(TextView)view.findViewById(R.id.column2);

                //view.setTag(holder);
            //} else {
            //    holder = (ViewHolder) view.getTag();
            }
            //TextView tournamentName = holder.tournamentName;
            //tournamentName.setText(tournament.getName());
            //TextView tournamentDateTime = holder.tournamentDateTime;
            //tournamentDateTime.setText(tournament.getDate() + " " + tournament.getTime());

            // use ParseQueryAdapter's getItemView to populate the main TextView
            super.getItemView(tournament, view, parent);

            return view;
        }
    }

    private static class ViewHolder {
        TextView tournamentName;
        TextView tournamentDateTime;

    }

}


