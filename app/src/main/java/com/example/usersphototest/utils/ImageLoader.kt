package com.example.usersphototest.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors


object ImageLoader {
    private val handler = Handler(Looper.getMainLooper())

    fun getBitmapFromURL(src: String?, callback: (bitmap: Bitmap?) -> Unit) {
        Executors.newSingleThreadExecutor().execute {
            val url = URL(src)
            (url.openConnection() as HttpURLConnection).apply {
                doInput = true
                connect()
                inputStream.use {
                    val bitmap = BitmapFactory.decodeStream(it)
                    handler.post { callback.invoke(bitmap) }
                }
            }
        }
    }
}
