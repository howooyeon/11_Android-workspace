package com.guru.hw02

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var button1: Button
    lateinit var editText1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView1 = findViewById<TextView>(R.id.textView1)
        button1 = findViewById<Button>(R.id.button1)
        editText1 = findViewById<EditText>(R.id.editText1)

        button1.setOnClickListener {
            textView1.text = editText1.text.toString()
            textView1.setTextColor(resources.getColor(R.color.some_color))
        }
    }
}