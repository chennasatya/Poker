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

public class RegisteredplayersFragment extends ListFragment {

    ListViewAdapter mAdapter;
    LayoutInflater mInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_registeredplayers, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        List<User> list=new ArrayList<User>();
        User t1=new User();
        t1.setName("Bob");
        list.add(t1);
        User t2=new User();
        t2.setName("Eva");
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
    public class ListViewAdapter extends ArrayAdapter<User> {
        public ListViewAdapter(Context context, int resource, List<User> objects){
            super(context,resource,objects);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            User user=getItem(position);

            if(convertView == null){
                convertView = mInflater.inflate(R.layout.row_one_column, parent, false);
                TextView column1=(TextView)convertView.findViewById(R.id.column1);
                column1.setText(user.getName());
            }
            return convertView;
        }
    }
}
