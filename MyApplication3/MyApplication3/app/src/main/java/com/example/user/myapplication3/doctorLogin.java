package com.example.user.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class doctorLogin extends AppCompatActivity {

    EditText usernameEditTDoctor;
    EditText pwdEditVDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        Button loginDoctor = (Button)findViewById(R.id.submitButDoctor);
        loginDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameEditTDoctor = (EditText)findViewById(R.id.usernameEditTDoctor);
                pwdEditVDoctor = (EditText)findViewById(R.id.pwdEditVDoctor);
                if("shubham".equals(usernameEditTDoctor.getText().toString())&&("1614092").equals(pwdEditVDoctor.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), askDoctor.class);
                    startActivity(intent);
                }

            }
        });
    }
}
