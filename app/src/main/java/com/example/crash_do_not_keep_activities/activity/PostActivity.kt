package com.example.crash_do_not_keep_activities.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.crash_do_not_keep_activities.R
import com.example.crash_do_not_keep_activities.databinding.ActivityPostBinding
import com.example.crash_do_not_keep_activities.fragment.PostFragment
import com.example.crash_do_not_keep_activities.fragment.SaleFragment

class PostActivity : AppCompatActivity(), PostFragment.Listener {

    private lateinit var binding: ActivityPostBinding

    private var currentFragment: PostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        currentFragment = SaleFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, currentFragment!!).commit()
    }

    override fun onSelectedCategory() {
        currentFragment?.updateFragment()
    }
}