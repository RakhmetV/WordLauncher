package com.example.wordlauncher.ui.courses

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.wordlauncher.ChoiceOfSubject
import com.example.wordlauncher.R
import com.example.wordlauncher.data.datacourses.DataCourses
import com.example.wordlauncher.databinding.FragmentCoursesBinding
import com.example.wordlauncher.handlers.header.HeaderForSpinner

class CoursesFragment : Fragment() {



    private var _binding: FragmentCoursesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var puzzle: ImageView
    lateinit var flag: ImageView
    lateinit var name: TextView
    lateinit var description: TextView
    var position: Int = 0
    lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val coursesViewModel =
            ViewModelProvider(this).get(CoursesViewModel::class.java)

        _binding = FragmentCoursesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sharedPreference =  requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        position = sharedPreference.getInt("them_position",1)
        Log.d("aaaaaaaa", position.toString())
        init(root, coursesViewModel, position)
        listener(root)

        return root
    }

    fun init(view: View, c: CoursesViewModel, position: Int) {
        puzzle = view.findViewById(R.id.header_puzzle)
        flag = view.findViewById(R.id.header_flag)
        name = view.findViewById(R.id.header_name)
        description = view.findViewById(R.id.header_description)
        val textView: TextView = binding.textCourses
        c.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var headerClassList = DataCourses.headerClassList

        puzzle.setImageResource(R.drawable.puzzle)
        flag.setImageResource(headerClassList[position].imageHeader)
        name.text = headerClassList[position].nameHeader
        description.text = headerClassList[position].descriptionHeader
    }

    fun listener(view: View){
        flag.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.choiceOfSubject)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}