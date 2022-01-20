package com.example.usersphototest.view.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersphototest.R
import com.example.usersphototest.databinding.PhotosFragmentBinding
import com.example.usersphototest.view.recycler.adapter.UserPhotoAdapter
import com.example.usersphototest.viewmodel.MainViewModel
import com.example.usersphototest.viewmodel.PhotosViewModel

class PhotosFragment : Fragment() {

    private lateinit var binding: PhotosFragmentBinding
    private lateinit var photoAdapter: UserPhotoAdapter

    companion object {
        fun newInstance() = PhotosFragment()
    }

    private lateinit var viewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PhotosFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhotosViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyckler()
    }

    private fun initRecyckler() {
        //находим наш RV
        binding.mainRecycler.apply {
            //Инициализируем наш адаптер
            photoAdapter = UserPhotoAdapter()
            //Присваиваем адаптер
            adapter = photoAdapter
            //Присвоим layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}