package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CertainlocationFragment extends ListFragment {

    ListViewAdapter mAdapter;
    LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_certainlocation, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        List<Tournament> list=new ArrayList<Tournament>();
        Tournament t1=new Tournament();
        t1.setWeek("Friday");
        t1.setLocation("Corner Bar");
        t1.setDate("5/10/2015");
        t1.setTime("8pm");
        list.add(t1);
        Tournament t2=new Tournament();
        t2.setWeek("Monday");
        t2.setLocation("Corner Bar");
        t2.setDate("4/13/2015");
        t2.setTime("9pm");
        list.add(t2);

        mInflater = LayoutInflater.from(getActivity());
        if (mAdapter == null) {
            mAdapter = new ListViewAdapter(getActivity(),0,list);
        }
        getListView().setAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    }
    //---------------inner class--------------------------------------------
    public class ListViewAdapter extends ArrayAdapter<Tournament> {
        public ListViewAdapter(Context context, int resource, List<Tournament> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            Tournament tournament=getItem(position);

            if(convertView == null){
                convertView = mInflater.inflate(R.layout.row_three_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                column1.setText(tournament.getWeek());
                TextView column2=(TextView)convertView.findViewById(R.id.column2);
                column2.setText(tournament.getDate());
                TextView column3=(TextView)convertView.findViewById(R.id.column3);
                column3.setText(tournament.getTime());
            }
            return convertView;
        }
    }
}

