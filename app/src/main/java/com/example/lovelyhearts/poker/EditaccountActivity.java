package com.example.lovelyhearts.poker;

import android.content.Context;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class EditaccountActivity extends ActionBarActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editaccount);

        username = getIntent().getExtras().getString("_userName");

        UserManager um = new UserManager();
        User mUser = um.GetUser(username);

        ((EditText) findViewById(R.id.editaccount_name)).setText(mUser.getName());
        ((EditText) findViewById(R.id.editaccount_email)).setText(mUser.getEmail());
        ((EditText) findViewById(R.id.editaccount_name)).setText(mUser.getName());
        ((EditText) findViewById(R.id.editaccount_phone)).setText(String.valueOf(mUser.getPhone()));
        ((EditText) findViewById(R.id.editaccount_address)).setText(String.valueOf(mUser.getAddress1() +  mUser.getAddress2()));

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
                ShowToast("Changes Saved");
                finish();
                break;
            case R.id.action_delete:
                //DeleteContact();
                ShowToast("Contact Deleted");
                NavUtils.navigateUpFromSameTask(this);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void SaveChanges()
    {
        User mUser = new User();
        mUser.setName(((TextView) findViewById(R.id.editaccount_name)).getText().toString());
        mUser.setEmail(((TextView) findViewById(R.id.editaccount_email)).getText().toString());
        mUser.setPhone(((TextView) findViewById(R.id.editaccount_phone)).getText().toString());
        mUser.setAddress1(((TextView) findViewById(R.id.editaccount_address)).getText().toString());


    }

    void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
