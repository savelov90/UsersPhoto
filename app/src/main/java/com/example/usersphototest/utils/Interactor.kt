package com.example.usersphototest.utils

import com.example.usersphototest.data.ApiConstants
import com.example.usersphototest.data.userDTO.User
import com.example.usersphototest.data.userDTO.UsersHolder
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class Interactor {

    private val url = URL(ApiConstants.USERS_URL)
    private val connection = url.openConnection() as HttpsURLConnection

    private val ur = URL("https://jsonplaceholder.typicode.com/users/1")
    private val connection1 = ur.openConnection() as HttpsURLConnection

    val gson = Gson()

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

            val ar = BufferedReader(InputStreamReader(connection.getContent() as InputStream?))
/*            val user = gson.fromJson(br, UsersHolder::class.java)*/
            val lin = br.readLines()
            println(ar)

            return pers.map {
                it.drop(13).dropLast(2)
            }

        } finally {
            connection.disconnect()
        }
    }
}