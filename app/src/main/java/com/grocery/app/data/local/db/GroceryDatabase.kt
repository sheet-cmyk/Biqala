package com.grocery.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.grocery.app.data.local.dao.BannerDao
import com.grocery.app.data.local.dao.CategoryDao
import com.grocery.app.data.local.entity.BannerEntity
import com.grocery.app.data.local.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class, BannerEntity::class],
    version = 2,
    exportSchema = false
)
abstract class GroceryDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun bannerDao(): BannerDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE categories ADD COLUMN emoji TEXT NOT NULL DEFAULT ''")
            }
        }
    }
}
