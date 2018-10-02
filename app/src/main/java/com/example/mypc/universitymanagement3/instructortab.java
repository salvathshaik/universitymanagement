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


public class instructortab extends AppCompatActivity {


    TabLayout myTab;
    ViewPager myPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructortab);
        myPage = (ViewPager) findViewById(R.id.mypager3);
        myTab = (TabLayout) findViewById(R.id.myTab3);
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

    public void viewmidresults(View view)
    {
        Intent i1 = new Intent(this, instructoraddingmarks.class);
        startActivity(i1);
    }

    public void semresultsann(View view)
    {
        Toast.makeText(this, "semester results are announced soon\n", Toast.LENGTH_SHORT).show();
    }

    public void freshmodeann(View view)
    {
        Toast.makeText(this, "Freshmode results are announced soon\n", Toast.LENGTH_SHORT).show();
    }

    public void remann(View view)
    {
        Toast.makeText(this, "remedial results are announced soon\n", Toast.LENGTH_SHORT).show();
    }

    public void studentpj(View view)
    {
        Toast.makeText(this, "Not updated!!\nStudent projects updated soon\n", Toast.LENGTH_LONG).show();
    }

    public void facultypj(View view)
    {
        Toast.makeText(this, "Not updated!!\nFaculty projects updated soon\n", Toast.LENGTH_LONG).show();
    }

    class MyOwnPagerAdapter extends FragmentPagerAdapter {

        String data[] = {"check results", "projects"};

        public MyOwnPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new instructoraboutviewresults();
            }
            if (position == 1) {
                return new instructorboutprojects();
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