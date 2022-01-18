package com.example.usersphototest

import android.app.Application
import com.example.usersphototest.utils.Interactor

class App : Application() {

    lateinit var interactor: Interactor

    override fun onCreate() {
        super.onCreate()
        instance = this
        interactor = Interactor()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}