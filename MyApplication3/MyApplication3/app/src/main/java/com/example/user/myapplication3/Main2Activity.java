package com.example.user.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Main2Activity extends AppCompatActivity {


    EditText usernameVar;
    EditText pwdEditVVar;
    Button submitButVar;
    DBPatient mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usernameVar = (EditText)findViewById(R.id.usernameEditT);
        pwdEditVVar = (EditText)findViewById(R.id.pwdEditV);
        submitButVar = (Button) findViewById(R.id.submitBut);
        mydb = new DBPatient(this);
        checkLogin();
    }

    public void checkLogin(){
        submitButVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {

               Cursor res = mydb.getBasedOnDBName(usernameVar.getText().toString());
               if(res.getCount() >= 0){
                   res.moveToFirst();
//                   Toast.makeText(getApplicationContext(),"haha "+res.getCount(),Toast.LENGTH_LONG).show();
//                   Log.d("Error","value:"+res.getString(1) );
                   while(res.moveToNext()){
                       String name = res.getString(1);
                       if(name.equals(usernameVar.getText().toString())){
                           Intent intent = new Intent(getApplicationContext(), seeDoctorSchedule.class);
                           startActivity(intent);
                       }
                   }

               }

            }
        });
    }
}
