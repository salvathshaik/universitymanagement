package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class instructor2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor2);
    }



    public void home(View view)
    {

        Intent i1 = new Intent(this, MainActivity.class);
        startActivity(i1);

    }


    public void viewmidresults(View view)
    {
        Intent i1 = new Intent(this, instructoraddingmarks.class);
        startActivity(i1);
    }

}
