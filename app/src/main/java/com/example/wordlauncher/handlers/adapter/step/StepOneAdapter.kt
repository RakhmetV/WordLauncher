package com.example.wordlauncher.handlers.adapter.step

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.R
import com.example.wordlauncher.databinding.StepItemBinding
import com.example.wordlauncher.databinding.StepOneItemBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.step.StepWord
import com.example.wordlauncher.ui.courses.userChange
import kotlin.coroutines.coroutineContext

class StepOneAdapter(val stepListener: MyOnClickListener,
                     var listWord:ArrayList<StepWord>): RecyclerView.Adapter<StepOneAdapter.StepOneHolder>() {
    private val listener = stepListener

    class StepOneHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = StepOneItemBinding.bind(item)
        fun bind(position: Int, listener: MyOnClickListener) {
            binding.voice.setOnClickListener {
                listener.OnClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepOneHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_one_item, parent, false)
        return StepOneHolder(view)
    }


    override fun getItemCount(): Int {
        return listWord.size
    }

    override fun onBindViewHolder(holder: StepOneHolder, position: Int) {
        holder.binding.wordEn.text=listWord[position].word_en
        holder.binding.wordTranscription.text=listWord[position].word_transcription
        holder.binding.wordRu.text=listWord[position].word_ru
        if (listWord[position].word_en==""){
            holder.binding.voice.isVisible=false
        }
        holder.bind(position, listener)

    }
}