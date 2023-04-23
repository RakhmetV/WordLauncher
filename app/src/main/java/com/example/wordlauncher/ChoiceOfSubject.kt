package com.example.wordlauncher

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.data.datacourses.DataCourses
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.ui.choiceofsubject.ChoiceAdapret



class ChoiceOfSubject : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var backBtn: ImageView
    lateinit var runnable: Runnable
    lateinit var txt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_of_subject)
        checkBackState="ChoiseOfSub"
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", MODE_PRIVATE)
        var editor = sharedPreference.edit()
        init()
        listener()

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ChoiceAdapret(
            object : MyOnClickListener {
                override fun OnClick(position: Int) {
                    editor.putInt("them_position", position)
                    editor.commit()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
            },
            DataCourses.headerClassList,
            sharedPreference.getInt("them_position", 0)
        )


    }

    fun init() {
        recycler = findViewById(R.id.choice_of_sub_recycler)
        backBtn = findViewById(R.id.choice_of_sub_back)
    }

    fun listener() {
        backBtn.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}