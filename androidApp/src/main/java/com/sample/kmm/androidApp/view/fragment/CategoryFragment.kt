package com.sample.kmm.androidApp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bbl.common.recycler.SimpleRecyclerViewAdapter
import com.sample.kmm.androidApp.core.BaseFragment
import com.sample.kmm.androidApp.databinding.FragmentCategoryBinding
import com.sample.kmm.androidApp.extension.observe
import com.sample.kmm.androidApp.view.viewholder.CategoryViewHolder
import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.response.CategoryResponse
import com.sample.kmm.shared.viewmodel.category.*

class CategoryFragment : BaseFragment<CategoryViewModel>(), CategoryViewHolder.CallBack {

    private val categoryAdapter =
        SimpleRecyclerViewAdapter<CategoryResponse,
                CategoryViewHolder.CallBack, CategoryViewHolder>()

    private var binding: FragmentCategoryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getCategoryResponse()
        observeViewModel()
    }

    private fun observeViewModel() {
        observe(viewModel.mCategoryLiveData, ::getCategoryList)
    }

    fun getCategoryList(state: CategoryRepoListState) {
        when (state) {
            is SuccessState -> {
                hideProgressBar()
                val response = state.response as Response.Success
                onSuccessCategory(response.response.data)
            }

            is LoadingState -> {
                showProgressBar()
            }

            is ErrorState -> {
                hideProgressBar()
                val response = state.response as Response.Error
//                showError(response.message)
            }
        }
    }

    private fun onSuccessCategory(response: List<CategoryResponse>) {
        categoryAdapter.apply {
            setCallback(this@CategoryFragment)
            setViewHolderFactory(CategoryViewHolder.CategoryItemFactory())
            setModel(response)
        }
        binding?.rvSearch?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = categoryAdapter

        }
    }


    override fun onItemClick(category: CategoryResponse, position: Int) {
        Toast.makeText(
            activity, "Item clicked : ${category.category?.name}", Toast.LENGTH_LONG
        ).show()
    }


    override fun onDestroy() {
        binding = null
        super.onDestroy()

    }
}
