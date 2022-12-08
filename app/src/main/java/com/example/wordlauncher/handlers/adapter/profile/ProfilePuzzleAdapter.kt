package com.example.wordlauncher.handlers.adapter.profile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.data.profile.PuzzleData.Companion.puzzleImgList
import com.example.wordlauncher.databinding.CoursesItemBinding
import com.example.wordlauncher.databinding.ProfileAchivementsItemBinding
import com.example.wordlauncher.databinding.PuzzleItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener

class ProfilePuzzleAdapter (
    var list: ArrayList<Int>,
    var checkList: ArrayList<Int>
) : RecyclerView.Adapter<ProfilePuzzleAdapter.ProfilePuzzleHolder>() {

    class CoursesHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CoursesItemBinding.bind(item)
        fun bind(position: Int, listener: MyOnClickListener) {
            binding.stepId.setOnClickListener {
                listener.OnClick(position)
            }
        }
    }

    class ProfilePuzzleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PuzzleItemBinding.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilePuzzleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.puzzle_item, parent, false)
        return ProfilePuzzleHolder(view)
    }


    override fun onBindViewHolder(holder: ProfilePuzzleHolder, position: Int) {
        var position1 = checkList[position]
        var listImg = puzzleImgList(position1)
        Log.d("aaaaaaaa",position1.toString())
        Log.d("aaaaaaaabbbbbbbbb",list[position].toString())
        when(position1){
            0-> holder.binding.puzzleName.text = "Russian Federation"
            1-> holder.binding.puzzleName.text = "Bashkortostan"
            2-> holder.binding.puzzleName.text = "Introduction to Petroleum Industry"
        }
        setImage(holder, list[position], listImg)
    }
    private fun setImage(holder: ProfilePuzzleHolder, count: Int, listImg: ArrayList<Int>){
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
    }
    override fun getItemCount(): Int {
        return list.size
    }
}