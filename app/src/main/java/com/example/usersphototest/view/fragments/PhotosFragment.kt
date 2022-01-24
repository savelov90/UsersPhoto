package com.example.usersphototest.view.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersphototest.data.userDTO.Photo
import com.example.usersphototest.databinding.PhotosFragmentBinding
import com.example.usersphototest.view.recycler.adapter.UserPhotoAdapter
import com.example.usersphototest.view.viewmodel.PhotosFragmentViewModel

class PhotosFragment : Fragment() {
    private lateinit var binding: PhotosFragmentBinding
    private lateinit var photoAdapter: UserPhotoAdapter
    private lateinit var userId: String
    private lateinit var viewModel: PhotosFragmentViewModel

    private var photosBase = listOf<Photo>()
        set(value) {
            if (field == value) return
            field = value
            photoAdapter.addItems(field)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PhotosFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[PhotosFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userId = arguments?.getString("id", "1").toString()
        initRecyckler()
        viewModel.getPhotosFromApi(userId)
        viewModel.photosListLiveData
            .observe(viewLifecycleOwner) {
                photosBase = it
                photoAdapter.addItems(it)
            }
    }

    private fun initRecyckler() {
        binding.mainRecycler.apply {
            photoAdapter = UserPhotoAdapter()
            adapter = photoAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}