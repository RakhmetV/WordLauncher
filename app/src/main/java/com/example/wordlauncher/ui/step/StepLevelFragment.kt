package com.example.wordlauncher.ui.step

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.EndActivity
import com.example.wordlauncher.MainActivity
import com.example.wordlauncher.R
import com.example.wordlauncher.checkBackState
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.courses.CoursesAdapter
import com.example.wordlauncher.handlers.adapter.step.StepAdapter


class StepLevelFragment : Fragment() {
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_step_level, container, false)
        checkBackState ="start"
        val sharedPreference =
            requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var themPosition = sharedPreference.getInt("them_position", 1)

        var stepPosition = sharedPreference.getInt("step_position", 1)

        init(view)


        var stepList = resources.getStringArray(R.array.step_level)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = StepAdapter(object : MyOnClickListener {
            override fun OnClick(position: Int) {

                when(position) {
                    0 -> {
                        Navigation.findNavController(view).navigate(R.id.stepOneFragment)
                    }
                    1 -> {
                        Navigation.findNavController(view).navigate(R.id.stepTwoFragment)
                    }
                    2 -> {
                        Navigation.findNavController(view).navigate(R.id.stepThreeFragment)
                    }
                    3 -> {
                        Navigation.findNavController(view).navigate(R.id.stepFiveFragment)
                    }
                    4 -> {
                        Navigation.findNavController(view).navigate(R.id.stepFiveFragment)
                    }
                }
            }
        },themPosition,stepPosition ,stepList)
        return view
    }


    fun init(view: View){
        recycler=view.findViewById(R.id.step_recycler)
        view.findViewById<ImageView>(R.id.step_level_back).setOnClickListener {
            var intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StepLevelFragment().apply {

            }
    }
}