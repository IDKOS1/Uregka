package com.example.uregka

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)

        val followButton = findViewById<TextView>(R.id.tv_follow)

        followButton.setOnClickListener {
            when (followButton.text) {
                "Follow" -> followButton.text = "Unfollow"
                "Unfollow" -> followButton.text = "Follow"
            }
        }

    }
}