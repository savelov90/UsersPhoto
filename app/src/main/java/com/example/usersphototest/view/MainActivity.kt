package com.example.usersphototest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usersphototest.R
import com.example.usersphototest.data.ApiConstants
import com.example.usersphototest.view.fragments.MainFragment
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
}