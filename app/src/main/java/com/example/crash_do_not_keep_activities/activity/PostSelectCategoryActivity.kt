package com.example.crash_do_not_keep_activities.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.crash_do_not_keep_activities.R
import com.example.crash_do_not_keep_activities.databinding.ActivityPostSelectCategoryBinding

class PostSelectCategoryActivity: Activity() {
    private lateinit var binding: ActivityPostSelectCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_select_category)

        binding.button.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, PostSelectCategoryActivity::class.java)
        }
    }
}