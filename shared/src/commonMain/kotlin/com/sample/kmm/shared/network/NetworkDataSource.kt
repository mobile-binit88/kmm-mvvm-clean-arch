package com.sample.kmm.shared.network

import com.jarroyo.kotlinmultiplatform.source.network.NewtorkService
import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.response.CategoryResponse

class NetworkDataSource(private val newtorkService: NewtorkService) : INetworkDataSource() {

    override suspend fun getCategoryList(): Response<List<CategoryResponse>> =
        newtorkService.getCategoryRepoList()

}