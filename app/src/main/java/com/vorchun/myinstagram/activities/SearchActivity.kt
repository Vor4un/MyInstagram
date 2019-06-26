package com.vorchun.myinstagram.activities

import android.os.Bundle
import android.util.Log
import com.vorchun.myinstagram.R

class SearchActivity : BaseActivity(1) {
    private val TAG = "SearchActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")
    }
}
