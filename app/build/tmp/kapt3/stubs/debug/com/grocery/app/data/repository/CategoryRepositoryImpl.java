package com.grocery.app.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\u000fH\u0016J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/grocery/app/data/repository/CategoryRepositoryImpl;", "Lcom/grocery/app/domain/repository/CategoryRepository;", "api", "Lcom/grocery/app/data/remote/api/GroceryApi;", "categoryDao", "Lcom/grocery/app/data/local/dao/CategoryDao;", "bannerDao", "Lcom/grocery/app/data/local/dao/BannerDao;", "(Lcom/grocery/app/data/remote/api/GroceryApi;Lcom/grocery/app/data/local/dao/CategoryDao;Lcom/grocery/app/data/local/dao/BannerDao;)V", "defaultBanners", "", "Lcom/grocery/app/domain/model/Banner;", "defaultCategories", "Lcom/grocery/app/domain/model/Category;", "getBanners", "Lkotlinx/coroutines/flow/Flow;", "getCategories", "refreshBanners", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshCategories", "app_debug"})
public final class CategoryRepositoryImpl implements com.grocery.app.domain.repository.CategoryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.grocery.app.data.remote.api.GroceryApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.grocery.app.data.local.dao.CategoryDao categoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.grocery.app.data.local.dao.BannerDao bannerDao = null;
    
    @javax.inject.Inject()
    public CategoryRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.grocery.app.data.remote.api.GroceryApi api, @org.jetbrains.annotations.NotNull()
    com.grocery.app.data.local.dao.CategoryDao categoryDao, @org.jetbrains.annotations.NotNull()
    com.grocery.app.data.local.dao.BannerDao bannerDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.grocery.app.domain.model.Category>> getCategories() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.grocery.app.domain.model.Banner>> getBanners() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.util.List<com.grocery.app.domain.model.Category> defaultCategories() {
        return null;
    }
    
    private final java.util.List<com.grocery.app.domain.model.Banner> defaultBanners() {
        return null;
    }
}