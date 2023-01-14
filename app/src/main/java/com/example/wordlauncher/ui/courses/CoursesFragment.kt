package com.example.wordlauncher.ui.courses

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordlauncher.ChoiceOfSubject
import com.example.wordlauncher.R
import com.example.wordlauncher.StepActivity
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.datacourses.DataCourses
import com.example.wordlauncher.data.firebase.User
import com.example.wordlauncher.data.profile.PuzzleData
import com.example.wordlauncher.databinding.FragmentCoursesBinding
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.courses.CoursesAdapter
import com.example.wordlauncher.handlers.header.HeaderForSpinner
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


lateinit var userChange: User
class CoursesFragment : Fragment() {


    private var _binding: FragmentCoursesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var puzzle: ImageView
    lateinit var flag: ImageView
    lateinit var name: TextView
    lateinit var description: TextView
    lateinit var pref: SharedPreferences
    lateinit var recycler: RecyclerView
    var themPosition=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val coursesViewModel =
            ViewModelProvider(this).get(CoursesViewModel::class.java)

        _binding = FragmentCoursesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sharedPreference =
            requireContext().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        themPosition = sharedPreference.getInt("them_position", 0)

        var editor = sharedPreference.edit()
        var stepLevelList = resources.getStringArray(R.array.step_level)



        init(root, themPosition)
        listener(root)
        getDataInFirebase(themPosition, editor, stepLevelList)
        return root
    }

    fun init(view: View, themPosition: Int) {
        puzzle = view.findViewById(R.id.header_puzzle)
        flag = view.findViewById(R.id.header_flag)
        name = view.findViewById(R.id.header_name)
        recycler = view.findViewById(R.id.courses_recycler)

        var headerClassList = DataCourses.headerClassList

        puzzle.setImageResource(R.drawable.puzzle)
        flag.setImageResource(headerClassList[themPosition].imageHeader)
        name.text = headerClassList[themPosition].nameHeader
    }

    fun listener(view: View) {
        flag.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.choiceOfSubject)
        }

        puzzle.setOnClickListener {
           val view1 = View.inflate(requireContext(), R.layout.custom_dialog_puzzle, null)
            val builder = AlertDialog.Builder(requireContext())
            builder.setView(view1)

            val dialog = builder.create()

            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            var listImg = PuzzleData.puzzleImgList(themPosition)
            var count = 0
            for (j in userChange.progress[themPosition]) {
                if (j[3] > 1) {
                    count++
                }
            }
            for (i in 0..count){
                when(i){
                    0->{
                        Log.d("aaaaaaaa","0")
                        //holder.binding.imgPuzzle1.setImageResource(listImg[i])
                    }
                    1->{
                        Log.d("aaaaaaaa","1")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle1)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    2->{
                        Log.d("aaaaaaaa","2")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle2)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    3->{
                        Log.d("aaaaaaaa","3")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle3)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    4->{
                        Log.d("aaaaaaaa","4")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle4)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    5->{
                        Log.d("aaaaaaaa","5")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle5)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    6->{
                        Log.d("aaaaaaaa","6")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle6)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    7->{
                        Log.d("aaaaaaaa","7")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle7)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    8->{
                        Log.d("aaaaaaaa","8")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle8)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                    9->{
                        Log.d("aaaaaaaa","9")
                        var a = view1.findViewById<ImageView>(R.id.custom_puzzle9)
                        a.isVisible=true
                        a.setImageResource(listImg[i-1])
                    }
                }
            }



        }
    }

    fun getDataInFirebase(themPosition: Int, editor: SharedPreferences.Editor,list: Array<String>) {
        var mAuth = FirebaseAuth.getInstance()
        var mDataBaseTest: DatabaseReference
        mDataBaseTest = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(mAuth.uid.toString())
        mDataBaseTest.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user != null) {
                    //setDataProfile()

                    userChange=user
                    recycler.layoutManager = LinearLayoutManager(context)
                    recycler.adapter = CoursesAdapter(object : MyOnClickListener {
                        override fun OnClick(position: Int) {
                            var intent = Intent(requireContext(), StepActivity::class.java)

                            editor.putInt("step_position", position)
                            editor.commit()
                            startActivity(intent)
                        }
                    }, user, themPosition, DataCourses.stepDataList(themPosition), list)
                } else {

                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}