package com.example.crash_do_not_keep_activities.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class PostViewModel : ViewModel() {
    private val _selectedCategory: MutableLiveData<String> = MutableLiveData()
    val selectedCategory = _selectedCategory

    fun onSelectCategory() {
        _selectedCategory.value = "更新された"
    }
}