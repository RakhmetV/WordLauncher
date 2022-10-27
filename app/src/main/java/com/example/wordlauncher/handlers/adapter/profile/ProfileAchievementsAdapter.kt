package com.example.wordlauncher.handlers.adapter.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.data.firebase.User
import com.example.wordlauncher.databinding.CoursesItemBinding
import com.example.wordlauncher.databinding.ProfileAchivementsItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.courses.CoursesAdapter
import com.example.wordlauncher.handlers.step.StepItem
import java.util.ArrayList

class ProfileAchievementsAdapter(
    var list: ArrayList<Int>
) : RecyclerView.Adapter<ProfileAchievementsAdapter.ProfileAchievementsHolder>() {

    class CoursesHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CoursesItemBinding.bind(item)
        fun bind(position: Int, listener: MyOnClickListener) {
            binding.stepId.setOnClickListener {
                listener.OnClick(position)
            }
        }
    }

    class ProfileAchievementsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ProfileAchivementsItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAchievementsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_achivements_item, parent, false)
        return ProfileAchievementsHolder(view)
    }


    override fun onBindViewHolder(holder: ProfileAchievementsHolder, position: Int) {
        holder.binding.profileAchivImage.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}