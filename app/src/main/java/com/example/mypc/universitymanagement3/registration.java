package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by MY PC on 10-04-2018.
 */
public class registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText id, name, sname, marks;
    Button bu, b1, update, delete;
    databasehelper db;

    String interfaces = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = new databasehelper(this);
        id = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText2);
        sname = (EditText) findViewById(R.id.editText3);
        marks = (EditText) findViewById(R.id.editText4);
        bu = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);
        bu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean isInserted = db.insertData(id.getText().toString(), name.getText().toString(), sname.getText().toString(), marks.getText().toString());
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
                    msg.append("sname:" + cursor.getString(2) + "\n");
                    msg.append("marks:" + cursor.getString(3) + "\n");


                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean isInserted = db.insertData(id.getText().toString(), name.getText().toString(), sname.getText().toString(), marks.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(getApplicationContext(), "successfully updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "successfully not updated", Toast.LENGTH_SHORT).show();
                }
            }

        });

        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Integer deletedRows = db.deleteData(id.getText().toString());
                if (deletedRows > 0) {
                    Toast.makeText(getApplicationContext(), "successfully deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "your id not found", Toast.LENGTH_SHORT).show();
                }
            }

        });

        Spinner spin = (Spinner) findViewById(R.id.spinid);
        if (spin != null) {
            spin.setOnItemSelectedListener(this);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.choose_interface));
        if (spin != null) {
            spin.setAdapter(adapter);
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        interfaces = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void show(View view) {
        Toast.makeText(this, "you selected " + interfaces, Toast.LENGTH_SHORT).show();
        if (interfaces.equals("User viewer")) {
            Intent i1 = new Intent(this, user.class);
            startActivity(i1);
        }
        if (interfaces.equals("Hod viewer")) {
            Intent i1 = new Intent(this, hod.class);
            startActivity(i1);
        }
        if (interfaces.equals("instructor viewer")) {
            Intent i1 = new Intent(this, instructor.class);
            startActivity(i1);
        }
        if (interfaces.equals("secratary viewer")) {
            Intent i1 = new Intent(this, secratary.class);
            startActivity(i1);
        }
    }
}

