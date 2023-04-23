package com.example.wordlauncher.ui.choiceofsubject

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.databinding.ChoiceItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.header.HeaderForSpinner

class ChoiceAdapret(
    var stepListener: MyOnClickListener,
    var themList: ArrayList<HeaderForSpinner>,
    var pos: Int
) : RecyclerView.Adapter<ChoiceAdapret.ChoiceHolder>() {
    private val listener = stepListener


    class ChoiceHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ChoiceItemBinding.bind(item)
        fun bind(position: Int, listener: MyOnClickListener) {
            binding.choiceId.setOnClickListener {
                listener.OnClick(position)
            }
            binding.buttonContinue.setOnClickListener {
                listener.OnClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.choice_item, parent, false)
        return ChoiceHolder(view)
    }

    override fun onBindViewHolder(holder: ChoiceHolder, position: Int) {
        holder.binding.choiceItemImage.setImageResource(themList[position].imageHeader)
        holder.binding.choiceItemName.text = themList[position].nameHeader
        holder.binding.choiceItemDescription.text = themList[position].descriptionHeader
        if (position == pos) {
            holder.binding.choiceItemCondition.text = "Выбранная тема"
            holder.binding.buttonContinue.isVisible=true
        } else{
            holder.binding.choiceId.alpha= 0.7F
        }
        holder.binding.choiceItemCondition.text=themList[position].countStep
        holder.bind(position,listener)


    }

    override fun getItemCount(): Int {
        return themList.size
    }

    /* override fun onBindViewHolder(holder: ChoiceHolder, position: Int) {

     }

     override fun getItemCount(): Int {
         return recyclerName.size
     }

     override fun onBindViewHolder(holder: ChoiceHolder, position: Int) {
         TODO("Not yet implemented")
     }*/
}