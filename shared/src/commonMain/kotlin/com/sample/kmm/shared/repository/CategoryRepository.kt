package com.sample.kmm.shared.repository
import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.request.CategotyRequest
import com.sample.kmm.shared.model.response.CategoryResponse
import com.sample.kmm.shared.network.INetworkDataSource


class CategoryRepository(
    private val networkDataSource: INetworkDataSource
) {

    suspend fun getCategoryRepo(request: CategotyRequest): Response<List<CategoryResponse>> {
        val response = networkDataSource.getCategoryList()
        return response
    }
}