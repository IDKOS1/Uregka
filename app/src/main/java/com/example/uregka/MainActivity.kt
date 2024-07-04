package com.example.uregka

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        makeFollowList()
        makeNewsList()

//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigationView.run {
//            setOnItemSelectedListener {
//                when (it.itemId) {
//                    R.id.home -> {
//                        startActivity(Intent(this, MainActivity:class.java))
//                        true
//                    }
//                    else -> false
//                }
//            }
//        }


    }

    private fun makeFollowList() {
        // 상단 팔로우 리스트 생성
        val style = R.layout.item_follow_list
        val followLayout = findViewById<LinearLayout>(R.id.ll_following_list)
        for (follow in UserData.userList.values) {
            val constraintLayout =
                layoutInflater.inflate(style, followLayout, false)

            val imageView = constraintLayout.findViewById<ImageView>(R.id.profile_image!!)
            val resourceId = resources.getIdentifier(follow.profileImg, "drawable", packageName)
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

        for(news in UserData.articleList) {
            val layout =
                layoutInflater.inflate(style, newsLayout, false)

            // 기사 이미지 설정
            val imageView = layout.findViewById<ImageView>(R.id.iv_news_image)
            val resourceId = resources.getIdentifier(news.articleImg, "drawable", packageName)
            imageView.setImageResource(resourceId)

            // 기사 작성자 설정
            val writerText = layout.findViewById<Button>(R.id.btn_name)
            val writer = news.writerNickName
            writerText.text = writer

            // 기사 제목 설정
            val articleTitle = layout.findViewById<TextView>(R.id.tv_article_title)
            val title = news.articleTitle
            articleTitle.text = title

            // 기사 작성 일자 설정
            val writeDate = layout.findViewById<TextView>(R.id.tv_date)
            val date = news.writeDate
            writeDate.text = date

            newsLayout.addView(layout)
        }
    }
}





