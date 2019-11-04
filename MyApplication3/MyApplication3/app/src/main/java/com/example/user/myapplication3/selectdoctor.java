package com.example.user.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class selectdoctor extends AppCompatActivity {

    void toastMsg(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(),
                msg,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectdoctor);

        final Button detailsDoctor1 = (Button)findViewById(R.id.detailsDoctor1);
        final Button detailsDoctor2 = (Button)findViewById(R.id.detailsDoctor2);
        registerForContextMenu(detailsDoctor2);//It is important for context menu to work

        detailsDoctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("long clicked","pos: ");

                Intent intent = new Intent(selectdoctor.this, doctordetails.class);// or use getApplicationContext instead of mainActivity.class
                startActivity(intent);
                //String dd = new String('this');
                //doctordetails.setText(data.getStringExtra("text"));
            }
        });

        detailsDoctor1.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener(){
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
                menu.setHeaderTitle("Selcrtion");
                MenuItem Selected = menu.add(1, 1, 1, "select doctor");
                Selected.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        toastMsg("Doctor Selected");
                        return false;
                    }
                });

                menu.add("unselect doctor");
            }


//            public boolean onContextItemSelected(MenuItem item){
//                switch(item.getItemId()){
//                    case 1:Log.v(" clicked","click on menu item");
//                            toastMsg("Doctor Selected");
//                            break;
//                }
//                return true;
//            } //not working with switch case
        });



        detailsDoctor2.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(selectdoctor.this, doctordetails.class);
               startActivity(intent);
           }
        });

        detailsDoctor2.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("Selction");
                menu.add("select doctor");
                menu.add("unselect doctor");
            }
        });
    }

}
