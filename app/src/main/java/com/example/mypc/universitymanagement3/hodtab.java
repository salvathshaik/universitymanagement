package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class hodtab extends AppCompatActivity {


    TabLayout myTab;
    ViewPager myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hodtab);
        myPage = (ViewPager) findViewById(R.id.mypager1);
        myTab = (TabLayout) findViewById(R.id.myTab1);
        myPage.setAdapter(new MyOwnPagerAdapter(getSupportFragmentManager()));
        myTab.setupWithViewPager(myPage);
        myTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
    public void back(View view)
    {
        Intent i1 = new Intent(this, MainActivity.class);
        startActivity(i1);
    }

    public void viewe1(View view)
    {
        Toast.makeText(this, "@@ E1 Details @@\ntotal members are 300\n", Toast.LENGTH_SHORT).show();
    }

    public void viewe2(View view)
    {
        Toast.makeText(this, "@@ E2 Details @@\ntotal members are 280", Toast.LENGTH_SHORT).show();
    }

    public void viewe3(View view)
    {
        Toast.makeText(this, "@@ E3 Details @@\ntotal members are 250", Toast.LENGTH_SHORT).show();
    }

    public void viewe4(View view)
    {
        Toast.makeText(this, "@@ E4 Details @@\ntotal members are 200", Toast.LENGTH_SHORT).show();
    }

    public void fundstatus(View view)
    {
        Toast.makeText(this, "Fund requests are amount of 10000/-", Toast.LENGTH_SHORT).show();
    }

    public void fundsan(View view)
    {
        Toast.makeText(this, "All funds has been sanctioned", Toast.LENGTH_SHORT).show();
    }

    public void aboutus(View view)
    {
        Toast.makeText(this, "Faculty details are\n @@UPDATED SOON@@", Toast.LENGTH_SHORT).show();
    }

    public void facpub(View view)
    {
        Toast.makeText(this, "Faculty publications are should improve more!", Toast.LENGTH_SHORT).show();
    }

    public void facproj(View view)
    {
        Toast.makeText(this, "@@@ GREAT @@@\nTotal projects are 100 of your faculty", Toast.LENGTH_SHORT).show();
    }


    class MyOwnPagerAdapter extends FragmentPagerAdapter {

        String data[] = {"Batch Mates", "Funds", "Faculty"};

        public MyOwnPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new hodaboutdepartment();
            }
            if (position == 1) {
                return new hodaboutfunds();
            }
            if (position == 2) {
                return new hodaboutfaculty();
            }
            return null;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }
}