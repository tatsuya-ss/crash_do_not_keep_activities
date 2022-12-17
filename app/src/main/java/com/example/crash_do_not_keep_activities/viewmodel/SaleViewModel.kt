package com.example.crash_do_not_keep_activities.viewmodel

import android.app.Application
import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SaleViewModel @Inject constructor(
    application: Application,
) : PostViewModel(application) {

    override fun onLoad() {
        super.onLoad()
        Log.d("Tatsuya exception", "SaleViewModel onLoad: ")
    }
}