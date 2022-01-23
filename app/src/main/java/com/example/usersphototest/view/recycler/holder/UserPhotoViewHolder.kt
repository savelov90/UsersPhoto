package com.example.usersphototest.view.recycler.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.usersphototest.R
import com.example.usersphototest.data.userDTO.Photo
import com.example.usersphototest.databinding.UserPhotoBinding
import com.example.usersphototest.utils.ImageLoader

class UserPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var userPhotoBinding = UserPhotoBinding.bind(itemView)

    //Привязываем view из layout к переменным
    var title = userPhotoBinding.title
    var picture = userPhotoBinding.picture


    //В этом методе кладем данные из String в наши view
    fun bind(photo: Photo) {
        //Устанавливаем заголовок
        title.text = photo.title
        picture.setImageResource(R.drawable.white)
        val url = photo.url

        //прогресс бар
        ImageLoader.getBitmapFromURL(url) { bitmap ->
            bitmap?.let { picture.setImageBitmap(it) }

        }
    }
}