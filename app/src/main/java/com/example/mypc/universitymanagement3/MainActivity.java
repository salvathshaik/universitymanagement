package com.example.mypc.universitymanagement3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    progresstask p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void progress(View view) {
        p1= new progresstask(this);
        p1.execute();



        Intent i1=new Intent(this,loginpage.class);
        startActivity(i1);

    }

    public void viewresults(View view) {
        Toast.makeText(this, "annouced ssoon", Toast.LENGTH_SHORT).show();
    }
}




