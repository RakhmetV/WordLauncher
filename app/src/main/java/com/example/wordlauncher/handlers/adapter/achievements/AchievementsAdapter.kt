package com.example.wordlauncher.handlers.adapter.achievements

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.SplashScreen
import com.example.wordlauncher.data.dataachievements.DataAchiv
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.firebase.User
import com.example.wordlauncher.databinding.AchievementsItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.ui.courses.userChange
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class AchievementsAdapter(
    var achivList: ArrayList<DataAchiv>
) : RecyclerView.Adapter<AchievementsAdapter.AchievementsHolder>() {
    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference

    class AchievementsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = AchievementsItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.achievements_item, parent, false)
        return AchievementsHolder(view)
    }


    override fun onBindViewHolder(holder: AchievementsHolder, position: Int) {
        holder.binding.imageView.setImageResource(achivList[position].imageAchivements)
        holder.binding.achivTxtName.text = achivList[position].nameAchievements
        holder.binding.achivTxtDescrip.text = achivList[position].descriptionAchievements
        if (userChange.achievements[position] > 0) {
            holder.binding.achivTxtCount.isVisible = false
            holder.binding.achivProgBar.isVisible = false
            holder.binding.btnAchivSend.isVisible = false
            holder.binding.achivRecev.isVisible = true
//            holder.binding.achivId.alpha = 0.7f

        } else {
            holder.binding.achivId.alpha = 0.7f
            holder.binding.achivTxtCount.text = achivList[position].AchievementsCount

        }
        when (position) {
            0 -> {
                //прохождение первого степа первой темы
                if (userChange.achievements[position]<0){
                    var max = 4
                    holder.binding.achivProgBar.max = max
                    holder.binding.achivTxtCount.text = "0/1"
                    var count = 0
                    for (i in userChange.progress[0][0]) {
                        if (i > 1) {
                            count++
                        }
                    }
                    checkBtn(holder, count, max, position)
                }


            }
            3 -> {
                //прохождение первого степа второй темы
                if (userChange.achievements[position]<0){

                    var max = 4
                    holder.binding.achivTxtCount.text = "0/1"
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[1][0]) {
                        if (i > 1) {
                            count++
                        }
                    }
                    checkBtn(holder, count, max, position)
                }

            }
            6 -> {
                //прохождение первого степа третей темы
                if (userChange.achievements[position]<0){

                    var max = 4
                    holder.binding.achivTxtCount.text = "0/1"
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[2][0]) {
                        if (i > 1) {
                            count++
                        }
                    }
                    checkBtn(holder, count, max, position)
                }

            }
            1 -> {
                //прохождение всех степов первой темы
                if (userChange.achievements[position]<0){

                    var max = 6
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[0]) {
                        if (i[3] > 1) {
                            count++
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/6"
                    checkBtn(holder, count, max, position)
                }
            }
            4 -> {
                //прохождение всех степов 2 темы
                if (userChange.achievements[position]<0){

                    var max = 9
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[1]) {
                        if (i[3] > 1) {
                            count++
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/9"
                    checkBtn(holder, count, max, position)
                }
            }
            7 -> {
                //прохождение всех степов 3 темы
                if (userChange.achievements[position]<0){

                    var max = 7
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[2]) {
                        if (i[3] > 1) {
                            count++
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/7"
                    checkBtn(holder, count, max, position)
                }
            }
            2 -> {
                //сбор всех кубков 1 темы
                if (userChange.achievements[position]<0){

                    var max = 72
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[0]) {
                        for (j in i) {
                            if (j > 0) {
                                count += j
                            }
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/72"
                    checkBtn(holder, count, max, position)
                }


            }
            5 -> {
                //сбор всех кубков 2 темы
                if (userChange.achievements[position]<0){

                    var max = 108
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[1]) {
                        for (j in i) {
                            if (j > 0) {
                                count += j
                            }
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/108"
                    checkBtn(holder, count, max, position)
                }

            }
            8 -> {
                //сбор всех кубков 3 темы
                if (userChange.achievements[position]<0){

                    var max = 84
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress[2]) {
                        for (j in i) {
                            if (j > 0) {
                                count += j
                            }
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/84"
                    checkBtn(holder, count, max, position)
                }

            }
            9 -> {
                //сбор всех кубков
                if (userChange.achievements[position]<0){

                    var max = 264
                    holder.binding.achivProgBar.max = max
                    var count = 0
                    for (i in userChange.progress) {
                        for (j in i) {
                            for (k in j) {
                                if (k > 0) count += k
                            }
                        }
                    }
                    holder.binding.achivProgBar.progress = count
                    holder.binding.achivTxtCount.text = "${count}/264"
                    checkBtn(holder, count, max, position)
                }

            }

        }
        holder.binding.btnAchivSend.setOnClickListener {
            userChange.achievements[position] = 1
            setDataFirebase(holder)
        }

    }

    fun checkBtn(holder: AchievementsHolder, count: Int, max: Int, position: Int) {
        if (count == max && userChange.achievements[position] < 0) {
            holder.binding.achivProgBar.isVisible = false
            holder.binding.achivTxtCount.isVisible = false
            holder.binding.btnAchivSend.isVisible = true
        }
    }

    private fun setDataFirebase(holder: AchievementsHolder) {
        mAuth = Firebase.auth
        var idUser = mAuth.uid
        mDataBase = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(idUser.toString())
        var newUser = userChange
        mDataBase.setValue(newUser)
        mDataBase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    holder.binding.btnAchivSend.isVisible = false

                } else {
                    Log.d("aaaa", "Ошибка")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("aaaa", "Соединение было прервано")
            }

        })
    }

    override fun getItemCount(): Int {
        return achivList.size
    }
}
