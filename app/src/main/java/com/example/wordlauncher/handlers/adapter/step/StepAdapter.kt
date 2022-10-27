package com.example.wordlauncher.handlers.adapter.step

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.databinding.CoursesItemBinding
import com.example.wordlauncher.databinding.StepItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.courses.CoursesAdapter
import com.example.wordlauncher.handlers.step.StepItem
import com.example.wordlauncher.ui.courses.userChange
import java.util.ArrayList

class StepAdapter(
    val stepListener: MyOnClickListener,
    var themPosition: Int,
    var stepPosition: Int,
    var stepLevelList: Array<String>
) : RecyclerView.Adapter<StepAdapter.StepHolder>() {
    private val listener = stepListener

    class StepHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = StepItemBinding.bind(item)
        fun bind(position: Int, listener: MyOnClickListener) {
            binding.stepLvlId.setOnClickListener {
                listener.OnClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_item, parent, false)
        return StepHolder(view)
    }


    override fun onBindViewHolder(holder: StepHolder, position: Int) {
        holder.binding.steplevelname.text = stepLevelList[position]
        var passingStatus = userChange.progress[themPosition][stepPosition][position]
        when(position){
            0->holder.binding.stepleveldescrip.text="Learning new words"
            1->holder.binding.stepleveldescrip.text="Memory check"
            2->holder.binding.stepleveldescrip.text="Preparing for the test"
            3->holder.binding.stepleveldescrip.text="Step-by-step test"
        }
        if (passingStatus >= 0) {
            holder.binding.cupOne.isVisible = true
            holder.binding.cupTwo.isVisible = true
            holder.binding.cupThree.isVisible = true
            when (passingStatus) {
                1 -> holder.binding.cupThree.alpha = 1F
                2 -> {
                    holder.binding.cupThree.alpha = 1F
                    holder.binding.cupTwo.alpha = 1F
                }
                3 -> {
                    holder.binding.cupThree.alpha = 1F
                    holder.binding.cupTwo.alpha = 1F
                    holder.binding.cupOne.alpha = 1F
                }
            }

            holder.bind(position, listener)
        } else {
            holder.binding.stepLvlId.alpha = 0.6F
        }

    }

    override fun getItemCount(): Int {
        return stepLevelList.size
    }
}