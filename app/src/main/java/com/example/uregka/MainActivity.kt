package com.example.uregka

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        makeFollowList()
        makeNewsList()



    }

    private fun makeFollowList() {
        // 상단 팔로우 리스트 생성
        val style = R.layout.item_follow_list
        val followLayout = findViewById<LinearLayout>(R.id.ll_following_list)
        for (follow in UserData.userList.values) {
            val constraintLayout =
                layoutInflater.inflate(style, followLayout, false)

            follow.profileImg = "sample"
            val imageView = constraintLayout.findViewById<ImageView>(R.id.profile_image!!)
            val resourceId = resources.getIdentifier(follow.profileImg, "drawable",packageName)
            val textView = constraintLayout.findViewById<TextView>(R.id.profile_name!!)

            imageView.setImageResource(resourceId)
            textView.text = follow.userNickName

            followLayout.addView(constraintLayout)
        }
    }

    private fun makeNewsList() {
        // 뉴스 메인 피드 생성
        val style = R.layout.item_news_list
        val newsLayout = findViewById<LinearLayout>(R.id.ll_content)
        repeat(5) {
            val constraintLayout =
                layoutInflater.inflate(style, newsLayout, false)

            newsLayout.addView(constraintLayout)
        }
    }
}