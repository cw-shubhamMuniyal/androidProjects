package com.example.user.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class seeDoctorSchedule extends AppCompatActivity {

    EditText doctorsName;
    Button search;
    doctordetails display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_doctor_schedule);

        doctorsName = (EditText)findViewById(R.id.doctorNameEdit);
        search = (Button)findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                display.displayFromDBForScheduler("shubham");
                Intent intent = new Intent(getApplicationContext(),doctordetails.class);
                intent.putExtra("nameOfDoctor", doctorsName.getText().toString());
                startActivity(intent);
            }
        });

    }
}
