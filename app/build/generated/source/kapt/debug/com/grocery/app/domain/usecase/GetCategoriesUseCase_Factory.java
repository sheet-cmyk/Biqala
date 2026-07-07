package com.grocery.app.domain.usecase;

import com.grocery.app.domain.repository.CategoryRepository;
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
public final class GetCategoriesUseCase_Factory implements Factory<GetCategoriesUseCase> {
  private final Provider<CategoryRepository> repositoryProvider;

  public GetCategoriesUseCase_Factory(Provider<CategoryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCategoriesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCategoriesUseCase_Factory create(
      Provider<CategoryRepository> repositoryProvider) {
    return new GetCategoriesUseCase_Factory(repositoryProvider);
  }

  public static GetCategoriesUseCase newInstance(CategoryRepository repository) {
    return new GetCategoriesUseCase(repository);
  }
}
