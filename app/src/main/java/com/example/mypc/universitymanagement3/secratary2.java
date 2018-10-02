package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.mypc.universitymanagement3.R.id.sb1;

public class secratary2 extends AppCompatActivity {
    Button button1;
    instructordb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secratary2);
        button1 = (Button) findViewById(sb1);

        db = new instructordb(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.m1:
                Intent i2=new Intent(this,feedback.class);
                startActivity(i2);
                break;
            case R.id.m2:
                Toast.makeText(this, "You Clicked on direction button!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                Intent i1=new Intent(this,MainActivity.class);
                startActivity(i1);
        }
        return true;
    }
    public void home(View view) {

        Intent i1 = new Intent(this, MainActivity.class);
        startActivity(i1);

    }

    public void viewresults(View view)
    {
        Cursor cursor = db.getAlldata();
        if (cursor.getCount() == 0) {
            return;
        }
        StringBuffer msg = new StringBuffer();
        while (cursor.moveToNext()) {
            msg.append("id:" + cursor.getString(0) + "\n");
            msg.append("name:" + cursor.getString(1) + "\n");
            msg.append("sub1: " + cursor.getString(2) + " and  ");
            msg.append("marks: " + cursor.getString(3) + "\n");
            msg.append("sub2: " + cursor.getString(4) + " and  ");
            msg.append("marks: " + cursor.getString(5) + "\n");
            msg.append("sub3: " + cursor.getString(6) + " and  ");
            msg.append("marks: " + cursor.getString(7) + "\n");


        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void announceress(View view)
    {
        Toast.makeText(this, "@@@ Results are send to all students successfully @@@\n", Toast.LENGTH_SHORT).show();
    }
}
