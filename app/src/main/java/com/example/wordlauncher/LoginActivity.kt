package com.example.wordlauncher

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordlauncher.data.datacourses.ConstName
import com.example.wordlauncher.data.datacourses.DataCourses
import com.example.wordlauncher.data.firebase.User
import com.example.wordlauncher.handlers.MyOnClickListener
import com.example.wordlauncher.handlers.adapter.courses.CoursesAdapter
import com.example.wordlauncher.ui.courses.userChange
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var mDataBase: DatabaseReference
    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest


    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private var showOneTapUI = true

    lateinit var launcher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = Firebase.auth
        if (mAuth.currentUser==null){
            Log.d("aaaaaa", "не вошли")
        }else{
            Log.d("aaaaaa", "Вошли")
        }
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account!=null){
                    firebaseAuthWithGoogle(account.idToken!!)
                }
            }catch (e: ApiException){
                Log.d("aaaaaa", "Ошибка")
            }
        }
        findViewById<ImageView>(R.id.signGoogle).setOnClickListener {
            signInWithGoogle()
        }

    }

    private fun getClient():GoogleSignInClient{
        val gso = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(this, gso)
    }

    private fun signInWithGoogle(){
        val signInClient = getClient()
        launcher.launch(signInClient.signInIntent)
    }

    private fun firebaseAuthWithGoogle(IdToken: String){
        val credential = GoogleAuthProvider.getCredential(IdToken, null)
        mAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
               saveDataInFirebase()
            }else{
                Log.d("aaaaaa", "Не смогли войти")
            }
        }
    }

    fun saveDataInFirebase() {
        var idUser = mAuth.uid
        mDataBase = FirebaseDatabase
            .getInstance("https://word-launcher-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(ConstName().USER_NAME)
            .child(idUser.toString())
        var newUser = User()
        mDataBase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val user = snapshot.getValue(User::class.java)
                    if (user != null) {
                        //setDataProfile()
                        userChange =user
                    } else {
                        mDataBase.setValue(newUser)

                    }
                    val intent = Intent(applicationContext, SplashScreen::class.java)
                    startActivity(intent)
                } else if (snapshot.getValue(User::class.java)==null) {
                    mDataBase.setValue(newUser)
                    val intent = Intent(applicationContext, SplashScreen::class.java)
                    startActivity(intent)
                }else {
                    mDataBase.setValue(newUser)
                    Toast.makeText(
                        applicationContext,
                        "Соединение было прервано.\nПовторите попытку.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    applicationContext,
                    "Соединение было прервано.\nПовторите попытку.",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Confirmation")
            setMessage("Are you sure, you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                val intent = Intent(applicationContext,EndActivity::class.java)
                startActivity(intent)
                //super.onBackPressed()
            }

            setNegativeButton("No"){_, _ ->
                //Toast.makeText(this@MainActivity, "Thank you",
                //Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }


    override fun onStart() {
        super.onStart()
        var currentUser = mAuth.getCurrentUser()
    }
}