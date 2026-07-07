package com.grocery.app.di;

import android.content.Context;
import com.grocery.app.data.local.db.GroceryDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideGroceryDatabaseFactory implements Factory<GroceryDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideGroceryDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GroceryDatabase get() {
    return provideGroceryDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideGroceryDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideGroceryDatabaseFactory(contextProvider);
  }

  public static GroceryDatabase provideGroceryDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideGroceryDatabase(context));
  }
}
