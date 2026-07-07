package com.grocery.app.domain.model

data class Banner(
    val id: String,
    val titleAr: String,
    val titleEn: String,
    val subtitleAr: String,
    val subtitleEn: String,
    val buttonTextAr: String,
    val buttonTextEn: String,
    val imageUrl: String,
    val actionRoute: String = ""
)
