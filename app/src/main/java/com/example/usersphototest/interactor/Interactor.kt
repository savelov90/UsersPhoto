package com.example.usersphototest.interactor

import com.example.usersphototest.data.ApiConstants
import com.example.usersphototest.data.userDTO.Photo
import com.example.usersphototest.data.userDTO.User
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

private const val SEPARATOR = ""

class Interactor {
    val gson = Gson()
    private val url = URL(ApiConstants.USERS_URL)
    private val connection = url.openConnection() as HttpsURLConnection


    fun getUsersFromApi(): List<User> {
        BufferedReader(InputStreamReader(connection.inputStream)).use {
            val lines = it.readLines().joinToString(SEPARATOR)
            return gson.fromJson(lines, Array<User>::class.java).toList()
        }
    }

    fun getPhotosFromApi(id: String): List<Photo> {
        val photosUrl = URL(ApiConstants.PHOTOS_URL + id)
        val photoConnection = photosUrl.openConnection() as HttpsURLConnection
        BufferedReader(InputStreamReader(photoConnection.inputStream)).use {
            val lines = it.readLines().joinToString(SEPARATOR)
            return gson.fromJson(lines, Array<Photo>::class.java).toList()
        }
    }
}