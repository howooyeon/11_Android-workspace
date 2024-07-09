package com.guru.stopwatch

import android.os.Bundle
import android.widget.Button
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

    lateinit var fab: FloatingActionButton
    lateinit var secTextView: TextView
    lateinit var milliTextView: TextView
    lateinit var labLayout: LinearLayout
    lateinit var labButton: Button
    lateinit var resetFab: FloatingActionButton // 수정된 부분

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab)
        secTextView = findViewById(R.id.secTextView)
        milliTextView = findViewById(R.id.milliTextView)
        labLayout = findViewById(R.id.labLayout)
        labButton = findViewById(R.id.labButton)
        resetFab = findViewById(R.id.resetFab) // 수정된 부분

        fab.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }

        labButton.setOnClickListener {
            recordLabTime()
        }

        resetFab.setOnClickListener {
            reset()
        }
    }

    private fun start() {
        fab.setImageResource(R.drawable.baseline_pause_24)

        timerTask = timer(period = 10) {
            time++
            val sec = time / 100
            val milli = time % 100
            runOnUiThread {
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

    private fun pause() {
        fab.setImageResource(R.drawable.baseline_play_arrow_24)
        timerTask?.cancel()
    }

    private fun recordLabTime() {
        val lapTime = this.time
        val textView = TextView(this)
        textView.text = "$lab LAB : ${lapTime / 100}.${lapTime % 100}"

        labLayout.addView(textView, 0)
        lab++
    }

    private fun reset() {
        timerTask?.cancel()
        time = 0
        isRunning = false
        fab.setImageResource(R.drawable.baseline_play_arrow_24)
        secTextView.text = "0"
        milliTextView.text = "00"

        labLayout.removeAllViews()
        lab = 1
    }
}
