package com.example.usersphototest.view.recycler.holder

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.usersphototest.R
import com.example.usersphototest.data.userDTO.Photo
import com.example.usersphototest.databinding.UserPhotoBinding
import com.example.usersphototest.utils.ImageLoader

class UserPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var userPhotoBinding = UserPhotoBinding.bind(itemView)
    var title = userPhotoBinding.title
    var picture = userPhotoBinding.picture
    var progress = userPhotoBinding.progressBar

    fun bind(photo: Photo) {
        title.text = photo.title
        picture.setImageResource(R.drawable.white)
        val url = photo.url

        progress.isVisible = true
        ImageLoader.getBitmapFromURL(url) { bitmap ->
            bitmap?.let {
                picture.setImageBitmap(it)
                progress.isVisible = false
            }
        }
    }
}