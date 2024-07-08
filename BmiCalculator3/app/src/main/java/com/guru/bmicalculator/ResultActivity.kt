package com.guru.bmicalculator

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    lateinit var resultTextView: TextView
    lateinit var imageView: ImageView
    lateinit var name : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        resultTextView = findViewById<TextView>(R.id.textView)
        imageView = findViewById<ImageView>(R.id.imageView)
//        name = findViewById<TextView>(R.id.nameEditText)

        var height = intent.getStringExtra("height")!!.toInt()
        var weight = intent.getStringExtra("weight")!!.toInt()

        var bmi = weight / Math.pow(height/100.0, 2.0)
        
        when{
            bmi >= 35 -> resultTextView.text = "고도 비만"
            bmi >= 30 -> resultTextView.text = "2단계 비만"
            bmi >= 25 -> resultTextView.text = "1단계 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }

        // 이미지 출력
        when {
            bmi >= 23 ->
                imageView.setImageResource(
                    R.drawable.baseline_sentiment_very_dissatisfied_24)
            bmi >= 18.5 ->
                imageView.setImageResource(
                    R.drawable.baseline_sentiment_satisfied_alt_24)
            else -> imageView.setImageResource(
                R.drawable.baseline_mood_bad_24)
        }

        Toast.makeText(this, "$name $bmi", Toast.LENGTH_SHORT).show()


    }
}