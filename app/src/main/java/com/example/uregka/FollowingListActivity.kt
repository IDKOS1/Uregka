package com.example.uregka

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FollowingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_following_list)


       /*
        var item = R.layout.following_list_item

        val ll_following = findViewById<LinearLayout>(R.id.ll_following_list)
        for (following in followingList) {
            val constraintLayout =
                layoutInflater.inflate(item, ll_following, false)

            val imageView = constraintLayout.findViewById<ImageView>(R.id.poster!!)
            val resourceId = resources.getIdentifier(following.imgSrc, "drawable",packageName)
            val textView = constraintLayout.findViewById<TextView>(R.id.title!!)

            imageView.setImageResource(resourceId)
            textView.text = following.title

            ll_following.addView(constraintLayout)
        }
        */
    }
}