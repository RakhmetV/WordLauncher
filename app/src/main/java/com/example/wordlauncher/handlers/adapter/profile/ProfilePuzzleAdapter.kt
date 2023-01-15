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
    var list: ArrayList<Int>,
    var checkList: ArrayList<Int>
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
        var position1 = checkList[position]
        var listImg = puzzleImgList(position1)
        when (position1) {
            0 -> {
                holder.binding.puzzleNameItem.text = "Russian Federation"

                holder.binding.profilePuzzleRecyclerItem.layoutManager =
                    GridLayoutManager(holder.binding.profilePuzzleRecyclerItem.context, 3)
                holder.binding.profilePuzzleRecyclerItem.adapter = PuzzleAdapter(list[position], listImg)
            }
            1 -> {
                holder.binding.puzzleNameItem.text = "Bashkortostan"

                holder.binding.profilePuzzleRecyclerItem.layoutManager =
                    GridLayoutManager(holder.binding.profilePuzzleRecyclerItem.context, 3)
                holder.binding.profilePuzzleRecyclerItem.adapter = PuzzleAdapter(list[position], listImg)
            }
            2 -> {
                holder.binding.puzzleNameItem.text = "Introduction to Petroleum Industry"

                holder.binding.profilePuzzleRecyclerItem.layoutManager =
                    GridLayoutManager(holder.binding.profilePuzzleRecyclerItem.context, 3)
                holder.binding.profilePuzzleRecyclerItem.adapter = PuzzleAdapter(list[position], listImg)
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

    /* private fun setImage(holder: ProfilePuzzleHolder, count: Int, listImg: ArrayList<Int>){
         for (i in 0..count){
             when(i){
                 0->{
                     Log.d("aaaaaaaa","0")
                     //holder.binding.imgPuzzle1.setImageResource(listImg[i])
                 }
                 1->{
                     Log.d("aaaaaaaa","1")
                     holder.binding.imgPuzzle1.isVisible=true
                     holder.binding.imgPuzzle1.setImageResource(listImg[i-1])
                 }
                 2->{
                     Log.d("aaaaaaaa","2")
                     holder.binding.imgPuzzle2.isVisible=true
                     holder.binding.imgPuzzle2.setImageResource(listImg[i-1])
                 }
                 3->{
                     Log.d("aaaaaaaa","3")
                     holder.binding.imgPuzzle3.isVisible=true

                     holder.binding.imgPuzzle3.setImageResource(listImg[i-1])
                 }
                 4->{
                     Log.d("aaaaaaaa","4")
                     holder.binding.imgPuzzle4.isVisible=true
                     holder.binding.imgPuzzle4.setImageResource(listImg[i-1])
                 }
                 5->{
                     Log.d("aaaaaaaa","5")
                     holder.binding.imgPuzzle5.isVisible=true
                     holder.binding.imgPuzzle5.setImageResource(listImg[i-1])
                 }
                 6->{
                     Log.d("aaaaaaaa","6")
                     holder.binding.imgPuzzle6.isVisible=true
                     holder.binding.imgPuzzle6.setImageResource(listImg[i-1])
                 }
                 7->{
                     Log.d("aaaaaaaa","7")
                     holder.binding.imgPuzzle7.isVisible=true
                     holder.binding.imgPuzzle7.setImageResource(listImg[i-1])
                 }
                 8->{
                     Log.d("aaaaaaaa","8")
                     holder.binding.imgPuzzle8.isVisible=true

                     holder.binding.imgPuzzle8.setImageResource(listImg[i-1])
                 }
                 9->{
                     Log.d("aaaaaaaa","9")
                     holder.binding.imgPuzzle9.isVisible=true
                     holder.binding.imgPuzzle9.setImageResource(listImg[i])
                 }
             }
         }
     }*/
    override fun getItemCount(): Int {
        return checkList.size
    }
}