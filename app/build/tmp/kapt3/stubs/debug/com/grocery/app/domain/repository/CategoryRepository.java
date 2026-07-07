package com.grocery.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H&J\u000e\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/grocery/app/domain/repository/CategoryRepository;", "", "getBanners", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/grocery/app/domain/model/Banner;", "getCategories", "Lcom/grocery/app/domain/model/Category;", "refreshBanners", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshCategories", "app_debug"})
public abstract interface CategoryRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.grocery.app.domain.model.Category>> getCategories();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.grocery.app.domain.model.Banner>> getBanners();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}