package com.vorchun.myinstagram

import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : BaseActivity(0) {
    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")

        // add temporary stub for firebase
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword("Vorchun87-07@mail.ru", "password")
            .addOnCompleteListener{
                if (it.isSuccessful){
                    Log.d(TAG, "signIn: success")
                } else {
                    Log.d(TAG, "signIn: failure", it.exception)
                }
            }
    }
}
