package com.halfacode.travelagency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Log extends AppCompatActivity {

    EditText un,pass;
    String n,p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        un=(EditText) findViewById(R.id.edituser);
        pass=(EditText) findViewById(R.id.editpassword);
    }
    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_home:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;

            case R.id.menu_dest:
                Intent intent2 = new Intent(this, Destinations.class);
                startActivity(intent2);
                return true;
            case R.id.menu_book:
                Intent intent3 = new Intent(this, Book.class);
                startActivity(intent3);
                return true;
            case R.id.menu_log:
                Intent intent4 = new Intent(this, Log.class);
                startActivity(intent4);
                return true;
            case R.id.menu_share:
                Intent intent6 = new Intent(this, Share.class);
                startActivity(intent6);
                return true;
            case R.id.menu_contact:
                Intent intent5 = new Intent(this, Contactus.class);
                startActivity(intent5);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    public void LogOn(View v)
    {
        n=un.getText().toString();
        p=pass.getText().toString();
        //Toast.makeText(getApplicationContext(),"Welcome  "+n+" "+p,Toast.LENGTH_LONG).show();
        DatabaseHandler dbHandler = new DatabaseHandler(this, null, null, 1);
        User user = new User();
        if(dbHandler.findUser(n,p)!= null) {
            Toast.makeText(getApplicationContext(),"Welcome  "+n,Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Unknow user ! please sign in !",Toast.LENGTH_LONG).show();



    }

    public void Account(View v)
    {
        Intent i2 = new Intent(this, Signin.class);
        startActivity(i2);
    }
}
