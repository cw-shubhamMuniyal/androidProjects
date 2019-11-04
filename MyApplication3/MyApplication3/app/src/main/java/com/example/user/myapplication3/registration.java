package com.example.user.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.widget.EditText;
import android.widget.TextView;

public class registration extends AppCompatActivity {

    Button register;
    TextView alreadyLogin;
    EditText edt_userNameVar;
    EditText edt_AgeVar;
    EditText edt_bloodGroupVar;
    EditText edt_passwordVar;
    DBPatient mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register = (Button)findViewById(R.id.btnLogin);
        edt_userNameVar = (EditText)findViewById(R.id.edt_userName);
        edt_AgeVar = (EditText)findViewById(R.id.edt_Age);
        edt_bloodGroupVar = (EditText)findViewById(R.id.edt_bloodGroup);
        edt_passwordVar = (EditText)findViewById(R.id.edt_password);
        mydb = new DBPatient(this);
        insertInDBPatient();



        alreadyLogin = (TextView)findViewById(R.id.alreadyLogin);
        alreadyLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(registration.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    public void insertInDBPatient(){

        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                boolean isInserted = mydb.insertData2(edt_userNameVar.getText().toString(), Integer.parseInt(edt_AgeVar.getText().toString()), edt_bloodGroupVar.getText().toString(), edt_passwordVar.getText().toString(),"null");
                if(isInserted == true)
                    Toast.makeText(registration.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else{
                    Toast.makeText(registration.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(registration.this, seeDoctorSchedule.class);
                startActivity(intent);
            }
        });


    }
}
