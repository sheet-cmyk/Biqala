package com.grocery.app.domain.repository

import com.grocery.app.domain.model.Category
import com.grocery.app.domain.model.Banner
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<List<Category>>
    fun getBanners(): Flow<List<Banner>>
    suspend fun refreshCategories()
    suspend fun refreshBanners()
}
