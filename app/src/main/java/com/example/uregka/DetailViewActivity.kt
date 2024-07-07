package com.example.uregka

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_view)

        val article = intent.getParcelableExtra("articleData", Article::class.java)

        val mainImg = findViewById<ImageView>(R.id.img_main)
        val writerImg = findViewById<ImageView>(R.id.img_writer)
        val writer = findViewById<TextView>(R.id.tv_writer_name)
        val title = findViewById<TextView>(R.id.tv_title)
        val content = findViewById<TextView>(R.id.tv_content)
        val date = findViewById<TextView>(R.id.tv_date)
        val reporterButton = findViewById<LinearLayout>(R.id.reporter_layout)
        var isExpanded = false

        if (article != null) {
            val writerUser: User? = UserData.userList[article.writerId]
            if (writerUser != null) {
                val mainImgId = resources.getIdentifier(article.mainImg, "drawable", packageName)
                val writerImgId =
                    resources.getIdentifier(writerUser.profileImg, "drawable", packageName)

                mainImg.setImageResource(mainImgId)
                writerImg.setImageResource(writerImgId)
                writer.text = article.writerId
                title.text = article.title
                content.text = article.content
                date.text = article.writeDate
            }
        }

        val backBtn = findViewById<ImageView>(R.id.img_back)
        val showBtn = findViewById<TextView>(R.id.tv_more)

        backBtn.setOnClickListener {
            finish()
        }

        showBtn.setOnClickListener {
            isExpanded = !isExpanded
            if(isExpanded) {
                content.maxLines = Int.MAX_VALUE
                showBtn.text = "닫기"
            } else {
                content.maxLines = 3
                showBtn.text = "더보기"
            }
        }

        reporterButton.setOnClickListener{
            val intent = Intent(this, MyPageActivity::class.java)
            intent.putExtra("userName", article?.writerId)
            startActivity(intent)
            overridePendingTransition(
                R.drawable.animation_01,
                R.drawable.animation_02_none
            )
        }

    }
}