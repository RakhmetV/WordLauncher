package com.example.wordlauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.R
import java.util.*

class SplashScreen : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference
    lateinit var txt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth= FirebaseAuth.getInstance()
        var cUser=mAuth.currentUser
        if(cUser!=null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            /*val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            getDataFirebase(hour)
            val img = findViewById<ImageView>(R.id.imgView)
            img.animate().scaleX(1.0f).scaleY(1.0f).rotation(1080f).setDuration(5000).withEndAction(runnable)*/
        } else{
            intentRegistration()
        }


    }

    fun intentRegistration(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}