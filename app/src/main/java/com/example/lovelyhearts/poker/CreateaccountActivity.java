package com.example.lovelyhearts.poker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class CreateaccountActivity extends ActionBarActivity {

    static EditText username;
    static EditText password;
    static EditText email;
    static EditText phone;
    static EditText address;
    static EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        username = (EditText)findViewById(R.id.createaccount_username);
        name = (EditText)findViewById(R.id.createaccount_name);
        password = (EditText)findViewById(R.id.createaccount_pwd);
        email = (EditText)findViewById(R.id.createaccount_email);
        phone = (EditText)findViewById(R.id.createaccount_phone);
        address = (EditText)findViewById(R.id.createaccount_address);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_createaccount, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        String uservalue = username.getText().toString();
        String pwdValue = password.getText().toString();
        String emailValue = email.getText().toString();
        String phoneValue = phone.getText().toString();
        String addressValue = address.getText().toString();
        String nameValue = name.getText().toString();

        switch(id){
        case R.id.action_save:
            // Force user to fill up the form
            if (uservalue.equals("") && pwdValue.equals("")) {
                Toast.makeText(getApplicationContext(),
                        "Please complete the sign up form",
                        Toast.LENGTH_LONG).show();
            }
            else
            {
                // Save new user data into Parse.com Data Storage
                ParseUser user = ParseUser.getCurrentUser();

                // If a user is already logged in, log them out first
                // Parse will just return an error if they try to create the same
                // account again, so no reason to keep them logged in on the createaccount page
                if (user != null) {
                    ParseUser.logOut();
                }

                user = new ParseUser();

                //ParseUser user = new ParseUser();
                user.setUsername(uservalue);
                user.setPassword(pwdValue);
                user.setEmail(emailValue);
                user.put("phone", phoneValue);
                user.put("address", addressValue);
                user.put("name",nameValue);
                user.put("isAdmin",false);

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Show a simple Toast message upon successful registration
                            Toast.makeText(getApplicationContext(),
                                    "Successfully Signed up, please log in.",
                                    Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Sign up Error: "+e.toString(), Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });
            }
            break;
        case R.id.action_delete:
            Toast.makeText(getApplicationContext(),
                    "Nothing to do, user not created",
                    Toast.LENGTH_LONG).show();
            break;
        default:
            break;
        }

        return super.onOptionsItemSelected(item);
    }
}
