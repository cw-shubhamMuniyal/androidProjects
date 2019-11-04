package com.example.user.myapplication3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class doctordetails extends AppCompatActivity implements View.OnClickListener{

    public  void toastMsg(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(),
                msg,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    private ProgressDialog progress;
    boolean selected =false;
    DBDoctor database;
    Button b1;
    TextView nameOfDoctor,phoneOfDoctor;
    TextView timingsOfDoctor;
    askDoctor search;
    Button clickedButton,myButton;
    int count = 0;int i;
    TableLayout myLayout;
    List<Button> buttons = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordetails);
        progress = new ProgressDialog(this);
        database = new DBDoctor(this);
        search = new askDoctor();

//        b1 = (Button)findViewById(R.id.selectBut);
        nameOfDoctor = (TextView)findViewById(R.id.nameOFDoctor);
        phoneOfDoctor = (TextView)findViewById(R.id.phoneOfDoctor);
        timingsOfDoctor = (TextView)findViewById(R.id.timingsOfDoctor);

//        b1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v){
//                //String buttonText = ;
//                if(b1.getText().toString() ==  "SELECT"){
//                    b1.setText("UNSELECT");
//                }
//                else{
//                    b1.setText("SELECT");
//                }
//                System.out.print("unselectiomn");
//            }
//        });

        displayFromDB();

        }

        public void displayFromDB(){
//            Cursor res = database.getAllData();
            Intent intent = getIntent();
            String nameOfDoctorFromIntent = intent.getStringExtra("nameOfDoctor");
//            String nameDoctorSeeScheduleIntent = intent.getStringExtra("nameDoctorSeeSchedule");

            Toast.makeText(doctordetails.this,"Data Inserted"+nameOfDoctorFromIntent,Toast.LENGTH_LONG).show();

            Cursor res = database.getDatabasedOnName(nameOfDoctorFromIntent);
            if(res.getCount()!=0){

                 myLayout = findViewById(R.id.addTimings);
                while (res.moveToNext()) {
                    nameOfDoctor.setText(res.getString(1));
                    phoneOfDoctor.setText(res.getString(2));
                    String[] timingsArray = {};
                    timingsArray = res.getString(3).split(",");
                    if(timingsArray.length == 1 && timingsArray[0].equals("")){
                    }
                    else{
//                        count = 0;
                        for(String timing : timingsArray){
                            myButton = new Button(this);
                            myButton.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            myButton.setText(timing);
                            myButton.setEnabled(true);
                            myButton.setClickable(true);
                            myButton.setId(count);
                            count = count+1;
                            myButton.setOnClickListener(this);


                            buttons.add(myButton);
//                            myButton.setTag((count++)+"c");


//                        myButton.setBackgroundColor(255);
//                        Toast.makeText(getApplicationContext(), "Button is enabled"+myButton.isEnabled(),Toast.LENGTH_LONG).show();

//                        TableLayout.LayoutParams buttonParams =
//                                new TableLayout.LayoutParams(
//                                        TableLayout.LayoutParams.WRAP_CONTENT,
//                                        TableLayout.LayoutParams.WRAP_CONTENT);

//                        buttonParams.addRule(TableLayout.CENTER_HORIZONTAL);
//                        buttonParams.addRule(TableLayout.CENTER_VERTICAL);
                            myLayout.addView(myButton);
                            // setContentView(myLayout);
                        }
                    }


                }
//                selectTimings();
            }
//            database.deleteCompleteDatabase(getApplicationContext());
    }

    @Override
    public void onClick(View v){
//        selected = false;
        for(i=0;i<buttons.size()&&!selected;i++){
            if(i==v.getId()){
                buttons.get(i).setBackgroundColor(Color.RED);
                selected = true;
            }
        }
//        switch(v.getId()){
//
//            case 3:
//                buttons.get(3).setBackgroundColor(Color.RED);
//                break;
//        }
    }

    public void selectTimings(){
        for( i=0;i<buttons.size();i++) {
            buttons.get(i).setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View v) {
                            int key = buttons.get(0).getId();
                            Toast.makeText(getApplicationContext(),"u clicked"+key,Toast.LENGTH_LONG).show();
//                            Log.d("key value", "pls" + key);
                            buttons.get(key).setBackgroundColor(Color.RED);
//                                        myButton.getId() == .setText("text now set.. ");
                        }
                    }
            );

        }

    }

    public void displayFromDBForScheduler(String nameOfDoctorFromIntent){
        Intent intent = getIntent();
//        String nameOfDoctorFromIntent = intent.getStringExtra("nameDoctorSeeSchedule");
        Cursor res = database.getDatabasedOnName(nameOfDoctorFromIntent);
        if(res.getCount()!=0){

            TableLayout myLayout = findViewById(R.id.addTimings);
            while (res.moveToNext()) {
                nameOfDoctor.setText(res.getString(1));
                phoneOfDoctor.setText(res.getString(2));
                String[] timingsArray = {};
                timingsArray = res.getString(3).split(",");
                if(timingsArray.length == 1 && timingsArray[0].equals("")){
                }
                else{
                    for(String timing : timingsArray){
                        Button myButton = new Button(this);
                        myButton.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        myButton.setText(timing);
                        myButton.setEnabled(true);
                        myButton.setClickable(true);
                        myLayout.addView(myButton);
                    }
                }


            }
        }
//            database.deleteCompleteDatabase(getApplicationContext());
    }


}
