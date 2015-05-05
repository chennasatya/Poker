package com.example.lovelyhearts.poker;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.app.ListFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TournamentdetailActivity extends ActionBarActivity {
    List<Tournament> tournamentList ;
    private static List<Location> locations;
    UserManager um;
    User mUser;
    String username ;
    TextView textMsg;
    RegisteredplayersFragment rs;

    boolean registered = false;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentdetail);

        username = MainActivity.username.getText().toString();

        tournamentList = new ArrayList<Tournament>();

        Tournament t = new Tournament();
        t.setLocation("Corner bar");
        t.setDate("5/10/2015");
        t.setTime("8 PM");
        t.setWeek("Friday");
        t.setBuyIn(10);
        t.setPosition(0);

        tournamentList.add(t);

        Tournament t2 = new Tournament();
        t2.setLocation("Corner bar");
        t2.setDate("4/13/2015");
        t2.setTime("9 PM");
        t2.setWeek("Monday");
        t2.setBuyIn(20);
        t2.setPosition(1);
        tournamentList.add(t2);


        String locationName = getIntent().getExtras().getString("_locationId");
        int position = getIntent().getExtras().getInt("_positionId");

        for(Tournament tor: tournamentList)
        {
            String loc = tor.getLocation().trim();

            if(tor.getLocation().equals(locationName) && tor.getPosition() == position) {

                ((EditText) findViewById(R.id.editLocation)).setText(tor.getLocation());
                ((EditText) findViewById(R.id.editTime)).setText(tor.getTime());
                ((EditText) findViewById(R.id.editDate)).setText(tor.getDate());
                ((EditText) findViewById(R.id.editBuyin)).setText(String.valueOf(tor.getBuyIn()));
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_tournamentdetail, menu);
        um = new UserManager();
        username = MainActivity.username.getText().toString();
        mUser = um.GetUser(username);
        boolean isAdmin = mUser.getIsAdmin();
        if(isAdmin == true)
        {
            getMenuInflater().inflate(R.menu.menu_tournamentdetail, menu);
        }

        else {
            textMsg = (TextView) findViewById(R.id.lbl_registerwarning);
            String mess = textMsg.getText().toString();

            if((mess.contains("You are not registered") || mess.contains("")) && registered == false) {
                textMsg.setText("You are not registered");
                getMenuInflater().inflate(R.menu.menu_usertournamentdetail, menu);
            }
            else if(registered == true)
            {
                getMenuInflater().inflate(R.menu.menu_registertournamentdetails, menu);
                textMsg.setText("You are registered");
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent=null;
        rs = new RegisteredplayersFragment();
        switch(id){
            //player
            case R.id.action_play:
                intent = new Intent(this,PlayActivity.class);
                startActivity(intent);
                break;
           //admin
            case R.id.action_Assigntable:
                intent = new Intent(this,TableActivity.class);
                startActivity(intent);
                break;

            case R.id.action_Register:
                textMsg.setText("You are registered");
                //Need to Do: Update data to DB
                registered = true;
                invalidateOptionsMenu();

//
//
//                 Fragment fm =  getFragmentManager().findFragmentById(R.id.ttl_registeredplayers);
//                 // View listView = fm.getActivity().findViewById(R.id.ttl_registeredplayers);
//                List<User> l = new ArrayList<User>();
//                User t1=new User();
//                t1.setName(username);
//                l.add(t1);

                break;

            case R.id.action_unregister:
                textMsg.setText("You are not registered");
                //Need to Do: Update data to DB
                registered = false;
                invalidateOptionsMenu();
                break;

            case R.id.action_edittournament:
                intent = new Intent(this,EditTournament.class);
                String location = ((EditText)findViewById(R.id.editLocation)).getText().toString();
                intent.putExtra("_locationName", location);
                startActivity(intent);
                ShowToast("Changes Saved");
                finish();
                break;

            case R.id.action_deletetournament:
                NavUtils.navigateUpFromSameTask(this);
                break;

            default:
                return super.onOptionsItemSelected(item);


        }
        return true;
    }


    void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void SaveChanges()
    {
        Tournament mTournament = new Tournament();
        mTournament.setLocation(((TextView) findViewById(R.id.editLocation)).getText().toString());
        mTournament.setDate(((TextView) findViewById(R.id.editDate)).getText().toString());
        mTournament.setTime(((TextView) findViewById(R.id.editTime)).getText().toString());
       // mTournament.setBuyIn((TextView) findViewById((R.id.editBuyin)).toString()
        //getText().toString());


    }


}
