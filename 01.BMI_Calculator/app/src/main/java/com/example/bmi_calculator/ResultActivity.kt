package com.example.bmi_calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.roundToInt

class ResultActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)
        Log.d("result","$height, $weight")

        val bmi = (weight/(height / 100.0).pow(2.0)*100).roundToInt() / 100f
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        // text함수는 String값을 받음
        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}