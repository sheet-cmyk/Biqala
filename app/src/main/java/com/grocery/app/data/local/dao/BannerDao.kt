package com.grocery.app.data.local.dao

import androidx.room.*
import com.grocery.app.data.local.entity.BannerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BannerDao {
    @Query("SELECT * FROM banners ORDER BY id ASC")
    fun getAll(): Flow<List<BannerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(banners: List<BannerEntity>)

    @Query("DELETE FROM banners")
    suspend fun deleteAll()
}
