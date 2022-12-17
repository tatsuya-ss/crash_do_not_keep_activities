package com.example.crash_do_not_keep_activities.fragment

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.crash_do_not_keep_activities.activity.PostSelectCategoryActivity
import com.example.crash_do_not_keep_activities.viewmodel.PostViewModel

abstract class PostFragment : Fragment() {

    abstract val viewModel: PostViewModel

    protected var listener: Listener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is Listener) {
            listener = context
        } else {
            throw IllegalArgumentException("ActivityがListenerを継承していません.")
        }
    }

    open fun observeLiveData() {
        viewModel.selectedCategory.observe(viewLifecycleOwner) {
            Log.d("Tatsuya", "PostFragment selectedCategory: $it")
            val intent = PostSelectCategoryActivity.createIntent(requireContext())
            startActivityForResult(intent, REQUEST_CODE_FOR_CATEGORY)
        }

        viewModel.updateCategory.observe(viewLifecycleOwner) {
            Log.d("Tatsuya", "PostFragment updateCategory: $it")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_FOR_CATEGORY -> {
                Log.d("Tatsuya", "onActivityResult: REQUEST_CODE_FOR_CATEGORY")
                listener?.onSelectedCategory()
            }
        }
    }

    fun updateFragment() {
        viewModel.onUpdateCategory()
    }

    interface Listener {
        fun onSelectedCategory()
    }

    companion object {
        private const val REQUEST_CODE_FOR_CATEGORY = 1
    }
}