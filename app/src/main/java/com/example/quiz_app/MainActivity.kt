package com.example.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn: Button = findViewById<Button>(R.id.start)
        val et_name: EditText = findViewById(R.id.ACE_name)
        startbtn.setOnClickListener{
            if(et_name.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this@MainActivity, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.User_Name, et_name.text.toString() )
                startActivity(intent)
                finish()
            }
        }

    }
}