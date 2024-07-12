package com.guru.musicserviceapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    lateinit var btnStart: Button
    lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        soundIntent = Intent(this, MusicService::class.java)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)

        btnStart.setOnClickListener {
            startService(soundIntent)
            Log.i("서비스 테스트", "startService()")
        }

        btnStop.setOnClickListener {
            stopService(soundIntent)
            Log.i("서비스 테스트", "stopService()")
        }
    }
}