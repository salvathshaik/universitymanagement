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
public class instructoraddingmarks extends AppCompatActivity  {

    EditText id, name, sub1, marks1, sub2, marks2, sub3, marks3;
    Button bu, b1, update, delete,b3;
    instructordb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructoraddingmarks);


        db = new instructordb(this);
        id = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText2);
        sub1 = (EditText) findViewById(R.id.editText3);
        marks1 = (EditText) findViewById(R.id.editText4);
        sub2 = (EditText) findViewById(R.id.editText5);
        marks2 = (EditText) findViewById(R.id.editText6);
        sub3 = (EditText) findViewById(R.id.editText7);
        marks3 = (EditText) findViewById(R.id.editText8);
        bu = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);
        b3=(Button)findViewById(R.id.ubr);
        bu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean isInserted = db.insertData(id.getText().toString(), name.getText().toString(), sub1.getText().toString(), marks1.getText().toString(), sub2.getText().toString(), marks2.getText().toString(), sub3.getText().toString(), marks3.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
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
        });
       /* b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.getAlldata();
                if (cursor.getCount() == 0) {
                    return;
                }
                StringBuffer msg = new StringBuffer();
                while (cursor.moveToNext()) {
                    msg.append("Your results are :\n");
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
        });
*/
    }

    public void back(View view)
    {
        Intent i1=new Intent(this,instructortab.class);
        startActivity(i1);
    }


}