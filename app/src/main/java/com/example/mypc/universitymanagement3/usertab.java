package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class usertab extends AppCompatActivity {

    instructordb db;
    TabLayout myTab;
    ViewPager myPage;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertab);

        myPage = (ViewPager) findViewById(R.id.mypager);
        myTab = (TabLayout) findViewById(R.id.myTab);
        myPage.setAdapter(new MyOwnPagerAdapter(getSupportFragmentManager()));
        myTab.setupWithViewPager(myPage);
        db=new instructordb(this);
        b1 = (Button) findViewById(R.id.ubr);

       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });*/
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
    /*    b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=db.getAlldata();
                if(cursor.getCount()==0)
                {
                    return;
                }
                StringBuffer msg=new StringBuffer();
                while (cursor.moveToNext())
                {
                    msg.append("id:"+cursor.getString(0)+"\n");
                    msg.append("name:"+cursor.getString(1)+"\n");
                    msg.append("sname:"+cursor.getString(2)+"\n");
                    msg.append("marks:"+cursor.getString(3)+"\n");


                }
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m1:
                Intent i2 = new Intent(this, feedback.class);
                startActivity(i2);
                break;
            case R.id.m2:
                Toast.makeText(this, "You Clicked on direction button!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                Intent i1 = new Intent(this, MainActivity.class);
                startActivity(i1);
        }
        return true;
    }

    public void back(View view) {
        Intent i1 = new Intent(this, MainActivity.class);
        startActivity(i1);
    }


    public void requestresults(View view) {
        Intent i1 = new Intent(this, feedback.class);
        startActivity(i1);
    }

    public void checkresults(View view) {
        Toast.makeText(this, "Your results are \n\n", Toast.LENGTH_SHORT).show();
        Cursor cursor = db.getAlldata();
        if (cursor.getCount() == 0) {
            return;
        }
        StringBuffer msg = new StringBuffer();
        while (cursor.moveToNext()) {
            msg.append("id:" + cursor.getString(0) + "\n");
            msg.append("name:" + cursor.getString(1) + "\n");
            msg.append("sname:" + cursor.getString(2) + "\n");
            msg.append("marks:" + cursor.getString(3) + "\n");


        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


    class MyOwnPagerAdapter extends FragmentPagerAdapter {

        String data[] = {"Result status", "Feedback", "Complaints"};

        public MyOwnPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new useraboutresults();
            }
            if (position == 1) {
                return new useraboutfeedback();
            }
            if (position == 2) {
                return new useraboutcomplaints();
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


