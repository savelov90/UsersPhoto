package com.example.usersphototest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usersphototest.App
import com.example.usersphototest.data.userDTO.User
import java.util.concurrent.Executors

class MainViewModel : ViewModel() {

    val usersListLiveData = MutableLiveData<List<String>>()

    init {
        Executors.newSingleThreadExecutor().execute {
            usersListLiveData.postValue(App.instance.interactor.getUsersFromApi())
        }
    }
}