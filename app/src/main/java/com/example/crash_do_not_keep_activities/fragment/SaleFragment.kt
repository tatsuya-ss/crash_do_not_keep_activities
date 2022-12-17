package com.example.crash_do_not_keep_activities.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.crash_do_not_keep_activities.R
import com.example.crash_do_not_keep_activities.activity.PostSelectCategoryActivity
import com.example.crash_do_not_keep_activities.databinding.FragmentSaleBinding
import com.example.crash_do_not_keep_activities.viewmodel.SaleViewModel

class SaleFragment : PostFragment() {

    private lateinit var binding: FragmentSaleBinding

    override val viewModel: SaleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sale, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            viewModel.onSelectCategory()
        }

        observeLiveData()
    }

    override fun observeLiveData() {
        super.observeLiveData()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_CODE_FOR_CATEGORY -> {
                Log.d("Tatsuya", "onActivityResult: REQUEST_CODE_FOR_CATEGORY")
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_FOR_CATEGORY = 1

        fun newInstance(): SaleFragment {
            return SaleFragment()
        }
    }
}