package com.grocery.app.presentation.home;

import com.grocery.app.domain.repository.CategoryRepository;
import com.grocery.app.domain.usecase.GetBannersUseCase;
import com.grocery.app.domain.usecase.GetCategoriesUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetCategoriesUseCase> getCategoriesUseCaseProvider;

  private final Provider<GetBannersUseCase> getBannersUseCaseProvider;

  private final Provider<CategoryRepository> repositoryProvider;

  public HomeViewModel_Factory(Provider<GetCategoriesUseCase> getCategoriesUseCaseProvider,
      Provider<GetBannersUseCase> getBannersUseCaseProvider,
      Provider<CategoryRepository> repositoryProvider) {
    this.getCategoriesUseCaseProvider = getCategoriesUseCaseProvider;
    this.getBannersUseCaseProvider = getBannersUseCaseProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getCategoriesUseCaseProvider.get(), getBannersUseCaseProvider.get(), repositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetCategoriesUseCase> getCategoriesUseCaseProvider,
      Provider<GetBannersUseCase> getBannersUseCaseProvider,
      Provider<CategoryRepository> repositoryProvider) {
    return new HomeViewModel_Factory(getCategoriesUseCaseProvider, getBannersUseCaseProvider, repositoryProvider);
  }

  public static HomeViewModel newInstance(GetCategoriesUseCase getCategoriesUseCase,
      GetBannersUseCase getBannersUseCase, CategoryRepository repository) {
    return new HomeViewModel(getCategoriesUseCase, getBannersUseCase, repository);
  }
}
