package com.grocery.app.domain.usecase

import com.grocery.app.domain.model.Banner
import com.grocery.app.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(): Flow<List<Banner>> = repository.getBanners()
}
