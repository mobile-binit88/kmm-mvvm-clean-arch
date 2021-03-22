package com.sample.kmm.shared.base

import kotlinx.serialization.Serializable

sealed class Response<out T>() {
    class Success<out T>(val response: ApiResponse<out T>) : Response<T>()
    data class Error(
        val exception: Throwable,
        val code: Int? = null,
        val error: Boolean? = null,
        val message: String? = null
    ) : Response<Nothing>()
}


@Serializable
data class ApiResponse<T>(
    val status: Int,
    val data: T,
    val message: String? = "",
)

