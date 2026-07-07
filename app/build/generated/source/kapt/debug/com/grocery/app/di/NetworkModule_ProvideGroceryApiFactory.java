package com.grocery.app.di;

import com.grocery.app.data.remote.api.GroceryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideGroceryApiFactory implements Factory<GroceryApi> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideGroceryApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GroceryApi get() {
    return provideGroceryApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideGroceryApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideGroceryApiFactory(retrofitProvider);
  }

  public static GroceryApi provideGroceryApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideGroceryApi(retrofit));
  }
}
