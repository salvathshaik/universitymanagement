package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class hod2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hod);
    }

    public void e1details(View view)
    {
        Toast.makeText(this, "@@ E1 Details @@\ntotal members are 300\n", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "@@ E2 Details @@\ntotal members are 280", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "@@ E3 Details @@\ntotal members are 250", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "@@ E4 Details @@\ntotal members are 200", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "All funds has been sanctioned", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Fund requests are amount of 10000/-", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Faculty publications are awesome!", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Faculty details are\n @@UPDATED SOON@@", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Total projects are 100 of your faculty", Toast.LENGTH_SHORT).show();
    }

    public void e2details(View view)
    {
        Toast.makeText(this, "total members are 280", Toast.LENGTH_SHORT).show();
    }

    public void e3details(View view)
    {
        Toast.makeText(this, "total members are 250", Toast.LENGTH_SHORT).show();
    }

    public void e4details(View view)
    {
        Toast.makeText(this, "total members are 200", Toast.LENGTH_SHORT).show();
    }

    public void fundrequest(View view)
    {
        Toast.makeText(this, "available fund requests are 10000", Toast.LENGTH_SHORT).show();
    }

    public void fundsanction(View view)
    {
        Toast.makeText(this, "your fund has been sanctioned", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "available fund requests are 10000", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "faculty publications are awesome!", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "faculty details are ", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "projects are 100", Toast.LENGTH_SHORT).show();
    }

    public void facultypublications(View view)
    {
        Toast.makeText(this, "faculty publications are awesome!", Toast.LENGTH_SHORT).show();
    }

    public void facultydetails(View view)
    {
        Toast.makeText(this, "faculty details are ", Toast.LENGTH_SHORT).show();
    }

    public void projects(View view)
    {
        Toast.makeText(this, "projects are 100", Toast.LENGTH_SHORT).show();
    }
    public void home(View view)
    {

        Intent i1 = new Intent(this, MainActivity.class);
        startActivity(i1);

    }
}
