package com.example.wordlauncher

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.wordlauncher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment)
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.mobile_navigation)
        //graph.addArgument("argument", NavArgument)
        if (checkBackState!="") graph.setStartDestination(R.id.navigation_courses)
        else graph.setStartDestination(R.id.navigation_profile)
        //or
        //graph.setStartDestination(R.id.fragment2)

        navHostFragment.navController.graph = graph

        val navView: BottomNavigationView = binding.navView
       // val navController = findNavController(R.id.nav_host_fragment_activity_main)
        //navView.setupWithNavController(navController)
        navView.setupWithNavController(  navHostFragment.navController)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Confirmation")
            setMessage("Are you sure, you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                val intent = Intent(this@MainActivity,EndActivity::class.java)
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