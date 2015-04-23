package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocationFragment extends ListFragment {

    ListViewAdapter mAdapter;
    LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

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

        mInflater = LayoutInflater.from(getActivity());
        if (mAdapter == null) {
            mAdapter = new ListViewAdapter(getActivity(),0,list);
        }
        getListView().setAdapter(mAdapter);
    }

    //---------------inner class--------------------------------------------
    public class ListViewAdapter extends ArrayAdapter<Tournament> {
        public ListViewAdapter(Context context, int resource, List<Tournament> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            //get tournament entry
            Tournament tournament=getItem(position);

            if(convertView == null){
                convertView = mInflater.inflate(R.layout.row_one_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                column1.setText(tournament.getLocation());
            }
            return convertView;
        }
    }

}
