package com.sample.kmm.shared.viewmodel.category

import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.response.CategoryResponse


sealed class CategoryRepoListState {
    abstract val response: Response<List<CategoryResponse>>?
}

data class SuccessState(override val response: Response<List<CategoryResponse>>?) :
    CategoryRepoListState()

data class LoadingState(override val response: Response<List<CategoryResponse>>? = null) :
    CategoryRepoListState()

data class ErrorState(override val response: Response<List<CategoryResponse>>) :
    CategoryRepoListState()