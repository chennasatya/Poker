package com.example.lovelyhearts.poker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DetailaccountActivity extends ActionBarActivity {

    //private static List<User> users;
    UserManager um;
    User mUser;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailaccount);

        ((EditText) findViewById(R.id.detailaccount_name)).setText(ParseUser.getCurrentUser().get("name").toString());
        ((EditText) findViewById(R.id.detailaccount_email)).setText(ParseUser.getCurrentUser().getEmail());
        ((EditText) findViewById(R.id.detailaccount_username)).setText(ParseUser.getCurrentUser().getUsername());
        ((EditText) findViewById(R.id.detailaccount_phone)).setText(ParseUser.getCurrentUser().get("phone").toString());
        ((EditText) findViewById(R.id.detailaccount_address)).setText(ParseUser.getCurrentUser().get("address").toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailaccount, menu);

        boolean isAdmin = ParseUser.getCurrentUser().getBoolean("isAdmin");

        if(isAdmin == true)
        {
            //getMenuInflater().inflate(R.menu.menu_detailaccount, menu);
        }

        else {

            //getMenuInflater().inflate(R.menu.normaluserdetailsaccount, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent=null;


        switch(id){
            case R.id.action_edit:
                //final String name = MainActivity.username.getText().toString();
                intent = new Intent(this,EditaccountActivity.class);
                intent.putExtra("_userName",username);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    public User GetUser(String mId)
//    {
//        try {
//            return getUserById(mId);
//        }
//        catch (Exception ex) {
//            Log.w("GetContact", "No Contact with id=[" + mId + "]");
//            return null;
//        }
//    }
//
//    public User getUserById(String id) throws UserNotFoundException {
//        Iterator<User> itr = users.iterator();
//
//        while (itr.hasNext()) {
//            User curr = itr.next();
//            if (curr.getName().equals(id)) {
//                return curr;
//            }
//        }
//        throw new UserNotFoundException("Exception: No contact found with id [" + id + "]");
//    }
//
//    private class UserNotFoundException extends Exception {
//        public UserNotFoundException(String msg) {
//            super(msg);
//        }
//    }
}


