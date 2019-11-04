package com.example.user.myapplication3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class justForConversion extends AppCompatActivity {
    DBPatient mydb = new DBPatient(this);

    protected void onCreate(){
//        mydb = new DBPatient(this);
        Cursor res = mydb.getBasedOnDBName("shubham");
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(getApplicationContext(), "Error Nothing found", Toast.LENGTH_LONG).show();
            return;
        }

        String name = res.getString(1);
        String pwd = res.getString(4);
        if("shubham".equals(name)&&("1234").equals(pwd)){
            Intent intent = new Intent(getApplicationContext(), doctordetails.class);
            startActivity(intent);
        }
    }
}
