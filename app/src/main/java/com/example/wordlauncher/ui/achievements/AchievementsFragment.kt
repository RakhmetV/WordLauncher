package com.example.wordlauncher.ui.achievements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.data.dataachievements.DataAchiv
import com.example.wordlauncher.data.dataachievements.ProfileAchievements
import com.example.wordlauncher.handlers.adapter.achievements.AchievementsAdapter


class AchievementsFragment : Fragment() {
    lateinit var recycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_achievements, container, false)
        recycler = view.findViewById(R.id.achivRecycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AchievementsAdapter(ProfileAchievements.dataAchiv)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AchievementsFragment().apply {
            }
    }
}