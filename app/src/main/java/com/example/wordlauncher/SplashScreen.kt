package com.example.wordlauncher

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.datacourses.DataCourses
import com.example.wordlauncher.data.firebase.User
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.courses.CoursesAdapter
import com.example.wordlauncher.ui.courses.userChange
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.R
import java.util.*

class SplashScreen : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference
    lateinit var txt: TextView

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth= FirebaseAuth.getInstance()
        var cUser=mAuth.currentUser
        if(cUser!=null){
            val sharedPreference = getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE)
            var editor = sharedPreference.edit()
            editor.putInt("them_position", 0)

            getDataInFirebase()
        } else{
            intentRegistration()
        }


    }
    fun getDataInFirebase() {
        var mDataBaseTest: DatabaseReference
        mDataBaseTest = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(mAuth.uid.toString())
        mDataBaseTest.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user != null) {
                    //setDataProfile()

                    userChange =user
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {

                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    fun intentRegistration(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}