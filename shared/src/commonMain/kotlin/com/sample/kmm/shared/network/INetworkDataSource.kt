package com.sample.kmm.shared.network

import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.response.CategoryResponse

abstract class INetworkDataSource {

    abstract suspend fun getCategoryList(): Response<List<CategoryResponse>>
}