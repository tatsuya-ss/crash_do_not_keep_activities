package com.example.crash_do_not_keep_activities.fragment

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.crash_do_not_keep_activities.activity.PostSelectCategoryActivity
import com.example.crash_do_not_keep_activities.viewmodel.PostViewModel

abstract class PostFragment : Fragment() {

    abstract val viewModel: PostViewModel

    open fun observeLiveData() {
        viewModel.selectedCategory.observe(viewLifecycleOwner) {
            Log.d("Tatsuya", "PostFragment observeLiveData: $it")
            val intent = PostSelectCategoryActivity.createIntent(requireContext())
            startActivityForResult(intent, REQUEST_CODE_FOR_CATEGORY)
        }
    }

    companion object {
        private const val REQUEST_CODE_FOR_CATEGORY = 1
    }
}