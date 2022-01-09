package com.example.quiz_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_Name: TextView = findViewById(R.id.tv_name)
        val tv_Score: TextView = findViewById(R.id.tv_score)
        val btn_Submit: Button = findViewById(R.id.btn_finish)

        tv_Name.text = intent.getStringExtra(Constants.User_Name)

        val totalquestions = intent.getIntExtra(Constants.Total_questions, 0)
        val correctAnswers: Int = intent.getIntExtra(Constants.Correct_Answers, 0)

        tv_Score.text = "Your Score is $correctAnswers out of $totalquestions"

        btn_Submit.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}