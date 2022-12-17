package com.example.crash_do_not_keep_activities.fragment

import androidx.fragment.app.Fragment
import com.example.crash_do_not_keep_activities.viewmodel.PostViewModel

abstract class PostFragment: Fragment() {

    abstract val viewModel: PostViewModel
}