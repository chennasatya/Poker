package com.example.lovelyhearts.poker;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class EditaccountActivity extends ActionBarActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editaccount);

        ((EditText) findViewById(R.id.editaccount_name)).setText(ParseUser.getCurrentUser().get("name").toString());
        ((EditText) findViewById(R.id.editaccount_email)).setText(ParseUser.getCurrentUser().getEmail());
        ((EditText) findViewById(R.id.editaccount_phone)).setText(ParseUser.getCurrentUser().get("phone").toString());
        ((EditText) findViewById(R.id.editaccount_address)).setText(ParseUser.getCurrentUser().get("address").toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editaccount, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.action_settings:
                break;
            case R.id.action_save:
                SaveChanges();
                finish();
                // Navigate back to the home screen
                Intent homeIntent = new Intent(EditaccountActivity.this, HomeActivity.class);
                NavUtils.navigateUpTo(EditaccountActivity.this, homeIntent);
                break;
            case R.id.action_delete:
                DeleteContact();
                // Navigate back to the Main Screen and log out
                Intent intent = new Intent(EditaccountActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void SaveChanges()
    {
        ParseUser user = ParseUser.getCurrentUser();
        user.put("name", ((TextView) findViewById(R.id.editaccount_name)).getText().toString());
        user.setEmail(((TextView) findViewById(R.id.editaccount_email)).getText().toString());
        user.put("phone", ((TextView) findViewById(R.id.editaccount_phone)).getText().toString());
        user.put("address", ((TextView) findViewById(R.id.editaccount_address)).getText().toString());

        user.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Show a simple Toast message upon successful registration
                    ShowToast("Changes Saved");
                } else {
                    ShowToast("Save Error:" + e.toString());
                }
            }
        });

    }

    private void DeleteContact() {
        ParseUser.getCurrentUser().deleteInBackground(new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // Show a simple Toast message upon successful registration
                    ShowToast("Delete successful");
                } else {
                    ShowToast("Delete Failed: " + e.toString());
                }
            }
        });
    }

    void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
