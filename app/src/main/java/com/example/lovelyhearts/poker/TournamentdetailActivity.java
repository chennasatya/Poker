package com.example.lovelyhearts.poker;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TournamentdetailActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentdetail);
        //----------data------------
        List<User> list=new ArrayList<User>();
        User u1 = new User();
        u1.setName("Bob");
        list.add(u1);
        //-------------set adapter-----------
        ListViewAdapter myAdapter = new ListViewAdapter(this, 0, list);
        setListAdapter(myAdapter);
    }


    public class ListViewAdapter extends ArrayAdapter<User> {
        public ListViewAdapter(Context context, int resource, List<User> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            //get tournament entry
            User user=getItem(position);

            if(convertView == null){
                convertView=inflater.inflate(R.layout.row_one_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                column1.setText(user.getName());

                //   convertView = inflater.inflate(R.layout.row_header, null);
                //   TextView header=(TextView)convertView.findViewById(R.id.ttl_rowheader);

            }

            return convertView;
        }
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        User user = (User)getListAdapter().getItem(position);

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

    public void updateAdapter(List<User> objects) {
        setListAdapter(new ListViewAdapter(TournamentdetailActivity.this, R.layout.row_one_column, objects));
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
