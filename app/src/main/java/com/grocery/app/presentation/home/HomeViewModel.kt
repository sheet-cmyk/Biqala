package com.grocery.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grocery.app.domain.model.Banner
import com.grocery.app.domain.model.Category
import com.grocery.app.domain.usecase.GetBannersUseCase
import com.grocery.app.domain.usecase.GetCategoriesUseCase
import com.grocery.app.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val banners: List<Banner> = emptyList(),
    val categories: List<Category> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = true,
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getBannersUseCase: GetBannersUseCase,
    private val repository: CategoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            // Trigger network refresh (falls back to cache on failure)
            launch { repository.refreshBanners() }
            launch { repository.refreshCategories() }

            // Observe local DB streams
            combine(
                getBannersUseCase(),
                getCategoriesUseCase()
            ) { banners, categories ->
                _uiState.update {
                    it.copy(
                        banners = banners,
                        categories = categories,
                        isLoading = false,
                        error = null
                    )
                }
            }.catch { e ->
                _uiState.update {
                    it.copy(isLoading = false, error = e.message)
                }
            }.collect()
        }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun onSearch(query: String) {
        // Navigate to search results screen (extend here)
    }

    fun retry() {
        _uiState.update { it.copy(isLoading = true, error = null) }
        loadData()
    }
}
