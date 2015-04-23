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


public class Round3Fragment extends ListFragment {

    ListViewAdapter mAdapter;
    LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_round3, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        List<Table> list=new ArrayList<Table>();
        Table t1=new Table();
        t1.setSeatNumber(1);
        t1.setTableId(1);
        t1.setUserName("Sijia");
        list.add(t1);
        Table t2=new Table();
        t2.setSeatNumber(2);
        t2.setTableId(1);
        t2.setUserName("Satya");
        list.add(t2);
        Table t3=new Table();
        t3.setSeatNumber(3);
        t3.setTableId(1);
        t3.setUserName("Ryan");
        list.add(t3);
        Table t4=new Table();
        t4.setSeatNumber(4);
        t4.setTableId(1);
        t4.setUserName("Andrew");
        list.add(t4);

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
    public class ListViewAdapter extends ArrayAdapter<Table> {
        public ListViewAdapter(Context context, int resource, List<Table> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            Table table=getItem(position);

            if(convertView == null){
                convertView = mInflater.inflate(R.layout.row_three_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                TextView column2=(TextView)convertView.findViewById(R.id.column2);
                TextView column3=(TextView)convertView.findViewById(R.id.column3);
                column1.setText(Integer.toString(table.getTableId()));
                column2.setText(Integer.toString(table.getSeatNumber()));
                column3.setText(table.getUserName());
            }
            return convertView;
        }
    }
}
