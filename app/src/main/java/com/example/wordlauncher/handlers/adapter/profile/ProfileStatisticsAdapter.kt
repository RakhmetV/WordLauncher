package com.example.wordlauncher.handlers.adapter.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.databinding.StatisticsItemBinding

class ProfileStatisticsAdapter(var list: ArrayList<Int>) : RecyclerView.Adapter<ProfileStatisticsAdapter.ProfileStatisticsHolder>() {


    class ProfileStatisticsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = StatisticsItemBinding.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileStatisticsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.statistics_item, parent, false)
        return ProfileStatisticsHolder(view)
    }


    override fun onBindViewHolder(holder: ProfileStatisticsHolder, position: Int) {
        when (position) {
            0 -> {
                holder.binding.statisticsName.text = "Russian Federation"
                holder.binding.statisticsCount.text = "${list[position].toString()}/6"
            }
            1 -> {
                holder.binding.statisticsName.text = "Bashkortostan"
                holder.binding.statisticsCount.text = "${list[position].toString()}/9"
            }
            2 -> {
                holder.binding.statisticsName.text = "Introduction to Petroleum Industry"
                holder.binding.statisticsCount.text = "${list[position].toString()}/7"
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}