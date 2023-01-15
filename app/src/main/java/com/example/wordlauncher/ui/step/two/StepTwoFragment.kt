package com.example.wordlauncher.ui.step.two

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.wordlauncher.R
import com.example.wordlauncher.StepActivity
import com.example.wordlauncher.checkBackState
import com.example.wordlauncher.data.datastep.WordForStep
import com.example.wordlauncher.handlers.step.StepWord
import kotlinx.coroutines.delay
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule
import kotlin.random.Random


class StepTwoFragment : Fragment() {
    var listWord = arrayListOf<String>()

    private var CurrentProgress = 0
    private var MaxProgress = 9
    lateinit var progressBar: ProgressBar

    lateinit var btn_anser_one: Button
    lateinit var btn_anser_two: Button
    lateinit var btn_next: Button
    lateinit var word_in: TextView
    lateinit var voice: ImageView
    lateinit var exit: ImageView
    var item = 0
    var mistake = 0
    var itemPast = -1
    var checkClick = false
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_step_two, container, false)
        checkBackState = "test"
        val startTime = System.currentTimeMillis()
        val sharedPreference =
            requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var themPosition = sharedPreference.getInt("them_position", 1)

        var stepPosition = sharedPreference.getInt("step_position", 1)
        init(view)
        var WordList = WordForStep.WordStepList(themPosition, stepPosition)
        for (list in WordList) {
            listWord.add(list.word_en + "/:" + list.word_ru)
        }
        listWord.shuffle()
        step_two_work(listWord)
        btn_anser_one.setOnClickListener {
            if (item < listWord.size && !checkClick) {
                val handler = android.os.Handler()
                checkClick = true
                if (btn_anser_one.text.toString() == listWord[item].split("/:")[1]) {
                    btn_anser_one.setBackgroundColor(Color.GREEN)
                    CurrentProgress++
                    progressBar.setProgress(CurrentProgress)
                } else {
                    mistake++
                    btn_anser_one.setBackgroundColor(Color.RED)

                    listWord.add(listWord[item])
                    listWord.removeAt(item)
                    item--
                }
                try {
                    handler.postDelayed({
                        if (item < (listWord.size - 1)) {
                            checkClick = false
                            item++
                            step_two_work(listWord)
                        }else{
                           // val endTime = System.currentTimeMillis()
                            btn_next.text="Finish"
                            val bundle = Bundle()
                            bundle.putInt("mistake",mistake)
                            bundle.putLong("time",startTime)
                            bundle.putInt("levels",1)
                            bundle.putInt("list_size",listWord.size)
                            Navigation.findNavController(view).navigate(R.id.testFinishFragment,bundle)

                        }

                    }, 500)
                }catch (e: Exception){
                    if (item < (listWord.size - 1)) {
                        checkClick = false
                        item++
                        step_two_work(listWord)
                    }else{
                       // val endTime = System.currentTimeMillis()
                        btn_next.text="Finish"
                        val bundle = Bundle()
                        bundle.putInt("mistake",mistake)
                        bundle.putLong("time",startTime)
                        bundle.putInt("levels",1)
                        bundle.putInt("list_size",listWord.size)
                        Navigation.findNavController(view).navigate(R.id.testFinishFragment,bundle)

                    }
                }


            }


        }

        btn_anser_two.setOnClickListener {
            if (item < listWord.size && !checkClick) {
                val handler = android.os.Handler()
                checkClick = true
                if (btn_anser_two.text.toString() == listWord[item].split("/:")[1]) {
                    btn_anser_two.setBackgroundColor(Color.GREEN)
                    CurrentProgress++
                    progressBar.setProgress(CurrentProgress)
                } else {
                    mistake++
                    btn_anser_two.setBackgroundColor(Color.RED)
                    listWord.add(listWord[item])
                    listWord.removeAt(item)
                    item--
                }
                try {
                    handler.postDelayed({
                        if (item < (listWord.size - 1)) {
                            checkClick = false
                            item++
                            step_two_work(listWord)
                        }else{
                            //val endTime = System.currentTimeMillis()
                            btn_next.text="Finish"
                            val bundle = Bundle()
                            bundle.putInt("mistake",mistake)
                            bundle.putLong("time",startTime)
                            bundle.putInt("levels",1)
                            bundle.putInt("list_size",listWord.size)
                            Navigation.findNavController(view).navigate(R.id.testFinishFragment,bundle)

                        }
                    }, 500)
                }catch (e: Exception){
                    if (item < (listWord.size - 1)) {
                        checkClick = false
                        item++
                        step_two_work(listWord)
                    }else{
                        //val endTime = System.currentTimeMillis()
                        btn_next.text="Finish"
                        val bundle = Bundle()
                        bundle.putInt("mistake",mistake)
                        bundle.putLong("time",startTime)
                        bundle.putInt("levels",1)
                        bundle.putInt("list_size",listWord.size)
                        Navigation.findNavController(view).navigate(R.id.testFinishFragment,bundle)

                    }
                }
            }






        }

        btn_next.setOnClickListener {
            if (item < (listWord.size - 1)) {
                checkClick = false
                item++
                step_two_work(listWord)
            }else{
                val endTime = System.currentTimeMillis()
                btn_next.text="Finish"
                val bundle = Bundle()
                bundle.putInt("mistake",mistake)
                bundle.putLong("time",startTime)
                bundle.putInt("levels",1)
                bundle.putInt("list_size",listWord.size)
                Navigation.findNavController(view).navigate(R.id.testFinishFragment,bundle)

            }
            btn_next.isVisible = false
        }

        exit.setOnClickListener {
            AlertDialog.Builder(requireContext()).apply {
                setTitle("Confirmation")
                setMessage("All progress in this test will be lost.")

                setPositiveButton("Exit") { _, _ ->
                    val intent = Intent(requireContext(), StepActivity::class.java)
                    startActivity(intent)
                }

                setNegativeButton("Cancel"){_, _ ->
                }
                setCancelable(true)
            }.create().show()
        }
        voice.setOnClickListener {
            try {
                for (i in WordList){
                    if (i.word_en == listWord[item].split("/:")[0]){

                        checkAudio(i.sound)
                        break
                    }
                }
            }catch (ex: Exception){

            }

        }

        return view
    }

    fun checkAudio(sound: Int): Boolean{
        mediaPlayer = MediaPlayer.create(requireContext(), sound)
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()
            // mediaPlayer.stop()
            mediaPlayer.seekTo(0)
            return false
        }
        mediaPlayer.start()
        return true
    }

    private fun step_two_work(list: ArrayList<String>) {
//        Log.d("aaaaaa", item.toString())
//        Log.d("aaaaaab", list.size.toString())
        btn_anser_one.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))
        btn_anser_two.setBackgroundColor(resources.getColor(R.color.color_step_answer_button))
        var listSplit = list[item].split("/:")
        word_in.text = listSplit[0]
        var rnd_btn = (0..1).random()
        var checkUslovie = true
        var rnd_word_for_btn = -1
        while (checkUslovie) {
            rnd_word_for_btn = (0..(list.size - 1)).random()
            if (rnd_word_for_btn != item && rnd_word_for_btn != itemPast) {
                if (item > 0 && rnd_word_for_btn != item - 1) {
//                    Log.d("aaaaaaaa1", rnd_word_for_btn.toString())
                    checkUslovie = false
                } else if (item == 0) {
//                    Log.d("aaaaaaaa2", rnd_word_for_btn.toString())
                    checkUslovie = false
                }
                if (item < list.size - 1){

                    checkUslovie = if (rnd_word_for_btn != item + 1) {
//                    Log.d("aaaaaaaa3", rnd_word_for_btn.toString())
                        false
                    } else rnd_word_for_btn == item + 1
                }
            }
        }
        itemPast = rnd_word_for_btn

        var listSplitTwo = list[rnd_word_for_btn].split("/:")
        when (rnd_btn) {
            0 -> {
                btn_anser_one.text = listSplit[1]
                btn_anser_two.text = listSplitTwo[1]
            }
            1 -> {
                btn_anser_two.text = listSplit[1]
                btn_anser_one.text = listSplitTwo[1]
            }
        }
    }

    private fun init(view: View) {
        btn_anser_one = view.findViewById(R.id.step_two_btn_answer)
        btn_anser_two = view.findViewById(R.id.step_two_btn_answer_two)
        btn_next = view.findViewById(R.id.step_two_btn_next)
        word_in = view.findViewById(R.id.step_two_word_en)
        voice = view.findViewById(R.id.step_two_voice)
        exit = view.findViewById(R.id.step_two_exit)
        progressBar = view.findViewById(R.id.step_two_progress_bar)
        progressBar.setProgress(CurrentProgress)
        progressBar.max = MaxProgress


    }
    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized){
            mediaPlayer.stop()
            mediaPlayer.release()

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StepTwoFragment().apply {

            }
    }
}