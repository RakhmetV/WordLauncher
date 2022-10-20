package com.example.wordlauncher.handlers.adapter.courses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.data.firebase.User
import com.example.wordlauncher.databinding.CoursesItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.step.StepItem
import java.util.*

class CoursesAdapter(
    val stepListener: MyOnClickListener,
    var user: User,
    var themPosition: Int,
    var stepItemList: ArrayList<StepItem>
) : RecyclerView.Adapter<CoursesAdapter.CoursesHolder>() {
    private val listener = stepListener

    class CoursesHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CoursesItemBinding.bind(item)
        fun bind(position: Int, listener: MyOnClickListener) {
            binding.stepId.setOnClickListener {
                listener.OnClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.courses_item, parent, false)
        return CoursesHolder(view)
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        if(user.progress[themPosition][position][0]>=0){
            holder.binding.progressBar.isVisible = true
            holder.binding.stepLock.isVisible = false
            holder.binding.progressBar.max = 6
            var k = 0
            for (i in user.progress[themPosition][position]) {
                if (i >= 2) k++
            }
            holder.binding.progressBar.progress = k
        }else {
            holder.binding.stepId.alpha=0.5F
            holder.binding.progressBar.isVisible = false
            holder.binding.stepId.isEnabled = false
            holder.binding.stepLock.isVisible = false
        }

        holder.binding.stepName.text = stepItemList[position].nameStep
        holder.binding.imageView3.setImageResource(stepItemList[position%3].imageStep)
        holder.bind(position, listener)
    }

    override fun getItemCount(): Int {
        return stepItemList.size
    }
}