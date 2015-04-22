package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TabTournamentLocation extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_tournament_location);
        //----------data------------
        List<Tournament> list=new ArrayList<Tournament>();
        Tournament t1=new Tournament();
        t1.setDate("4/12");
        t1.setTime("5pm");
        t1.setLocation("corner bar");
        list.add(t1);
        Tournament t2=new Tournament();
        t2.setDate("4/15");
        t2.setTime("6pm");
        t2.setLocation("CrabShack");
        list.add(t2);
        //-------------set adapter-----------
        ListViewAdapter myAdapter = new ListViewAdapter(this, 0, list);
        setListAdapter(myAdapter);
    }

    public class ListViewAdapter extends ArrayAdapter<Tournament> {
        public ListViewAdapter(Context context, int resource, List<Tournament> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            //get tournament entry
            Tournament tournament=getItem(position);

            if(convertView == null){
                convertView=inflater.inflate(R.layout.row_one_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                column1.setText(tournament.getLocation());
                //   convertView = inflater.inflate(R.layout.row_header, null);
                //   TextView header=(TextView)convertView.findViewById(R.id.ttl_rowheader);

            }

            return convertView;
        }
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Tournament tournament = (Tournament)getListAdapter().getItem(position);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    public void updateAdapter(List<Tournament> objects) {
        setListAdapter(new ListViewAdapter(TabTournamentLocation.this, R.layout.row_one_column, objects));
    }


    void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    // The next two are called when we switch back into this activity
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    // The next two are called when we switch away from this activity
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
