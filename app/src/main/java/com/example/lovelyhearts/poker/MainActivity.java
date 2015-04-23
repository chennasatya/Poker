package com.example.lovelyhearts.poker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends Activity {

    private Spinner spinner;
    private String[] typesOfUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText username=(EditText)findViewById(R.id.tvUserName);
        final EditText password =(EditText)findViewById(R.id.tvPassword);
        final Button buttonSigin =(Button)findViewById(R.id.btn_SignIn);
        final Button buttonCreateAccount = (Button) findViewById(R.id.btn_createAccount);
        buttonSigin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String uservalue= username.getText().toString();
                String pwdValue = password.getText().toString();
                if(uservalue.equals("user") && pwdValue.equals("poker") ) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CreateaccountActivity.class);
                startActivity(intent);
            }

        });




        //----------------------tournament button-----------------
        Button buttonTournament = (Button) findViewById(R.id.btn_tournament);
        buttonTournament.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TournamentActivity.class);
                startActivity(intent);
            }

        });
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
