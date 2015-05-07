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
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;


public class TournamentActivity extends ActionBarActivity {

    private LayoutInflater inflater;
    private ParseQueryAdapter<Tournament> tournamentListAdapter;
    //private static final int LOGIN_ACTIVITY_CODE = 100;
    //private static final int EDIT_ACTIVITY_CODE = 200;
    private static final int VIEW_ACTIVITY_CODE = 300;

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
        ParseQueryAdapter.QueryFactory<Tournament> factory = new ParseQueryAdapter.QueryFactory<Tournament>() {
            public ParseQuery<Tournament> create() {
                ParseQuery<Tournament> query = Tournament.getQuery();
                query.orderByAscending("date");
                query.fromLocalDatastore();
                return query;
            }
        };

        // set up adapter
        inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        tournamentListAdapter = new TournamentListAdapter(this, factory);

        // attach query adapter to ListView
        ListView tournamentListView = (ListView) findViewById(R.id.tournament_list_view);
        tournamentListView.setAdapter(tournamentListAdapter);

        tournamentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tournament tournament = tournamentListAdapter.getItem(position);
                openDetailView(tournament);
            }
        });
    }

    private void openDetailView(Tournament tournament) {
        Intent i = new Intent(TournamentActivity.this, TournamentdetailActivity.class);
        i.putExtra("ID", tournament.getUuidString());
        startActivityForResult(i,VIEW_ACTIVITY_CODE);
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
            ViewHolder holder;

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.row_two_column, parent, false);
                holder = new ViewHolder();

                holder.tournamentName = (TextView)view.findViewById(R.id.column1);
                holder.tournamentDateTime=(TextView)view.findViewById(R.id.column2);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            TextView tournyName = holder.tournamentName;
            tournyName.setText(tournament.getName());
            TextView tournyDT = holder.tournamentDateTime;
            tournyDT.setText(tournament.getDate() + " " + tournament.getTime());

            return view;
        }
    }

    private static class ViewHolder {
        TextView tournamentName;
        TextView tournamentDateTime;

    }

}


