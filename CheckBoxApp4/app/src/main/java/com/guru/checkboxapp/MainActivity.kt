package com.guru.checkboxapp

import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var checkApple : CheckBox
    lateinit var checkOrange : CheckBox
    lateinit var checkBanana: CheckBox

    var listener = CompoundButton.OnCheckedChangeListener { buttonview, isChecked ->
        if(isChecked){
            when(buttonview.id){
                R.id.checkApple -> Toast.makeText(applicationContext, "사과", Toast.LENGTH_SHORT).show()
                R.id.checkOrange -> Toast.makeText(applicationContext, "오렌지", Toast.LENGTH_SHORT).show()
                R.id.checkBanana -> Toast.makeText(applicationContext, "바나나", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        checkApple = findViewById(R.id.checkApple)
        checkOrange = findViewById(R.id.checkOrange)
        checkBanana = findViewById(R.id.checkBanana)

        checkApple.setOnCheckedChangeListener(listener)
        checkOrange.setOnCheckedChangeListener(listener)
        checkBanana.setOnCheckedChangeListener(listener)

//        checkApple.setOnCheckedChangeListener{ buttonView, isChecked ->
//            if(isChecked){
//                Toast.makeText(applicationContext, "사과", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        checkOrange.setOnCheckedChangeListener { compoundButton, isChecked ->
//            if(isChecked){
//                Toast.makeText(applicationContext, "오렌지", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        checkBanana.setOnCheckedChangeListener { compoundButton, isChecked ->
//            if(isChecked){
//                Toast.makeText(applicationContext, "바나나", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}