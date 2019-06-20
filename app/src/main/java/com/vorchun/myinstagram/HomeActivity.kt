package com.vorchun.myinstagram

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(0) {
    private val TAG = "HomeActivity"
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")

        // add temporary stub for firebase
        mAuth = FirebaseAuth.getInstance()
//        auth.signInWithEmailAndPassword("Vorchun87-07@mail.ru", "password")
//            .addOnCompleteListener {
//                if (it.isSuccessful){
//                    Log.d(TAG, "signIn: success")
//                } else {
//                    Log.d(TAG, "signIn: failure", it.exception)
//                }
//            }
        sign_out_text.setOnClickListener {
            mAuth.signOut()
        }
        mAuth.addAuthStateListener {
            if (it.currentUser == null) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (mAuth.currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
