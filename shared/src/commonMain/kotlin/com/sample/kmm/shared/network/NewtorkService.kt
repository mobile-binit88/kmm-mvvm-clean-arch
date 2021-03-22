package com.jarroyo.kotlinmultiplatform.source.network


import com.sample.kmm.shared.base.ApiResponse
import com.sample.kmm.shared.base.NetworkConnectionException
import com.sample.kmm.shared.base.Response
import com.sample.kmm.shared.model.response.CategoryResponse
import com.sample.kmm.shared.network.CATEGORY
import com.sample.kmm.shared.network.URL
import com.sample.kmm.shared.utils.isNetworkAvailable
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class NewtorkService(private val httpClient: HttpClient) {

    private val nonStrictJson = Json { isLenient = true; ignoreUnknownKeys = true }

    private val client by lazy {
        HttpClient() {
            install(JsonFeature) {
                serializer = KotlinxSerializer(nonStrictJson)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
        }
    }

    suspend fun getCategoryRepoList(): Response<List<CategoryResponse>> {
        try {
            if (!isNetworkAvailable()) {
                val url = "$URL$CATEGORY?id=1"
                val response = httpClient.get<ApiResponse<List<CategoryResponse>>>(url)
                return Response.Success(response)
            } else {
                return Response.Error(NetworkConnectionException())
            }
        } catch (ex: Exception) {
            Logger.DEFAULT.log("getCategoryList - " + ex.message!!)
            return Response.Error(ex)
        }
    }
}