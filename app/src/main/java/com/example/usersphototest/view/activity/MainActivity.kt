package com.example.usersphototest.view.activity

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
        val bundle = Bundle()
        bundle.putString("id", id)
        val fragment = PhotosFragment()
        fragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.listFragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}