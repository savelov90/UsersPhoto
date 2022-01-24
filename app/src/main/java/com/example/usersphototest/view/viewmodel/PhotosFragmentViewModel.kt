package com.example.usersphototest.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usersphototest.App
import com.example.usersphototest.data.userDTO.Photo
import java.util.concurrent.Executors

class PhotosFragmentViewModel : ViewModel(), PhotosFragmentViewModelContract {
    override val photosListLiveData = MutableLiveData<List<Photo>>()

    fun getPhotosFromApi(id: String) {
        Executors.newSingleThreadExecutor().execute {
            photosListLiveData.postValue(App.instance.interactor.getPhotosFromApi(id))
        }
    }
}