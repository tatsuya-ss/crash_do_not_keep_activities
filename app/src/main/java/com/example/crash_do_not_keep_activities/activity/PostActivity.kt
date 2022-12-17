package com.example.crash_do_not_keep_activities.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.crash_do_not_keep_activities.R
import com.example.crash_do_not_keep_activities.databinding.ActivityPostBinding
import com.example.crash_do_not_keep_activities.fragment.SaleFragment

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, SaleFragment.newInstance()).commit()
    }
}