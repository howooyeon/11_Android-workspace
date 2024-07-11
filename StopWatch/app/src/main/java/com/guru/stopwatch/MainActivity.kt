package com.guru.stopwatch

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var timerTask: Timer? = null
    private var isRunning = false
    private var lab = 1

    lateinit var secTextView: TextView
    lateinit var milliTextView: TextView
    lateinit var secEditText: EditText
    lateinit var setButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        secTextView = findViewById(R.id.secTextView)
        milliTextView = findViewById(R.id.milliTextView)
        secEditText = findViewById(R.id.secEditText)
        setButton = findViewById(R.id.setButton)

        setButton.setOnClickListener {
            time = secEditText.text.toString().toInt() * 100 // milli를 sec으로 바꾸기 위해 100을 곱함
            start()
        }
    }

    private fun start() {
//        fab.setImageResource(R.drawable.baseline_pause_24)

        timerTask = timer(period = 10) {
            time--
            val sec = time / 100
            val milli = time % 100

            if(sec == 0 && milli == 0) timerTask?.cancel()
            runOnUiThread {
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

    private fun pause() {
//        fab.setImageResource(R.drawable.baseline_play_arrow_24)
        timerTask?.cancel()
    }


    private fun reset() {
        timerTask?.cancel()
        time = 0
        isRunning = false
//        fab.setImageResource(R.drawable.baseline_play_arrow_24)
        secTextView.text = "0"
        milliTextView.text = "00"

//        labLayout.removeAllViews()
        lab = 1
    }
}
