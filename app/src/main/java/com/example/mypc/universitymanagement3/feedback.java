package com.example.mypc.universitymanagement3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    EditText editText1;
    Button button1;
    feedbackdb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        editText1 = (EditText) findViewById(R.id.e1);
        button1 = (Button) findViewById(R.id.b1);
        db = new feedbackdb(this);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean isInserted = db.insertData(editText1.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public void viewfeedback(View view)
    {

    }
}
