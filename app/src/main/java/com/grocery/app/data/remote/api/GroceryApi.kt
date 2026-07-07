package com.grocery.app.data.remote.api

import com.grocery.app.data.remote.dto.BannerDto
import com.grocery.app.data.remote.dto.CategoryDto
import retrofit2.http.GET

interface GroceryApi {
    @GET("categories")
    suspend fun getCategories(): List<CategoryDto>

    @GET("banners")
    suspend fun getBanners(): List<BannerDto>
}
