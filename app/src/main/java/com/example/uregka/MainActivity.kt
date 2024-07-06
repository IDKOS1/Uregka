package com.example.uregka

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        makeFollowList()
        makeNewsList()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    showToast("현재 화면 입니다.")
                    true
                }
                R.id.reporter -> {
                    val intent = Intent(this, FollowingListActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.my_page -> {
                    val intent = Intent(this, MyPageActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> {
                    showToast("구현 예정")
                    true
                }
            }
        }
    }

    private fun makeFollowList() {
        // 상단 팔로우 리스트 생성
        val style = R.layout.item_follow_list
        val followLayout = findViewById<LinearLayout>(R.id.ll_following_list)
        for (follow in UserData.userList.values) {
            val constraintLayout =
                layoutInflater.inflate(style, followLayout, false)

            val layout = constraintLayout.findViewById<LinearLayout>(R.id.ll_profile)
            val imageView = constraintLayout.findViewById<ImageView>(R.id.profile_image!!)
            val resourceId = resources.getIdentifier(follow.profileImg, "drawable", packageName)
            val textView = constraintLayout.findViewById<TextView>(R.id.profile_name!!)

            imageView.setImageResource(resourceId)
            textView.text = follow.userNickName

            layout.setOnClickListener{
                val intent = Intent(this, MyPageActivity::class.java)
                startActivity(intent)
            }

            followLayout.addView(constraintLayout)
        }
    }

    private fun makeNewsList() {
        // 뉴스 메인 피드 생성
        val style = R.layout.item_news_list
        val newsLayout = findViewById<LinearLayout>(R.id.ll_content)

        for (article in ArticleList.articleList) {
            val layout =
                layoutInflater.inflate(style, newsLayout, false)

            // 기사 이미지 설정
            val imageView = layout.findViewById<ImageView>(R.id.iv_news_image)
            val resourceId = resources.getIdentifier(article.mainImg, "drawable", packageName)
            imageView.setImageResource(resourceId)

            // 기사 작성자 설정
            val writerText = layout.findViewById<TextView>(R.id.tv_writer_name)
            val writer = article.writerId
            writerText.text = writer

            // 기사 제목 설정
            val articleTitle = layout.findViewById<TextView>(R.id.tv_article_title)
            val title = article.title
            articleTitle.text = title

            // 기사 작성 일자 설정
            val writeDate = layout.findViewById<TextView>(R.id.tv_date)
            val date = article.writeDate
            writeDate.text = date

            // 클릭 리스너 설정
            val newsFeed = layout.findViewById<ConstraintLayout>(R.id.cl_news)
            newsFeed.setOnClickListener {
                Log.i("info", "리니어 클릭")
                val intent = Intent(this, DetailViewActivity::class.java)
                intent.putExtra("articleData", article)
                startActivity(intent)
            }

            newsLayout.addView(layout)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}





