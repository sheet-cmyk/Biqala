package com.grocery.app.di;

import com.grocery.app.data.local.dao.BannerDao;
import com.grocery.app.data.local.db.GroceryDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideBannerDaoFactory implements Factory<BannerDao> {
  private final Provider<GroceryDatabase> dbProvider;

  public DatabaseModule_ProvideBannerDaoFactory(Provider<GroceryDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public BannerDao get() {
    return provideBannerDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideBannerDaoFactory create(
      Provider<GroceryDatabase> dbProvider) {
    return new DatabaseModule_ProvideBannerDaoFactory(dbProvider);
  }

  public static BannerDao provideBannerDao(GroceryDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideBannerDao(db));
  }
}
