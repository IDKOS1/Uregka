package com.example.uregka

import android.os.Bundle
import android.widget.ImageView
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
    }
}