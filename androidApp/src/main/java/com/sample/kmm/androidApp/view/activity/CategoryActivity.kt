package com.sample.kmm.androidApp.view.activity

import android.os.Bundle
import androidx.navigation.findNavController
import com.sample.kmm.androidApp.R
import com.sample.kmm.androidApp.core.BaseActivity
import com.sample.kmm.androidApp.databinding.ActivityCategoryBinding
import com.sample.kmm.shared.viewmodel.BaseViewModel

class CategoryActivity : BaseActivity<BaseViewModel>() {

    private var binding: ActivityCategoryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val bundle = intent.extras
        val navController = findNavController(R.id.nav_host_fragment)

        navController.setGraph(navController.graph, bundle)
    }
}