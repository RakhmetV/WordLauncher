package com.example.wordlauncher.ui.step

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wordlauncher.R


class StepLevelFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_step_level, container, false)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StepLevelFragment().apply {

            }
    }
}