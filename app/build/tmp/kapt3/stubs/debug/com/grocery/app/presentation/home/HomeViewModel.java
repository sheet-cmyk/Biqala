package com.grocery.app.presentation.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0011R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/grocery/app/presentation/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "getCategoriesUseCase", "Lcom/grocery/app/domain/usecase/GetCategoriesUseCase;", "getBannersUseCase", "Lcom/grocery/app/domain/usecase/GetBannersUseCase;", "repository", "Lcom/grocery/app/domain/repository/CategoryRepository;", "(Lcom/grocery/app/domain/usecase/GetCategoriesUseCase;Lcom/grocery/app/domain/usecase/GetBannersUseCase;Lcom/grocery/app/domain/repository/CategoryRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/grocery/app/presentation/home/HomeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadData", "", "onSearch", "query", "", "onSearchQueryChange", "retry", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.grocery.app.domain.usecase.GetCategoriesUseCase getCategoriesUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.grocery.app.domain.usecase.GetBannersUseCase getBannersUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.grocery.app.domain.repository.CategoryRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.grocery.app.presentation.home.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.grocery.app.presentation.home.HomeUiState> uiState = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.grocery.app.domain.usecase.GetCategoriesUseCase getCategoriesUseCase, @org.jetbrains.annotations.NotNull()
    com.grocery.app.domain.usecase.GetBannersUseCase getBannersUseCase, @org.jetbrains.annotations.NotNull()
    com.grocery.app.domain.repository.CategoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.grocery.app.presentation.home.HomeUiState> getUiState() {
        return null;
    }
    
    private final void loadData() {
    }
    
    public final void onSearchQueryChange(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void retry() {
    }
}