package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class user extends AppCompatActivity {
    TextView textView2;
    EditText  editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        editText1=(EditText)findViewById(R.id.e1);
        Intent i1=getIntent();

        Bundle b1=i1.getExtras();


       // String data=b1.getString("sendData");

       // textView2.setText(data);
    }

    public void viewresults(View view) {
    }

    public void requestresults(View view) {
    }
    public void home(View view)
    {

            Intent i1 = new Intent(this, MainActivity.class);
            startActivity(i1);

    }
}
