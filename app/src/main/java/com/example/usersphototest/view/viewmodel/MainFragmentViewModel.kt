package com.example.usersphototest.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usersphototest.App
import com.example.usersphototest.data.userDTO.User
import java.util.concurrent.Executors

class MainFragmentViewModel : ViewModel(), MainFragmentViewModelContract {

    override val usersListLiveData = MutableLiveData<List<User>>()

    init {
        Executors.newSingleThreadExecutor().execute {
            usersListLiveData.postValue(App.instance.interactor.getUsersFromApi())
        }
    }
}