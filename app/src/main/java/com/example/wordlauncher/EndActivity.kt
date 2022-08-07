package com.example.wordlauncher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)


        val runnable = object : Runnable {
            override fun run() {
                finishAffinity()
            }
        }

        val txtView = findViewById<TextView>(R.id.end_activity_txtView)
        val phrases = resources.getStringArray(R.array.end_activity_phrases)
        txtView.text = phrases[(0..phrases.size-1).random()]

        txtView.animate().scaleX(1.2f).scaleY(1.2f).setDuration(2000).withEndAction(runnable)
    }
}