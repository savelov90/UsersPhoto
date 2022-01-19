package com.example.usersphototest.view.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import com.example.usersphototest.R
import com.example.usersphototest.viewmodel.MainViewModel
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.usersphototest.data.userDTO.User
import com.example.usersphototest.utils.Interactor
import com.example.usersphototest.view.MainActivity


class MainFragment : ListFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

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
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.usersListLiveData.observe(viewLifecycleOwner, {
            usersBase = it
        })

    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        var id = position + 1
        (requireActivity() as MainActivity).launchPhotosFragment(id.toString())
        Toast.makeText(requireActivity(), "Вы выбрали позицию: $id", Toast.LENGTH_SHORT)
            .show()
    }
}