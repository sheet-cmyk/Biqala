package com.grocery.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("id") val id: String,
    @SerializedName("name_ar") val nameAr: String,
    @SerializedName("name_en") val nameEn: String,
    @SerializedName("subtitle_ar") val subtitleAr: String,
    @SerializedName("subtitle_en") val subtitleEn: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("bg_color") val backgroundColor: Long,
    @SerializedName("item_count") val itemCount: Int = 0
)

data class BannerDto(
    @SerializedName("id") val id: String,
    @SerializedName("title_ar") val titleAr: String,
    @SerializedName("title_en") val titleEn: String,
    @SerializedName("subtitle_ar") val subtitleAr: String,
    @SerializedName("subtitle_en") val subtitleEn: String,
    @SerializedName("button_ar") val buttonTextAr: String,
    @SerializedName("button_en") val buttonTextEn: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("action_route") val actionRoute: String = ""
)
