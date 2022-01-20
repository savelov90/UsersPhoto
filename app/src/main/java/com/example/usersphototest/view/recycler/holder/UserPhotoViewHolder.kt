package com.example.usersphototest.view.recycler.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.usersphototest.R
import com.example.usersphototest.data.userDTO.Photo
import com.example.usersphototest.databinding.UserPhotoBinding

class UserPhotoViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var userPhotoBinding = UserPhotoBinding.bind(itemView)
    //Привязываем view из layout к переменным
    var title = userPhotoBinding.title
    var photo = userPhotoBinding.picture


    //В этом методе кладем данные из String в наши view
    fun bind(ph: String) {
        //Устанавливаем заголовок
        title.text = ph
        photo.setImageResource(R.drawable.ic_launcher_foreground)
    }

}