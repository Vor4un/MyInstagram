package com.vorchun.myinstagram.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.vorchun.myinstagram.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.email_input

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "LoginActivity"
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "LoginActivity")
        login_btn.setOnClickListener(this)

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onClick(view: View) {
        val email = email_input.text.toString()
        val password = pass_input.text.toString()
        if (validate(email, password)) {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful) {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }
        } else {
            showToast("Please enter email and password")
        }
    }

    private fun validate(email:String, password:String) =
            email.isNotEmpty()&& password.isNotEmpty()
}
