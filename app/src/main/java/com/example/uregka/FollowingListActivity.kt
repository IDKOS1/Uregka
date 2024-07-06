package com.example.uregka

import android.content.Intent
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

        val item = R.layout.item_card_list
        val ll_following = findViewById<LinearLayout>(R.id.ll_following_list)
        for (following in UserData.userList.values) {
            val layout =
                layoutInflater.inflate(item, ll_following, false)

            val imageView = layout.findViewById<ImageView>(R.id.img_profile)
            val resourceId = resources.getIdentifier(following.profileImg, "drawable",packageName)
            val name = layout.findViewById<TextView>(R.id.tv_name)
            val id = layout.findViewById<TextView>(R.id.tv_id)
            val intro = layout.findViewById<TextView>(R.id.tv_intro)

            imageView.setImageResource(resourceId)
            name.text = following.userNickName
            id.text = following.userId
            intro.text = following.userIntro


            ll_following.addView(layout)
        }

        val back = findViewById<ImageView>(R.id.img_back)
        back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}