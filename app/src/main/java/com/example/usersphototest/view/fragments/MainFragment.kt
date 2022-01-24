package com.example.usersphototest.view.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.ListFragment
import com.example.usersphototest.view.viewmodel.MainFragmentViewModel
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.map
import com.example.usersphototest.data.userDTO.User
import com.example.usersphototest.view.activity.MainActivity
import com.example.usersphototest.view.viewmodel.MainFragmentViewModelContract


class MainFragment : ListFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainFragmentViewModelContract

    private var usersBase = listOf<String>()
        //Используем backing field
        set(value) {
            //Если придет такое же значение то мы выходим из метода
            if (field == value) return
            //Если прило другое значение, то кладем его в переменную
            field = value
            val adapter: ListAdapter = ArrayAdapter<Any?>(
                requireActivity(),
                android.R.layout.simple_list_item_1, field
            )
            listAdapter = adapter
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.usersListLiveData.map { list ->
            val usersName = mutableListOf<String>()
            list.forEach {
                usersName.add(it.name)
            }
            usersName
        }.observe(viewLifecycleOwner) {
            usersBase = it
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val userId = position + 1
        (requireActivity() as MainActivity).launchPhotosFragment(userId.toString())
    }
}