package com.grocery.app.domain.model

data class Category(
    val id: String,
    val nameAr: String,
    val nameEn: String,
    val subtitleAr: String,
    val subtitleEn: String,
    val imageUrl: String,
    val backgroundColor: Long,
    val emoji: String = "",
    val itemCount: Int = 0
)
