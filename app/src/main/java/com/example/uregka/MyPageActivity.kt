package com.example.uregka

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)

        val followButton = findViewById<TextView>(R.id.tv_follow)
        val id = findViewById<TextView>(R.id.tv_id_rename)
        val nickName = findViewById<TextView>(R.id.tv__nick_rename)
        val follow = findViewById<TextView>(R.id.tv_followers_renames)
        val intro = findViewById<TextView>(R.id.tv_intro_contents)
        val email = findViewById<TextView>(R.id.tv_email_rename)

        val user = intent.getParcelableExtra("userData", User::class.java)
        val userName = intent.getStringExtra("userName")

        if (user != null) {
            if (userName.toString() in user.userNickName) {
                id.text = user.userId
                nickName.text = user.userNickName
                follow.text = user.follower.toString()
                intro.text = user.userIntro
                email.text = user.userEmail
            }
        }


        followButton.setOnClickListener {

            var followCount = follow.text.toString().toInt()

            when (followButton.text) {
                "Follow" -> {
                    followButton.text = "Unfollow"
                    followButton.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.wrong))
                    followCount++
                    follow.text = followCount.toString()
                }
                "Unfollow" -> {
                    followButton.text = "Follow"
                    followButton.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.point))
                    followCount--
                    follow.text = followCount.toString()
                }
            }
        }

    }
}