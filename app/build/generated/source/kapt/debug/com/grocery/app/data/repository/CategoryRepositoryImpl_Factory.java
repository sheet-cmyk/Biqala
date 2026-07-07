package com.grocery.app.data.repository;

import com.grocery.app.data.local.dao.BannerDao;
import com.grocery.app.data.local.dao.CategoryDao;
import com.grocery.app.data.remote.api.GroceryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class CategoryRepositoryImpl_Factory implements Factory<CategoryRepositoryImpl> {
  private final Provider<GroceryApi> apiProvider;

  private final Provider<CategoryDao> categoryDaoProvider;

  private final Provider<BannerDao> bannerDaoProvider;

  public CategoryRepositoryImpl_Factory(Provider<GroceryApi> apiProvider,
      Provider<CategoryDao> categoryDaoProvider, Provider<BannerDao> bannerDaoProvider) {
    this.apiProvider = apiProvider;
    this.categoryDaoProvider = categoryDaoProvider;
    this.bannerDaoProvider = bannerDaoProvider;
  }

  @Override
  public CategoryRepositoryImpl get() {
    return newInstance(apiProvider.get(), categoryDaoProvider.get(), bannerDaoProvider.get());
  }

  public static CategoryRepositoryImpl_Factory create(Provider<GroceryApi> apiProvider,
      Provider<CategoryDao> categoryDaoProvider, Provider<BannerDao> bannerDaoProvider) {
    return new CategoryRepositoryImpl_Factory(apiProvider, categoryDaoProvider, bannerDaoProvider);
  }

  public static CategoryRepositoryImpl newInstance(GroceryApi api, CategoryDao categoryDao,
      BannerDao bannerDao) {
    return new CategoryRepositoryImpl(api, categoryDao, bannerDao);
  }
}
