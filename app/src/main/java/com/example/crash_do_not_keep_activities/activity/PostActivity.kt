package com.example.crash_do_not_keep_activities.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.crash_do_not_keep_activities.R
import com.example.crash_do_not_keep_activities.databinding.ActivityPostBinding
import com.example.crash_do_not_keep_activities.fragment.PostFragment
import com.example.crash_do_not_keep_activities.fragment.SaleFragment
import com.example.crash_do_not_keep_activities.viewmodel.PostActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity(), PostFragment.Listener {

    private lateinit var binding: ActivityPostBinding

    private val viewModel: PostActivityViewModel by viewModels()

    private var currentFragment: PostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        currentFragment = SaleFragment.newInstance()

        viewModel.createStart.observe(this) {
            Log.d("Tatsuya", "PostActiavity createStart: $it")
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainerView.id, currentFragment!!).commit()
        }

        viewModel.onLoad()
    }

    override fun onDestroy() {
        Log.d("Tatsuya", "PostActivity onDestroy: ")
        super.onDestroy()
    }

    override fun onSelectedCategory() {
        currentFragment?.updateFragment()
    }
}