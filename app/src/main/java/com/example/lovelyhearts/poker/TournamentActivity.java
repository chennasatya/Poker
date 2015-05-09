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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;


public class TournamentActivity extends ActionBarActivity {

    private LayoutInflater inflater;
    private ParseQueryAdapter<Tournament> tournamentListAdapter;
    //private static final int LOGIN_ACTIVITY_CODE = 100;
    //private static final int EDIT_ACTIVITY_CODE = 200;

    private ListView tournamentListView;
    private LinearLayout noTournamentView;
    private LinearLayout searchTournamentView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);

        // set up views for this layout
        tournamentListView = (ListView) findViewById(R.id.tournament_list_view);
        //noTournamentView = (LinearLayout) findViewById(R.id.no_tournament_view);
        //searchTournamentView = (LinearLayout) findViewById(R.id.search_tournament_view);

        // set up Parse query for adapter

        ParseQueryAdapter.QueryFactory<Tournament> factory = new ParseQueryAdapter.QueryFactory<Tournament>() {
            public ParseQuery<Tournament> create() {
                ParseQuery<Tournament> query = Tournament.getQuery();
                query.orderByAscending("date");
                //query.fromLocalDatastore();       //this really should be included for persistence
                return query;
            }
        };

        //ParseQueryAdapter<Tournament> adapter = new ParseQueryAdapter(this, "Tournament");
        //adapter.setTextKey("name");

        // set up adapter
        //inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //tournamentListAdapter = new TournamentListAdapter(this, factory);

        // attach query adapter to ListView
        //ListView tournamentListView = (ListView) findViewById(R.id.tournament_list_view);
        //tournamentListView.setAdapter(tournamentListAdapter);

        /*
        ParseQuery<Tournament> query = Tournament.getQuery();

        try {
            List<Tournament> results = query.find();
            ArrayAdapter<Tournament> adapter = new ArrayAdapter<Tournament>(this,android.R.layout.activity_list_item,results);
            tournamentListView.setAdapter(adapter);
        } catch (ParseException e) {

        }
        */

        //tournamentListView.setEmptyView(searchTournamentView);
        //ParseQuery<Tournament> query = Tournament.getQuery();

        /*try {
            query.find();
            if (query.count() == 0) {
                tournamentListView.setEmptyView(noTournamentView);
            }
        } catch (ParseException e) {
            //do something
        }
        */
        tournamentListView.setAdapter(new TournamentListAdapter(TournamentActivity.this, factory));

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

        public View getItemView(int position, View tournamentView, ViewGroup parent) {
            View view;

            //null means android hasn't found anything to be reused, need to create new
            if (tournamentView == null) {
                //get layoutinflator - uses id to pull layout out of xml and inflate into object
                //attach the object to the parent
                view = getLayoutInflater().inflate(R.layout.activity_tournament, parent, false);
            } else {
                view = tournamentView;
            }

            return view;
        }

    }

    private static class ViewHolder {
        TextView tournamentName;
        TextView tournamentDateTime;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent=null;


        switch(id){
            case R.id.action_addtournament:
                intent = new Intent(this,EditTournament.class);
                intent.putExtra("_addNew",true);
                startActivity(intent);
                return true;

//            case R.id.action_playtournament:
//                intent = new Intent(this,PlayActivity.class);
//                intent.putExtra("_showPlay",true);
//                intent.putExtra("_tournamentID", "yLR7y5RD8k");
//                startActivity(intent);
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
    //easier to make adapter an inner class - common to put this in activity class
    class TournamentListAdapter extends ArrayAdapter<Tournament> {

        public TournamentListAdapter(Context context, int resource, List<Tournament> objects) {
            super(context, resource, objects);
        }

@Override
        public View getView(Tournament tournament, View view, ViewGroup parent) {
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
    */
}


