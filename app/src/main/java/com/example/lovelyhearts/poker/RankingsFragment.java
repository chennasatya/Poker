package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class RankingsFragment extends ListFragment {
    ListViewAdapter mAdapter;
    LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_rankings, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        List<Player> list=new ArrayList<Player>();
        Player t2=new Player();
        t2.setOverallRank("12");
        t2.setPlayerId("2");
        t2.setPlayerName("Tony");
        list.add(t2);
        Player t3=new Player();
        t3.setOverallRank("23");
        t3.setPlayerId("3");
        t3.setPlayerName("Asuka");
        list.add(t3);
        Player t1=new Player();
        t1.setOverallRank("30");
        t1.setPlayerId("1");
        t1.setPlayerName("Joe");
        list.add(t1);

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
    public class ListViewAdapter extends ArrayAdapter<Player> {
        public ListViewAdapter(Context context, int resource, List<Player> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            //get tournament entry
            Player player=getItem(position);

            if(convertView == null){
                convertView = mInflater.inflate(R.layout.row_three_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                TextView column2=(TextView)convertView.findViewById(R.id.column2);
                TextView column3=(TextView)convertView.findViewById(R.id.column3);
                column1.setText(player.getPlayerId());
                column2.setText(player.getPlayerName());
                column3.setText(player.getOverallRank());
            }
            return convertView;
        }
    }
}
