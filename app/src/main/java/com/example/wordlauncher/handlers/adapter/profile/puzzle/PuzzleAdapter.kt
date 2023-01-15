package com.example.wordlauncher.handlers.adapter.profile.puzzle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.databinding.ProfilePuzzleItemBinding

class PuzzleAdapter(var listPosition: Int, var listImg: ArrayList<Int>) :
    RecyclerView.Adapter<PuzzleAdapter.PuzzleHolder>() {
    class PuzzleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ProfilePuzzleItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuzzleAdapter.PuzzleHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.profile_puzzle_item, parent, false)
        return PuzzleAdapter.PuzzleHolder(view)
    }

    override fun onBindViewHolder(holder: PuzzleAdapter.PuzzleHolder, position: Int) {
        if (position < listPosition) {
            holder.binding.puzzleItemImage.setImageResource(listImg[position])
        } else {

        }

    }

    override fun getItemCount(): Int {
        return listImg.size

    }
}