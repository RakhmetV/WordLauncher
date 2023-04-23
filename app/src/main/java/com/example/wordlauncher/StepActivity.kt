package com.example.wordlauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog


var checkBackState=""
class StepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step)
    }

    override fun onBackPressed() {
        when(checkBackState) {
            "test" -> {
                AlertDialog.Builder(this).apply {
                    setTitle("Confirmation")
                    setMessage("All progress in this test will be lost.")

                    setPositiveButton("Exit") { _, _ ->
                        val intent = Intent(this@StepActivity,StepActivity::class.java)
                        startActivity(intent)
                    }

                    setNegativeButton("Cancel"){_, _ ->
                    }
                    setCancelable(true)
                }.create().show()
            }
            "testFinish" -> {
                val intent = Intent(this@StepActivity,StepActivity::class.java)
                startActivity(intent)
            }
            "start"->{
                val intent = Intent(this@StepActivity,MainActivity::class.java)
                startActivity(intent)
            }
            "" -> {
                super.onBackPressed()
            }
            else->{
                super.onBackPressed()
            }

        }

//        var count = supportFragmentManager.backStackEntryCount
//        if(count==1){
//            Log.d("aaaaaa","1")
//            super.onBackPressed();
//        }else{
//            Log.d("aaaaaa","2")
//            supportFragmentManager.popBackStack()
//        }
//        val intent = Intent(this@StepActivity,MainActivity::class.java)
//        startActivity(intent)

    }
}