package com.guru.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var resultButton : Button // 추후에 초기화 변수타입
    lateinit var heightEditText: EditText
    lateinit var weightEditText: EditText
    lateinit var name : TextView

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        resultButton = findViewById<Button>(R.id.resultButton)
        heightEditText = findViewById<EditText>(R.id.heightEditText)
        weightEditText = findViewById<EditText>(R.id.weightEditText)
        name = findViewById<TextView>(R.id.nameEditText)

        loadData()

        resultButton.setOnClickListener{
            saveData(name.text.toString(),
                    heightEditText.text.toString().toInt(),
                    weightEditText.text.toString().toInt())
            var intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("name", name.text.toString())
            intent.putExtra("height", heightEditText.text.toString())
            intent.putExtra("weight", weightEditText.text.toString())
            startActivity(intent)
        }
    }

    // 데이터를 저장하기 위해서
    private fun saveData(name: String, height: Int, weight: Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("KEY_HEIGHT", heightEditText.text.toString().toInt()).apply()
        editor.putInt("KEY_wIEGHT", weightEditText.text.toString().toInt()).apply()
    }

    private fun loadData(){
        var pref = this.getPreferences(0)
        var height = pref.getInt("KEY_HEIGHT", 0)
        var weight = pref.getInt("KEY_WEIGHT", 0)

        if(height != 0 && weight != 0){
            heightEditText.setText(height.toString())
            heightEditText.setText(weight.toString())
        }
    }

}