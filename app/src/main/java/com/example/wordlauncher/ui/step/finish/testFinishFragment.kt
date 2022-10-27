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
    lateinit var cup_one: ImageView
    lateinit var cup_two: ImageView
    lateinit var cup_three: ImageView
    lateinit var txt_time: TextView
    lateinit var txt_points: TextView
    lateinit var txt_marvelous: TextView

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
        txt_time.text = "My time: ${format.format(cal.time)}"
        var point = ((listSize!!).toDouble() / (listSize!! + mistake!!).toDouble()) * 100
        txt_points.text = "My points: ${point.toInt()}"
        if (point < 40) {
            cup_one.alpha = 0.3F
            cup_two.alpha = 0.3F
            cup_three.alpha = 0.3F
        } else if (point < 60) {
            points_user = 1
            cup_one.alpha = 1F
            cup_two.alpha = 0.3F
            cup_three.alpha = 0.3F
        } else if (point < 80) {
            points_user = 2
            cup_one.alpha = 1F
            cup_two.alpha = 0.3F
            cup_three.alpha = 1F
        } else points_user = 3

        val step_lvl_size = resources.getStringArray(R.array.step_level)
        if (levels == (step_lvl_size.size - 1)) {
            btn_next_lvl.text = "Finish"
        }else if ( userChange.progress[themPosition][stepPosition][levels!!] == 0 && points_user<2){
            btn_next_lvl.text = "Finish"
        }

        btn_next_lvl.setOnClickListener {
            if (userChange.progress[themPosition][stepPosition][levels!!] == 0 && points_user > 0) {
                if (levels == (step_lvl_size.size - 1)) {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user
                    if (themPosition != DataCourses.stepDataList(themPosition).size - 1 && points_user>1) {
                        userChange.progress[themPosition][stepPosition + 1][0] = 0
                    }
                } else {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user
                    if (points_user>1) userChange.progress[themPosition][stepPosition][levels!!+1] = 0
                }
            } else if (userChange.progress[themPosition][stepPosition][levels!!] < points_user) {
                userChange.progress[themPosition][stepPosition][levels!!] == points_user

                if (levels == (step_lvl_size.size - 1)) {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user

                    if (themPosition != DataCourses.stepDataList(themPosition).size - 1 && points_user>1 && userChange.progress[themPosition][stepPosition + 1][0] == -1) {
                        userChange.progress[themPosition][stepPosition + 1][0] = 0
                    }
                } else {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user
                    if (points_user>1) userChange.progress[themPosition][stepPosition][levels!!+1] = 0
                }
            }

            setDataInFirebase(view, levels, step_lvl_size.size, btn_next_lvl.text.toString())
        }

        btn_exit.setOnClickListener {
            if (userChange.progress[themPosition][stepPosition][levels!!] == 0 && points_user > 0) {
                if (levels == (step_lvl_size.size - 1)) {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user
                    if (themPosition != DataCourses.stepDataList(themPosition).size - 1 && points_user>1) {
                        userChange.progress[themPosition][stepPosition + 1][0] = 0
                    }
                } else {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user
                    if (points_user>1) userChange.progress[themPosition][stepPosition][levels!!+1] = 0
                }
            } else if (userChange.progress[themPosition][stepPosition][levels!!] < points_user) {
                userChange.progress[themPosition][stepPosition][levels!!] == points_user

                if (levels == (step_lvl_size.size - 1)) {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user

                    if (themPosition != DataCourses.stepDataList(themPosition).size - 1 && points_user>1 && userChange.progress[themPosition][stepPosition + 1][0] == -1) {
                        userChange.progress[themPosition][stepPosition + 1][0] = 0
                    }
                } else {
                    userChange.progress[themPosition][stepPosition][levels!!] = points_user
                    if (points_user>1) userChange.progress[themPosition][stepPosition][levels!!+1] = 0
                }
            }
            setDataInFirebase(view, -1, step_lvl_size.size, "1")
        }

        return view
    }

    fun init(view: View) {
        btn_exit = view.findViewById(R.id.test_finish_exit)
        btn_next_lvl = view.findViewById(R.id.test_finish_btn_next)
        cup_one = view.findViewById(R.id.test_finish_cup_one)
        cup_two = view.findViewById(R.id.test_finish_cup_two)
        cup_three = view.findViewById(R.id.test_finish_cup_three)
        txt_time = view.findViewById(R.id.test_finish_time)
        txt_points = view.findViewById(R.id.test_finish_points)
        txt_marvelous = view.findViewById(R.id.test_finish_marvelous)

    }

    fun setDataInFirebase(view: View, level: Int, step_size: Int, btn_txt: String) {
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
                    if (level == (step_size - 1)) {
                        Navigation.findNavController(view).navigate(R.id.stepLevelFragment)
                    } else if (btn_txt=="Finish"){
                        Navigation.findNavController(view).navigate(R.id.stepLevelFragment)
                    }else {
                        when (level) {
                            -1 -> Navigation.findNavController(view)
                                .navigate(R.id.stepLevelFragment)
                            1 -> Navigation.findNavController(view).navigate(R.id.stepThreeFragment)
                            2 -> Navigation.findNavController(view).navigate(R.id.stepFiveFragment)
                            3 -> Navigation.findNavController(view).navigate(R.id.stepLevelFragment)
                        }

                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Соединение было прервано.\nПовторите попытку.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    requireContext(),
                    "Соединение было прервано.\nПовторите попытку.",
                    Toast.LENGTH_SHORT
                ).show()
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