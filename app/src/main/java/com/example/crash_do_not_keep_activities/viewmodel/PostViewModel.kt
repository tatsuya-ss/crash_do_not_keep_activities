package com.example.crash_do_not_keep_activities.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class PostViewModel internal constructor(
    application: Application,
) : AndroidViewModel(application) {
    private val _selectedCategory: MutableLiveData<String> = MutableLiveData()
    val selectedCategory = _selectedCategory

    private val _updateCategory: MutableLiveData<String> = MutableLiveData()
    val updateCategory = _updateCategory

    open fun onLoad() {
        Log.d("Tatsuya", "PostViewModel onLoad: ")
    }

    fun onSelectCategory() {
        _selectedCategory.value = "更新された"
    }

    fun onUpdateCategory() {
        _updateCategory.value = "売買"
    }
}