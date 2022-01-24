package com.example.usersphototest.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersphototest.R
import com.example.usersphototest.data.userDTO.Photo
import com.example.usersphototest.view.recycler.holder.UserPhotoViewHolder

class UserPhotoAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //список элементов для RV
    private val items = mutableListOf<Photo>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserPhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_photo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserPhotoViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    fun addItems(list: List<Photo>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}