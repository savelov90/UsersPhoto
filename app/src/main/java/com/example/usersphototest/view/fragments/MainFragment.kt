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
import com.example.usersphototest.utils.Interactor


class MainFragment : ListFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    val catNames = arrayOf(
        "Рыжик", "Барсик", "Мурзик",
        "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
        "Кузя", "Китти", "Масяня", "Симба"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter: ListAdapter = ArrayAdapter<Any?>(
            requireActivity(),
            android.R.layout.simple_list_item_1, catNames
        )
        listAdapter = adapter

        val Int = Interactor()
        Int.getUsersFromApi()
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        Toast.makeText(requireActivity(), "Вы выбрали позицию: $position", Toast.LENGTH_SHORT).show()
    }
}