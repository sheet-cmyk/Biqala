package com.grocery.app.di

import android.content.Context
import androidx.room.Room
import com.grocery.app.data.local.dao.BannerDao
import com.grocery.app.data.local.dao.CategoryDao
import com.grocery.app.data.local.db.GroceryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGroceryDatabase(@ApplicationContext context: Context): GroceryDatabase =
        Room.databaseBuilder(context, GroceryDatabase::class.java, "grocery_db")
            .addMigrations(GroceryDatabase.MIGRATION_1_2)
            .build()

    @Provides fun provideCategoryDao(db: GroceryDatabase): CategoryDao = db.categoryDao()
    @Provides fun provideBannerDao(db: GroceryDatabase):   BannerDao   = db.bannerDao()
}
