package com.example.wordlauncher.ui.login.registration

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.wordlauncher.R
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.firebase.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class RegistrationFragment : Fragment() {

    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var passwordRepeat: EditText
    lateinit var age: EditText
    lateinit var spinner: Spinner

    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference


    lateinit var sex: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        init(view)
        spinner_work()

        view.findViewById<Button>(R.id.registration_btn).setOnClickListener {
            if (TextUtils.isEmpty(name.text) ||
                TextUtils.isEmpty(email.text) ||
                TextUtils.isEmpty(password.text) ||
                TextUtils.isEmpty(passwordRepeat.text) ||
                TextUtils.isEmpty(age.text)
            ) {
                Toast.makeText(context, "Зполните пустые поля!", Toast.LENGTH_SHORT).show()
            } else if (password.text.length < 6) {
                Toast.makeText(context, "Зполните пустые поля!", Toast.LENGTH_SHORT).show()
            } else if (password.text.toString() != passwordRepeat.text.toString()) {
                Toast.makeText(context, "Повторите верный пароль!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(
                    email.text.toString(),
                    password.text.toString()
                )
                    .addOnCompleteListener(requireActivity(),
                        OnCompleteListener<AuthResult?> { task ->
                            if (task.isSuccessful) {
                                saveDataInFirebase(view)
                            } else {

                            }
                        })

            }

        }


        return view
    }

    fun init(view: View) {
        name = view.findViewById(R.id.registration_name)
        email = view.findViewById(R.id.registration_mail)
        password = view.findViewById(R.id.registration_password)
        passwordRepeat = view.findViewById(R.id.registration_password_repeat)
        age = view.findViewById(R.id.registration_age)
        spinner = view.findViewById(R.id.registration_spinner)
        mAuth = FirebaseAuth.getInstance()
    }

    fun spinner_work() {
        val typeSensor = resources.getStringArray(R.array.registration_spinner)
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, typeSensor)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                itemSelected: View, selectedItemPosition: Int, selectedId: Long
            ) {
                when (selectedItemPosition) {
                    0 -> sex = "Male"
                    1 -> sex = "Female"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        var defaultState = adapter.getPosition(typeSensor[0])
        if (defaultState == -1) {
            defaultState = 0
        }
        spinner.setSelection(defaultState, false)
    }


    fun saveDataInFirebase(view: View) {
        var idUser = mAuth.uid
        mDataBase = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(idUser.toString())
        Log.d("aaaaaaaaaa", idUser.toString())
        var newUser = User()
        mDataBase.setValue(newUser)
        mDataBase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    Navigation.findNavController(view).navigate(R.id.splashScreen)
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

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
            }
    }
}