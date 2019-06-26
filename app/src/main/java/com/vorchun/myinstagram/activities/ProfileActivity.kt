package com.vorchun.myinstagram.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.vorchun.myinstagram.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(4) {
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")

        profile_btn.setOnClickListener{
            val intent =  Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

    }
}
