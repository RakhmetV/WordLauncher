package com.example.wordlauncher.ui.step.finish

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.wordlauncher.R
import com.example.wordlauncher.checkBackState
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.datacourses.DataCourses
import com.example.wordlauncher.ui.courses.userChange
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*


class testFinishFragment : Fragment() {
    lateinit var btn_exit: ImageView
    lateinit var btn_next_lvl: Button
    lateinit var txt_time: TextView
    lateinit var txt_points: TextView
    lateinit var txt_marvelous: TextView
    lateinit var txt_rating: TextView

    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference
    var points_user = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test_finish, container, false)
        checkBackState = "testFinish"
        val sharedPreference =
            requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var themPosition = sharedPreference.getInt("them_position", 1)

        var stepPosition = sharedPreference.getInt("step_position", 1)
        init(view)

        val levels = arguments?.getInt("levels", 0)
        val mistake = arguments?.getInt("mistake", 0)
        val startTime = arguments?.getLong("time", 0)
        val listSize = arguments?.getInt("list_size", 1)
        var countStar = 0
        val totalTime: Long = System.currentTimeMillis() - startTime!!
        val cal: Calendar = Calendar.getInstance()
        cal.setTimeInMillis(totalTime)
        val format = SimpleDateFormat("mm:ss.SSS")

        val phrases = resources.getStringArray(R.array.end_phrases)
        val random = (0..phrases.size - 1).random()
        txt_marvelous.text = phrases[random]
        txt_time.text = "${format.format(cal.time)}"
        var point = ((listSize!!).toDouble() / (listSize!! + mistake!!).toDouble()) * 100
        txt_points.text = "${point.toInt()}"

        if (point < 30) {
            txt_rating.text = "0"
            points_user = 0
        } else if (point < 60) {
            txt_rating.text = "1"
            points_user = 1
        } else if (point < 85) {
            txt_rating.text = "2"
            points_user = 2
        } else {
            txt_rating.text = "3"
            points_user = 3
        }

        val step_lvl_size = resources.getStringArray(R.array.step_level)

        if (levels == (step_lvl_size.size - 1)) {
            btn_next_lvl.text = "Finish"
        } else if ( points_user < 2) {
            btn_next_lvl.text = "Finish"
        }


        ///----------------------Проверка и заполнение тестов
        if (userChange.progress[themPosition][stepPosition][levels!!] == 0 && points_user > 0) {
            userChange.progress[themPosition][stepPosition][levels!!] = points_user
            if (levels == (step_lvl_size.size - 1)) {
                if (stepPosition != (DataCourses.stepDataList(themPosition).size - 1) && points_user > 1) {
                    userChange.progress[themPosition][stepPosition + 1][0] = 0
                }
            } else {

                if (points_user > 1) userChange.progress[themPosition][stepPosition][levels!! + 1] =
                    0
            }
        } else if (userChange.progress[themPosition][stepPosition][levels!!] < points_user) {
            userChange.progress[themPosition][stepPosition][levels!!] == points_user

            if (levels == (step_lvl_size.size - 1)) {

                if (stepPosition != (DataCourses.stepDataList(themPosition).size - 1) && points_user > 1) {
                    if ( userChange.progress[themPosition][stepPosition + 1][0] == -1){
                        userChange.progress[themPosition][stepPosition + 1][0] = 0
                    }
                }
            } else {
                if (points_user > 1) userChange.progress[themPosition][stepPosition][levels!! + 1] =
                    0
            }
        }
        ///----------------------Проверка и заполнение тестов завершение

        setDataInFirebase() //Запись в Firebase

        btn_next_lvl.setOnClickListener {
            if (btn_next_lvl.text.toString() != "Finish") {
                when (levels) {
                    1 -> Navigation.findNavController(view).navigate(R.id.stepThreeFragment)
                    2 -> Navigation.findNavController(view).navigate(R.id.stepFiveFragment)
                    3 -> Navigation.findNavController(view).navigate(R.id.stepLevelFragment)
                }
            } else {
                Navigation.findNavController(view)
                    .navigate(R.id.stepLevelFragment)
            }
            //setDataInFirebase(view, levels, step_lvl_size.size, btn_next_lvl.text.toString())
        }

        btn_exit.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.stepLevelFragment)
        }

        return view
    }

    fun init(view: View) {
        btn_exit = view.findViewById(R.id.test_finish_exit)
        btn_next_lvl = view.findViewById(R.id.test_finish_btn_next)
        txt_time = view.findViewById(R.id.test_finish_time)
        txt_points = view.findViewById(R.id.test_finish_points)
        txt_marvelous = view.findViewById(R.id.test_finish_marvelous)
        txt_rating = view.findViewById(R.id.test_finish_rating)

    }

    fun setDataInFirebase() {
        mAuth = FirebaseAuth.getInstance()
        var idUser = mAuth.uid
        mDataBase = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(idUser.toString())
        mDataBase.setValue(userChange)
        mDataBase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Соединение было прервано.\nПовторите попытку.",
                        Toast.LENGTH_SHORT
                    ).show()
                    btn_next_lvl.text = "Finish"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    requireContext(),
                    "Соединение было прервано.\nПовторите попытку.",
                    Toast.LENGTH_SHORT
                ).show()
                btn_next_lvl.text = "Finish"
            }

        })
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            testFinishFragment().apply {

            }
    }
}