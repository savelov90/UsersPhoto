package com.example.usersphototest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usersphototest.R
import com.example.usersphototest.data.ApiConstants
import com.example.usersphototest.view.fragments.MainFragment
import com.example.usersphototest.view.fragments.PhotosFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

    fun launchPhotosFragment(id: String) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putString("id", id)
        //Кладем фрагмент с деталями в перменную
        val fragment = PhotosFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle


        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.listFragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}