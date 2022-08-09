package com.example.wordlauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Confirmation")
            setMessage("Are you sure, you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                val intent = Intent(applicationContext,EndActivity::class.java)
                startActivity(intent)
                //super.onBackPressed()
            }

            setNegativeButton("No"){_, _ ->
                //Toast.makeText(this@MainActivity, "Thank you",
                //Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }
}