package com.sample.kmm.shared.usecase

import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.request.CategotyRequest
import com.sample.kmm.shared.model.response.CategoryResponse
import com.sample.kmm.shared.repository.CategoryRepository


open class CategoryListUseCase(val repository: CategoryRepository) :
    BaseUseCase<CategotyRequest, List<CategoryResponse>>() {

    override suspend fun run(): Response<List<CategoryResponse>> {
        return repository.getCategoryRepo((request) as CategotyRequest)
    }
}