package com.grocery.app.data.remote.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/grocery/app/data/remote/api/GroceryApi;", "", "getBanners", "", "Lcom/grocery/app/data/remote/dto/BannerDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "Lcom/grocery/app/data/remote/dto/CategoryDto;", "app_debug"})
public abstract interface GroceryApi {
    
    @retrofit2.http.GET(value = "categories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.grocery.app.data.remote.dto.CategoryDto>> $completion);
    
    @retrofit2.http.GET(value = "banners")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.grocery.app.data.remote.dto.BannerDto>> $completion);
}