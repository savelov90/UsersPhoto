package com.example.usersphototest.utils

import com.example.usersphototest.data.ApiConstants
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class Interactor() {

    private val url = URL(ApiConstants.USERS_URL)
    private val connection = url.openConnection() as HttpsURLConnection

    fun getUsersFromApi() {

        Executors.newSingleThreadExecutor().execute {
            try {
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val line = br.readLines()
                println("!!! $line")
            } finally {
                connection.disconnect()
            }
        }
    }

}