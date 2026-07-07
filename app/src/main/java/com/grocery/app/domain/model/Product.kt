package com.grocery.app.domain.model

data class Product(
    val id: String,
    val nameAr: String,
    val nameEn: String,
    val price: Double,
    val unit: String,
    val imageUrl: String,
    val categoryId: String,
    val isAvailable: Boolean = true,
    val rating: Float = 0f,
    val reviewCount: Int = 0
)
