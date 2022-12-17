package com.example.crash_do_not_keep_activities.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostActivityViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application) {

    private val _createStart: MutableLiveData<String> = MutableLiveData()
    val createStart: LiveData<String> = _createStart

    fun onLoad() {
        _createStart.value = "スタート"
    }
}