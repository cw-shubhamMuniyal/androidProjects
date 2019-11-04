package com.example.user.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class askDoctor extends AppCompatActivity {

    DBDoctor database;
    EditText name,phoneNo,timings;
    TextView seeYourSchedule;
    Button doctorDetails,moreTimings;
    StringBuffer Timings = new StringBuffer();
    String textName;
//    ArrayList<String> Timings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_doctor);
        database = new DBDoctor(this);

        name = (EditText)findViewById(R.id.edt_userName);
        textName = name.getText().toString();
        phoneNo = (EditText)findViewById(R.id.edt_Phone);
        timings = (EditText)findViewById(R.id.edt_timings1);
        moreTimings = (Button)findViewById(R.id.moreTimings);
        doctorDetails = (Button)findViewById(R.id.btnLogin);
        seeYourSchedule = (TextView)findViewById(R.id.seeYourSchedule);

        AddData();
        doctorSchedulerPage();

        moreTimings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timings.getText().length()!=0){
                    Timings.append(timings.getText().toString());
                    Timings.append(',');
                    timings.setText("");
                }
            }
        });
    }

    public void doctorSchedulerPage(){
        seeYourSchedule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(askDoctor.this, seeDoctorSchedule.class);
//                intent.putExtra("nameOfDoctor",name.getText().toString());
                startActivity(intent);
            }
        });
    }

    public  void AddData() {
        doctorDetails.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = database.insertData(name.getText().toString(),
                                phoneNo.getText().toString(),
                                Timings.toString() );
//                        Toast.makeText(askDoctor.this,"ds"+name,Toast.LENGTH_LONG).show();
                        if(isInserted == true)
                            Toast.makeText(askDoctor.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(askDoctor.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(askDoctor.this, doctordetails.class);
                        intent.putExtra("nameOfDoctor",name.getText().toString());
                        startActivity(intent);
                    }
                }
        );
    }
}
