package com.example.uregka

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_page)

        val profileImg = findViewById<ImageView>(R.id.iv_profile_image)
        val followButton = findViewById<TextView>(R.id.tv_follow)
        val id = findViewById<TextView>(R.id.tv_user_id)
        val nickName = findViewById<TextView>(R.id.tv_user_nickname)
        val follow = findViewById<TextView>(R.id.tv_user_followers)
        val intro = findViewById<TextView>(R.id.tv_user_intro)
        val email = findViewById<TextView>(R.id.tv_user_email)

        val userName = intent.getStringExtra("userName")

        val user = UserData.userList[userName]

        Log.d("user", user.toString())
        if (user != null) {
            if (userName.toString() in user.userId) {
                val resourceId = resources.getIdentifier(user.profileImg, "drawable", packageName)
                profileImg.setImageResource(resourceId)
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
                    followButton.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.wrong
                        )
                    )
                    followCount++
                    follow.text = followCount.toString()
                }

                "Unfollow" -> {
                    followButton.text = "Follow"
                    followButton.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.point
                        )
                    )
                    followCount--
                    follow.text = followCount.toString()
                }
            }
        }
    }
}