package com.example.wordlauncher.ui.login.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.Navigation
import com.example.wordlauncher.R
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import org.w3c.dom.Text


class SignInFragment : Fragment() {
    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference
    lateinit var email: EditText
    lateinit var password: EditText

    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        init(view)
        view.findViewById<Button>(R.id.authorization_btn).setOnClickListener {
            if(TextUtils.isEmpty(email.text)|| TextUtils.isEmpty(password.text)){
                Toast.makeText(context,"Зполните пустые поля!", Toast.LENGTH_SHORT).show()
            }else{
                signIn(view)
            }
        }

        view.findViewById<TextView>(R.id.txt_registration).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.registrationFragment)
        }
        return view
    }

    fun init(view: View){
        email = view.findViewById(R.id.authorization_email)
        password = view.findViewById(R.id.authorization_password)
        mAuth= FirebaseAuth.getInstance()
        mAuth= FirebaseAuth.getInstance()
    }

    private  fun signIn(view: View){
        mAuth.signInWithEmailAndPassword(email.text.toString(),password.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Navigation.findNavController(view).navigate(R.id.mainActivity)
                } else {
                    Toast.makeText(context,"Данного аккаунта не существует",Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun getClient(){
//        var currentUser = mAuth.currentUser
//        oneTapClient = Identity.getSignInClient(requireContext())
//        signInRequest = BeginSignInRequest.builder()
//            .setGoogleIdTokenRequestOptions(
//                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
//                    .setSupported(true)
//                    // Your server's client ID, not your Android client ID.
//                    .setServerClientId(getString(R.string.your_web_client_id))
//                    // Only show accounts previously used to sign in.
//                    .setFilterByAuthorizedAccounts(true)
//                    .build())
//            .build()

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {

            }
    }
}