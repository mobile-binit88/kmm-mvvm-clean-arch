package com.sample.kmm.shared.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val category: Category?,
    val category_id: Int?,
    val id: Int?,
    val parent_id: Int?,
    val sort_order: String? = null,
    val top: String? = null
)