package com.example.myapplication.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.Item

class HomeViewModel(val model: HomeModel) : ViewModel() {
    private var _items = MutableLiveData(mutableListOf<Item>())
    val items: LiveData<MutableList<Item>> = _items

    val database = listOf(
        Item(name = "O'tgan kunlar", description = "Fojiaviy sevgi qissasi"),
        Item(name = "Yulduzli tunlar", description = "Boburning qahramonliklari"),
        Item(name = "Harry Potter", description = "Jodugarlik va Sehrgarlik"),
        Item(name = "10 ta negr bolasi", description = "Sirli qotillik"),
    )

    init {
        if (model.isFirstRun()) addItems()
        getItems()
    }

    private fun getItems() {
        _items.value = model.getItems()
    }

    private fun addItems() {
        for (item in database) {
            model.addItem(item)
        }
    }
}