package com.example.mypc.universitymanagement3;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MY PC on 10-04-2018.
 */
public class admin extends AppCompatActivity {

    EditText id,name,sname,marks;
    Button bu,b1,update,delete;
    databasehelper db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new databasehelper(this);
        id=(EditText)findViewById(R.id.editText);
        name=(EditText)findViewById(R.id.editText2);
        sname=(EditText)findViewById(R.id.editText3);
        marks=(EditText)findViewById(R.id.editText4);
        bu=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button2);
        update=(Button)findViewById(R.id.button3);
        delete=(Button)findViewById(R.id.button4);
        bu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                boolean isInserted=db.insertData(id.getText().toString(),name.getText().toString(),sname.getText().toString(),marks.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_SHORT).show();
                }
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
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
        });

        update.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                boolean isInserted=db.insertData(id.getText().toString(),name.getText().toString(),sname.getText().toString(),marks.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(getApplicationContext(),"successfully updated",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"successfully not updated",Toast.LENGTH_SHORT).show();
                }
            }

        });

        delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Integer deletedRows=db.deleteData(id.getText().toString());
                if(deletedRows>0)
                {
                    Toast.makeText(getApplicationContext(),"successfully deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"your id not found",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void register(View view) {
    }

    public void home(View view) {
    }
}

