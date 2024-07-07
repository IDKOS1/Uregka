package com.example.uregka

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.util.Pair


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        makeFollowList()
        makeNewsList()
        var loginId = ""
        if (intent.hasExtra("id")) {
            loginId = intent.getStringExtra("id")!!
        }


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    showToast(this, getString(R.string.current_screen))
                    true
                }

                R.id.reporter -> {
                    val intent = Intent(this, FollowingListActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(
                        R.drawable.animation_01,
                        R.drawable.animation_02_none
                    )
                    true
                }

                R.id.my_page -> {
                    val intent = Intent(this, MyPageActivity::class.java)
                    intent.putExtra("userName", loginId)
                    startActivity(intent)
                    overridePendingTransition(
                        R.drawable.animation_01,
                        R.drawable.animation_02_none
                    )
                    true
                }

                else -> {
                    showToast(this, getString(R.string.scheduled_for_implementation))
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

            val imageView = constraintLayout.findViewById<ImageView>(R.id.profile_image)
            val resourceId = resources.getIdentifier(follow.profileImg, "drawable", packageName)
            val textView = constraintLayout.findViewById<TextView>(R.id.profile_name)
            val followList = constraintLayout.findViewById<LinearLayout>(R.id.ll_follow_list)

            imageView.setImageResource(resourceId)
            textView.text = follow.userNickName

            followList.setOnClickListener {
                val intent = Intent(this, MyPageActivity::class.java)
                intent.putExtra("userData", follow)
                intent.putExtra("userName", textView.text)

                val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair(imageView, "profileTransition"),
                )
                startActivity(intent, options.toBundle())
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

            val writerImg = layout.findViewById<ImageView>(R.id.iv_writer_image)
            val writerImgRes = UserData.userList[writer]?.profileImg
            val writeImgId = resources.getIdentifier(writerImgRes, "drawable", packageName)
            writerImg.setImageResource(writeImgId)

            // 클릭 리스너 설정
            val newsFeed = layout.findViewById<ConstraintLayout>(R.id.cl_news)
            newsFeed.setOnClickListener {
                val intent = Intent(this, DetailViewActivity::class.java)
                intent.putExtra("articleData", article)

                val options: ActivityOptions =
                    ActivityOptions.makeSceneTransitionAnimation(
                        this,
                        Pair(imageView, "imageTransition"),
                        Pair(writerText, "textTransition")

                    )
                startActivity(intent, options.toBundle())
            }

            val cv_reporter = layout.findViewById<CardView>(R.id.cv_reporter)
            cv_reporter.setOnClickListener {
                val intent = Intent(this, MyPageActivity::class.java)
                intent.putExtra("userName", writer)
                startActivity(intent)
                overridePendingTransition(
                    R.drawable.animation_01,
                    R.drawable.animation_02_none
                )
            }

            newsLayout.addView(layout)
        }
    }


}





