package com.example.usersphototest.utils

import com.example.usersphototest.data.ApiConstants
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Interactor {

    private val url = URL(ApiConstants.USERS_URL)
    private val connection = url.openConnection() as HttpsURLConnection

    fun getUsersFromApi(): List<String> {
        val pers = mutableListOf<String>()
        try {
            val br = BufferedReader(InputStreamReader(connection.inputStream))
            val lines = br.readLines()
            lines.forEach { line ->
                when {
                    line.contains("\"name\"") -> {
                        pers.add(line)
                    }
                }
            }
            lines.forEach { line ->
                when {
                    line.contains("     \"name\"") -> {
                        pers.remove(line)
                    }
                }
            }

            return pers.map {
                it.drop(13).dropLast(2)
            }

        } finally {
            connection.disconnect()
        }
    }
}