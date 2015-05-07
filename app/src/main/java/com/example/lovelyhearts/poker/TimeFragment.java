package com.example.lovelyhearts.poker;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TimeFragment extends ListFragment {

    ListViewAdapter mAdapter;
    LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_time, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        List<Tournament> list=new ArrayList<Tournament>();
        Tournament t1=new Tournament();
        t1.setDate("4/12/2015");
        t1.setTime("5pm");
        list.add(t1);
        Tournament t2=new Tournament();
        t2.setDate("4/15/2015");
        t2.setTime("6pm");
        list.add(t2);
        Tournament t3=new Tournament();
        t3.setDate("4/15/2015");
        t3.setTime("7pm");
        list.add(t3);

        mInflater = LayoutInflater.from(getActivity());
        if (mAdapter == null) {
            mAdapter = new ListViewAdapter(getActivity(),0,list);
        }
        getListView().setAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity().getApplicationContext(), TournamentdetailActivity.class);
        startActivity(intent);
    }
    //---------------inner class--------------------------------------------
    public class ListViewAdapter extends ArrayAdapter<Tournament> {
        public ListViewAdapter(Context context, int resource, List<Tournament> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            //get tournament entry

            if(convertView == null){
                //if the tournament position is the first

                    Tournament tournament=getItem(position);
                    convertView = mInflater.inflate(R.layout.row_two_column, parent, false);
                    TextView column1=(TextView)convertView.findViewById(R.id.column1);
                    TextView column2=(TextView)convertView.findViewById(R.id.column2);
                    column1.setText(String.valueOf(tournament.getDate()));
                    column2.setText(String.valueOf(tournament.getTime()));
            }
            return convertView;
        }
    }
}
