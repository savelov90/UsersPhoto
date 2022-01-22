package com.example.usersphototest.view.recycler.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.usersphototest.R
import com.example.usersphototest.databinding.UserPhotoBinding
import com.example.usersphototest.utils.ImageLoader

class UserPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var userPhotoBinding = UserPhotoBinding.bind(itemView)

    //Привязываем view из layout к переменным
    var title = userPhotoBinding.title
    var photo = userPhotoBinding.picture


    //В этом методе кладем данные из String в наши view
    fun bind(ph: String) {
        //Устанавливаем заголовок
        title.text = ph
        photo.setImageResource(R.drawable.ic_launcher_foreground)
        val url = "https://icdn.lenta.ru/images/2021/04/27/16/20210427163138131/square_320_c09ebae17387b7d6eeb9fa0d42afe5ee.jpg"

        //прогресс бар
        ImageLoader.getBitmapFromURL(url) { bitmap ->
            bitmap?.let { photo.setImageBitmap(it) }

        }
    }
}