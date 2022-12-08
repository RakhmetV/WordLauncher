package com.example.wordlauncher.ui.step.one

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.wordlauncher.R
import com.example.wordlauncher.StepActivity
import com.example.wordlauncher.checkBackState
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.datastep.WordForStep
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.step.StepOneAdapter
import com.example.wordlauncher.handlers.step.StepWord
import com.example.wordlauncher.ui.courses.userChange
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.lang.Exception
import java.lang.reflect.Executable
import java.text.FieldPosition


class StepOneFragment : Fragment() {
    lateinit var recycler: RecyclerView
    lateinit var btn_next: Button
    lateinit var btn_exit: ImageView
    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference
    lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        checkBackState = ""
        val view = inflater.inflate(R.layout.fragment_step_one, container, false)
        val sharedPreference =
            requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var themPosition = sharedPreference.getInt("them_position", 1)
        var stepPosition = sharedPreference.getInt("step_position", 1)
        init(view)

        var WordList = WordForStep.WordStepList(themPosition, stepPosition)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = StepOneAdapter(object : MyOnClickListener {
            override fun OnClick(position: Int) {
                Log.d("aaaaaa", position.toString())
                try {
                    checkAudio(WordList, position)
                }catch (ex: Exception){

                }
            }
        }, WordList)
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                btn_next.isVisible = !recyclerView.canScrollVertically(1)
            }

        })

        btn_next.setOnClickListener {
            if (userChange.progress[themPosition][stepPosition][0] == 0) {
                userChange.progress[themPosition][stepPosition][0] = 3
                userChange.progress[themPosition][stepPosition][1] = 0
                setDataInFirebase(view)
            } else {
                Navigation.findNavController(view).navigate(R.id.stepTwoFragment)
            }

        }

        btn_exit.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
            //Navigation.findNavController(view).navigate(R.id.stepLevelFragment)
        }

        return view
    }

    fun checkAudio(list: ArrayList<StepWord>, position: Int): Boolean{
        mediaPlayer = MediaPlayer.create(requireContext(), list[position].sound)
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()
           // mediaPlayer.stop()
            mediaPlayer.seekTo(0)
            return false
        }
        mediaPlayer.start()
        return true
    }

    fun init(view: View) {
        recycler = view.findViewById(R.id.step_one_recycler)
        btn_next = view.findViewById(R.id.btn_next_level)
        btn_exit = view.findViewById(R.id.step_one_exit)

    }

    fun setDataInFirebase(view: View) {
        mAuth = FirebaseAuth.getInstance()
        var idUser = mAuth.uid
        mDataBase = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(idUser.toString())
        mDataBase.setValue(userChange)
        mDataBase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    Navigation.findNavController(view).navigate(R.id.stepTwoFragment)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Соединение было прервано.\nПовторите попытку.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    requireContext(),
                    "Соединение было прервано.\nПовторите попытку.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

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
            StepOneFragment().apply {
            }
    }
}

