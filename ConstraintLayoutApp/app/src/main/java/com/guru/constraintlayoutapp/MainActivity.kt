package com.guru.constraintlayoutapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var clickButton: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) { // main함수와 동일한 역할
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        clickButton = findViewById<Button>(R.id.clickButton)
        textView= findViewById<TextView>(R.id.textView)
        
        clickButton.setOnClickListener{
            textView.text = "버튼을 눌러주세요"
        }
    }
}