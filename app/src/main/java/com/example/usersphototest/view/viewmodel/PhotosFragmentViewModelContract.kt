package com.example.usersphototest.view.viewmodel

import androidx.lifecycle.LiveData
import com.example.usersphototest.data.userDTO.Photo

interface PhotosFragmentViewModelContract {
    val photosListLiveData: LiveData<List<Photo>>
}