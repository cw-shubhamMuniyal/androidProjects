package com.example.user.myapplication3

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    internal var mydb = DBPatient(this)

    fun toastMsg(msg: String) {
        val toast = Toast.makeText(applicationContext,
                msg,
                Toast.LENGTH_SHORT)
        toast.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
//        mydb = DBPatient(this)
        val password = findViewById<EditText>(R.id.pwdEditV)
        val username = findViewById<EditText>(R.id.usernameEditT)
        val b = findViewById(R.id.submitBut) as Button

//        b.setOnClickListener {
//            if (username.getText().toString() == "shubham" && password.getText().toString() == "1614092") {
//                val intent = Intent(this@MainActivity, selectdoctor::class.java)// or use getApplicationContext instead of mainActivity.class
//                startActivity(intent)
//            }
//        }

        b.setOnClickListener {
            val res = mydb.getBasedOnDBName("shubham")
            if (res.count == 0) {
                // show message
                Toast.makeText(applicationContext, "Error Nothing found", Toast.LENGTH_LONG).show()
            }

            val name = res.getString(1)
            val pwd = res.getString(4)
            if (username.getText().toString()== name && password.getText().toString() == pwd) {
                val intent = Intent(this@MainActivity, selectdoctor::class.java)// or use getApplicationContext instead of mainActivity.class
                startActivity(intent)
            }
        }

        // EditText username = findViewById(R.id.usernameEditT);
        username.setOnFocusChangeListener(View.OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                val user = v as EditText
                val usernameValue = user.text.toString()
                if (usernameValue == "") {
                    toastMsg("Please input user name")
                }
            }
        })


    }
}
