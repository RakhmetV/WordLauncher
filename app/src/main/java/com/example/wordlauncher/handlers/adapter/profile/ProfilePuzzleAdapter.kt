package com.example.wordlauncher.handlers.adapter.profile

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.data.profile.PuzzleData.Companion.puzzleImgList
import com.example.wordlauncher.databinding.CoursesItemBinding
import com.example.wordlauncher.databinding.ProfileAchivementsItemBinding
import com.example.wordlauncher.databinding.ProfilePuzzleBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.profile.puzzle.PuzzleAdapter

class ProfilePuzzleAdapter(
    var list: ArrayList<Int>
) : RecyclerView.Adapter<ProfilePuzzleAdapter.ProfilePuzzleHolder>() {


    class ProfilePuzzleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ProfilePuzzleBinding.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePuzzleHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.puzzle_item, parent, false)
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.profile_puzzle, parent, false)
        return ProfilePuzzleHolder(view)
    }


    override fun onBindViewHolder(holder: ProfilePuzzleHolder, position: Int) {
        var listImg = puzzleImgList(position)
        when (position) {
            0 -> {
                holder.binding.puzzleNameItem.text = "Russian Federation"

                holder.binding.profilePuzzleRecyclerItem.layoutManager =
                    GridLayoutManager(holder.binding.profilePuzzleRecyclerItem.context, 3)
                holder.binding.profilePuzzleRecyclerItem.adapter = PuzzleAdapter(list[position], listImg, 6)
            }
            1 -> {
                holder.binding.puzzleNameItem.text = "Bashkortostan"

                holder.binding.profilePuzzleRecyclerItem.layoutManager =
                    GridLayoutManager(holder.binding.profilePuzzleRecyclerItem.context, 3)
                holder.binding.profilePuzzleRecyclerItem.adapter = PuzzleAdapter(list[position], listImg, 9)
            }
            2 -> {
                holder.binding.puzzleNameItem.text = "Introduction to Petroleum Industry"

                holder.binding.profilePuzzleRecyclerItem.layoutManager =
                    GridLayoutManager(holder.binding.profilePuzzleRecyclerItem.context, 3)
                holder.binding.profilePuzzleRecyclerItem.adapter = PuzzleAdapter(list[position], listImg, 7)
            }
        }

        /* var position1 = checkList[position]
         var listImg = puzzleImgList(position1)
         Log.d("aaaaaaaa",position1.toString())
         Log.d("aaaaaaaabbbbbbbbb",list[position].toString())
         when(position1){
             0-> holder.binding.puzzleName.text = "Russian Federation"
             1-> holder.binding.puzzleName.text = "Bashkortostan"
             2-> holder.binding.puzzleName.text = "Introduction to Petroleum Industry"
         }
         setImage(holder, list[position], listImg)*/
    }

    override fun getItemCount(): Int {
        return list.size
    }
}