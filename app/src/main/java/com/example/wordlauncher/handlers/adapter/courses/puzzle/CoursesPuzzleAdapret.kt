package com.example.wordlauncher.handlers.adapter.courses.puzzle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.databinding.CustomPuzzleItemBinding
import com.example.wordlauncher.databinding.ProfilePuzzleItemBinding
import com.example.wordlauncher.handlers.adapter.profile.puzzle.PuzzleAdapter

class CoursesPuzzleAdapret(var listPosition: Int, var fullCountCourses: Int, var listImg: ArrayList<Int>) :
    RecyclerView.Adapter<CoursesPuzzleAdapret.CoursesPuzzleHolder>() {


    class CoursesPuzzleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CustomPuzzleItemBinding.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoursesPuzzleAdapret.CoursesPuzzleHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_puzzle_item, parent, false)
        return CoursesPuzzleAdapret.CoursesPuzzleHolder(view)
    }


    override fun onBindViewHolder(holder: CoursesPuzzleHolder, position: Int) {
        if (position < listPosition) {
            holder.binding.customPuzzleItemImage.setImageResource(listImg[position])
        } else if (listPosition==fullCountCourses){
            holder.binding.customPuzzleItemImage.setImageResource(listImg[position])
        }
    }

    override fun getItemCount(): Int {
        return listImg.size

    }
}