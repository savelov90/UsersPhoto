package com.example.usersphototest.view.viewmodel

import androidx.lifecycle.LiveData
import com.example.usersphototest.data.userDTO.User

interface MainFragmentViewModelContract {
    val usersListLiveData: LiveData<List<User>>
}