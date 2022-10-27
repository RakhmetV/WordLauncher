package com.example.wordlauncher.ui.profile

import android.content.Intent
import android.graphics.Picture
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.LoginActivity
import com.example.wordlauncher.R
import com.example.wordlauncher.data.dataachievements.ProfileAchievements
import com.example.wordlauncher.handlers.adapter.achievements.AchievementsAdapter
import com.example.wordlauncher.handlers.adapter.profile.ProfileAchievementsAdapter
import com.example.wordlauncher.ui.courses.userChange
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import org.w3c.dom.Text


class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var auth: FirebaseAuth

    lateinit var profileImage: ImageView
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        auth = Firebase.auth
        init(view)


        var AchevList = arrayListOf<Int>() //массив для recycler достижений
        for (i in userChange.achievements.withIndex()){
            if (i.value>0){
                AchevList.add(ProfileAchievements.dataAchiv[i.index].imageAchivements)
            }
        }
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = ProfileAchievementsAdapter(AchevList)

        var count = 0
        for (i in userChange.progress[0]) {
            if (i[3] > 1) {
                count++
            }
        }
        view.findViewById<TextView>(R.id.profiletxtxstatrf).text = "Russian Federation: ${count}/6"
        count = 0
        for (i in userChange.progress[1]) {
            if (i[3] > 1) {
                count++
            }
        }
        view.findViewById<TextView>(R.id.profiletxtxstatrb).text = "Bashkortostan ${count}/9"
        count = 0
        for (i in userChange.progress[2]) {
            if (i[3] > 1) {
                count++
            }
        }
        view.findViewById<TextView>(R.id.profiletxtxstathy).text = "Hydrocarbons: ${count}/7"

        ProfileAchievements.dataAchiv
        return view
    }

    fun init(view: View){
        profileImage = view.findViewById(R.id.profileImage)
        Picasso.get().load(auth.currentUser?.photoUrl).into(profileImage)
        view.findViewById<TextView>(R.id.profileUserName).text=auth.currentUser?.displayName
        view.findViewById<TextView>(R.id.profileEmail).text=auth.currentUser?.email
        recycler = view.findViewById(R.id.profileRecycler)

        view.findViewById<ImageView>(R.id.signOutProfile).setOnClickListener {
            Firebase.auth.signOut()
            var intent = Intent(requireContext(),LoginActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {

            }
    }
}