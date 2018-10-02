package com.example.mypc.universitymanagement3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
    EditText editText1,editText2;
    TextView textView1,textView2;
    Button bu1;
    databasehelper db;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        editText1 = (EditText) findViewById(R.id.e1);
        editText2 = (EditText) findViewById(R.id.e2);
        textView1 = (TextView) findViewById(R.id.t1);
        textView2 = (TextView) findViewById(R.id.t2);
      /*  bu1=(Button)findViewById(R.id.b1);
                bu1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Cursor cursor = db.getAlldata();
                        if (cursor.getCount() == 0) {
                            return;
                        }
                        while(cursor.moveToNext())
                        {
                            if(cursor.getString(0).equals(editText1.getText().toString()) && cursor.getString(1).equals(editText2.getText().toString()))
                            {
                                //Toast.makeText(getApplicationContext(), "USER", Toast.LENGTH_SHORT).show();
                                flag=1;
                                //Toast.makeText(getApplicationContext(), ""+flag, Toast.LENGTH_SHORT).show();
                                break;
                            }
                            else if(editText1.getText().toString().equals("admin") && editText2.getText().toString().equals("password"))
                            {
                                //Toast.makeText(getApplicationContext(), "ADMIN", Toast.LENGTH_SHORT).show();
                                flag=2;
                                //Toast.makeText(getApplicationContext(), ""+flag, Toast.LENGTH_LONG).show();
                                break;
                            }
                        }

                    }

                });
        if(flag==1)
        {
            Intent i1 = new Intent(this, usertab.class);
            startActivity(i1);
        }
        else  if(flag==2)
        {
            Intent i1 = new Intent(this, admin2.class);
            startActivity(i1);
        }
        else
        {
            Toast.makeText(this, "Invalid user!!"+"\n"+" please enter correct detals!!", Toast.LENGTH_SHORT).show();
        }




    }*/
    }

    public void submitlogin(View view)
    {
        String msg=editText1.getText().toString();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        if(msg.equals("user"))
        {
            Intent i1 = new Intent(this, user2.class);
            startActivity(i1);
        }
        else if(editText1.getText().toString()=="hod")
        {
            Intent i1 = new Intent(this, hod.class);
            String data=editText1.getText().toString();
            i1.putExtra("sendData",data);
            startActivityForResult(i1,flag);
        }
        else if(editText1.getText().toString()=="instructor")
        {
            Intent i1 = new Intent(this, instructor.class);
            String data=editText1.getText().toString();
            i1.putExtra("sendData",data);
            startActivityForResult(i1,flag);
        }
        else if(editText1.getText().toString()=="secratary")
        {
            Intent i1 = new Intent(this, secratary.class);
            String data=editText1.getText().toString();
            i1.putExtra("sendData",data);
            startActivityForResult(i1,flag);
        }
        else
        {
            Toast.makeText(this, "User not exists", Toast.LENGTH_SHORT).show();
        }

    }
    public void onActivityResult(int requestCode,int responseCode,Intent dataIntent)

    {

        if(requestCode==flag)

        {

            String reply=dataIntent.getStringExtra("sendData");

            textView1.setText(reply);
            //
            textView2.setVisibility(View.VISIBLE);
            //
            textView1.setVisibility(View.VISIBLE);


        }

    }


   public void launch(View view) {
        String msg=editText1.getText().toString();
        String password=editText2.getText().toString();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if(msg.equals("user"))
        {
            Intent i1 = new Intent(this, usertab.class);
            startActivity(i1);
        }
        else if(msg.equals("hod"))
        {
            Intent i1=new Intent(this,hodtab.class);
            startActivity(i1);
        }
        else if(msg.equals("instructor"))
        {
            Intent i1 = new Intent(this, instructortab.class);
            startActivity(i1);
        }
        else if(msg.equals("secratary"))
        {
            Intent i1 = new Intent(this, secratary2.class);
            startActivity(i1);
        }
        else if((msg.equals("salvath")) && password.equals("admin"))
        {
            Intent i1 = new Intent(this, admin2.class);
            startActivity(i1);
        }
        else
        {
            Toast.makeText(this, "Invalid user!!"+"\n"+" please enter correct detals!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void register(View view)
    {
        Intent i1=new Intent(this,registration2.class);
        startActivity(i1);
    }

    public void registerlogin(View view)
    {
        Intent i1=new Intent(this,registration2.class);
        startActivity(i1);
    }
}
