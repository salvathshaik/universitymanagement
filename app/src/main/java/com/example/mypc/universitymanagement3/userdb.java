package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class userdb extends AppCompatActivity  {

    EditText requestresults;
    Button bu, b1, update, delete;
    userdbdb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdb);


        db = new userdbdb(this);
        requestresults = (EditText) findViewById(R.id.editTextu1);
        bu = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.ub2);
        update = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);

    }

    public void back(View view)
    {
        Intent i1=new Intent(this,userdbdb.class);
        startActivity(i1);
    }
}