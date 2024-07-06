package com.example.uregka

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FollowingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_following_list)

        val userList = UserData.userList.values.toList()

        val followingList = findViewById<RecyclerView>(R.id.rv_following_list)

        followingList.layoutManager = LinearLayoutManager(this)
        followingList.adapter = UserAdapter(this, userList)

        val back = findViewById<ImageView>(R.id.img_back)
        back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}