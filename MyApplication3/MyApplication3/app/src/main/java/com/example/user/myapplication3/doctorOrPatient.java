package com.example.user.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class doctorOrPatient extends AppCompatActivity {

    Button btnrUDoctorVar;
    Button btnrUPatientVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_or_patient);

        btnrUDoctorVar = (Button)findViewById(R.id.btnrUDoctor);
        btnrUPatientVar = (Button)findViewById(R.id.btnrUPatient);

        btnrUDoctorVar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), doctorLogin.class);
                startActivity(intent);
            }
        });

        btnrUPatientVar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), registration.class);
                startActivity(intent);
            }
        });
    }
}
