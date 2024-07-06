package com.example.uregka

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context, private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img_profile)
        val name: TextView = view.findViewById(R.id.tv_name)
        val id: TextView = view.findViewById(R.id.tv_id)
        val intro: TextView = view.findViewById(R.id.tv_intro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card_list, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        val resourceId = context.resources.getIdentifier(user.profileImg, "drawable", context.packageName)

        holder.imageView.setImageResource(resourceId)
        holder.name.text = user.userNickName
        holder.id.text = user.userId
        holder.intro.text = user.userIntro
    }

    override fun getItemCount() = userList.size
}
