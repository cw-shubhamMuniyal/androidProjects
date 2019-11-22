package com.example.user.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Input extends AppCompatActivity {

    EditText cityName;
    Button subBut;
    String cityNameStr = "";
    private static final String TAG = "printCity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        subBut = findViewById(R.id.submitCityId);
        subBut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cityName = findViewById(R.id.cityId);
                cityNameStr = cityName.getText().toString();

                Log.i(TAG, cityNameStr);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("City name", cityNameStr);

                startActivity(intent);
            }
        });
    }
}
