package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Spinner spinner;
    private String[] typesOfUsers;
    List<User> allUsers;
    boolean userExists = false;
    boolean pwdCorrect = false;
    static EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.tvUserName);
        final EditText password =(EditText)findViewById(R.id.tvPassword);

        final Button buttonSigin =(Button)findViewById(R.id.btn_SignIn);
        final Button buttonCreateAccount = (Button) findViewById(R.id.btn_createAccount);

       /* allUsers = new ArrayList<User>();
        User u1 = new User();
        u1.setName("u");
        u1.setPassword("u");
        u1.setIsAdmin(true);

        User u2 = new User();
        u2.setName("User2");
        u2.setPassword("User2");
        u2.setIsAdmin(false);

        allUsers.add(u1);
        allUsers.add(u2);

        */

        buttonSigin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String uservalue= username.getText().toString();
                String pwdValue = password.getText().toString();

// Send data to Parse.com for verification
                ParseUser.logInInBackground(uservalue, pwdValue,
                        new LogInCallback() {
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {
                                    // If user exist and authenticated send user to Welcome.class
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    final TextView invalid = (TextView) findViewById(R.id.LblLoginNotSuccess);
                                    Toast.makeText(getApplicationContext(),
                                            "Successfully Logged in",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "No such user exist, please signup",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                /*
                for(User user: allUsers)
                {
                    //boolean cal = user.equals(currentUser);
                    String name =user.getName();
                    String pwd = user.getPassword();


                    if(name.equals(uservalue)) {
                        userExists = true;
                        if(pwd.equals(pwdValue))
                        {
                            pwdCorrect = true;
                            break;
                        }

                    }
                }

                if(userExists == true )
                {
                    if(pwdCorrect == true)
                    {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        final TextView invalid = (TextView) findViewById(R.id.LblLoginNotSuccess);
                        invalid.setText("");
                    }

                    else
                    {
                        final TextView invalid = (TextView) findViewById(R.id.LblLoginNotSuccess);
                        invalid.setText("Invalid Username and Password");
                    }
                }

                else
                {
                    final TextView invalid = (TextView) findViewById(R.id.LblLoginNotSuccess);
                    invalid.setText("No user Exits. Create New User");
                }*/

            }
        });

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CreateaccountActivity.class);
                startActivity(intent);
            }

        });


        //----------------------home button (for test)-----------------
//        Button buttonHome = (Button) findViewById(R.id.btn_home);
//        buttonHome.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);
//            }
//
//        });

        /* RTT this keeps crashing and I can't get it to work ARRRRRRGGGGGHHHH
        ParseObject.registerSubclass(Location.class);

        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "CMGQQp6k1D8jVqr39taB6iEVwLSV39VNJq6SmEJe", "uSZcKaAIdtdQ8xxbiTMmRZTDiXiwT5FnSiOT6bLt");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        //DatabaseHelper.getInstance().TestDb();
        // Create a post.
        Location mLocation = new Location();
        mLocation.SetId(1);
        mLocation.SetName("Corner Bar");
        mLocation.SetEmail("contact.email.com");
        mLocation.SetAddress1("1234 1st Street");
        mLocation.SetAddress2("");
        mLocation.SetCity("Minneapolis");
        mLocation.SetState("MN");
        mLocation.SetZip("55441");
        mLocation.SetPhone("612-123-4567");
        mLocation.SetUrl("www.cornerbar.com");

        // Give public read access
        defaultACL.setPublicReadAccess(true);
        mLocation.setACL(defaultACL);



        // Save the post
        mLocation.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Log.w("tag","Saved Location entry");
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //TEST CODE
        //Log.i("GetDatabaseTask", Database.getInstance().toString());

        return super.onOptionsItemSelected(item);
    }
}
