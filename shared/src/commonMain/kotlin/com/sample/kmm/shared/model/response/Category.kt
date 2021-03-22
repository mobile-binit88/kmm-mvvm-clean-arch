package com.sample.kmm.shared.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val description: String? = null,
    val id: Int,
    val name: String,
    val photo: Photo? =null
)