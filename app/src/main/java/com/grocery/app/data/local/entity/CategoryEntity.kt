package com.grocery.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey val id: String,
    val nameAr: String,
    val nameEn: String,
    val subtitleAr: String,
    val subtitleEn: String,
    val imageUrl: String,
    val backgroundColor: Long,
    @ColumnInfo(defaultValue = "") val emoji: String = "",
    val itemCount: Int = 0,
    val updatedAt: Long = System.currentTimeMillis()
)
