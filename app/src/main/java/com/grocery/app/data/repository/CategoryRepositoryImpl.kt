package com.grocery.app.data.repository

import com.grocery.app.data.local.dao.BannerDao
import com.grocery.app.data.local.dao.CategoryDao
import com.grocery.app.data.local.entity.BannerEntity
import com.grocery.app.data.local.entity.CategoryEntity
import com.grocery.app.data.remote.api.GroceryApi
import com.grocery.app.domain.model.Banner
import com.grocery.app.domain.model.Category
import com.grocery.app.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: GroceryApi,
    private val categoryDao: CategoryDao,
    private val bannerDao: BannerDao
) : CategoryRepository {

    override fun getCategories(): Flow<List<Category>> =
        categoryDao.getAll().map { entities ->
            if (entities.isEmpty()) defaultCategories() else entities.map { it.toDomain() }
        }

    override fun getBanners(): Flow<List<Banner>> =
        bannerDao.getAll().map { entities ->
            if (entities.isEmpty()) defaultBanners() else entities.map { it.toDomain() }
        }

    override suspend fun refreshCategories() {
        try {
            val remote = api.getCategories()
            categoryDao.deleteAll()
            categoryDao.insertAll(remote.map { dto ->
                CategoryEntity(
                    id = dto.id,
                    nameAr = dto.nameAr,
                    nameEn = dto.nameEn,
                    subtitleAr = dto.subtitleAr,
                    subtitleEn = dto.subtitleEn,
                    imageUrl = dto.imageUrl,
                    backgroundColor = dto.backgroundColor,
                    itemCount = dto.itemCount
                )
            })
        } catch (_: Exception) {
            // Use cached data on network error
        }
    }

    override suspend fun refreshBanners() {
        try {
            val remote = api.getBanners()
            bannerDao.deleteAll()
            bannerDao.insertAll(remote.map { dto ->
                BannerEntity(
                    id = dto.id,
                    titleAr = dto.titleAr,
                    titleEn = dto.titleEn,
                    subtitleAr = dto.subtitleAr,
                    subtitleEn = dto.subtitleEn,
                    buttonTextAr = dto.buttonTextAr,
                    buttonTextEn = dto.buttonTextEn,
                    imageUrl = dto.imageUrl,
                    actionRoute = dto.actionRoute
                )
            })
        } catch (_: Exception) {
            // Use cached data on network error
        }
    }

    // ── Default data (shown when DB is empty / no network) ──────────────────

    private fun defaultCategories(): List<Category> = listOf(
        Category("1", "خضروات", "Vegetables", "طازجة يومياً", "Fresh Daily",
            "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=300", 0xFFE8F5E9),
        Category("2", "فواكه", "Fruits", "طازجة وموسمية", "Fresh & Seasonal",
            "https://images.unsplash.com/photo-1619566636858-adf3ef46400b?w=300", 0xFFFFF3E0),
        Category("3", "لحوم ودواجن", "Meat & Poultry", "طازجة ومبردة", "Fresh & Chilled",
            "https://images.unsplash.com/photo-1529692236671-f1f6cf9683ba?w=300", 0xFFFCE4EC),
        Category("4", "منتجات الألبان", "Dairy", "جودة عالية", "High Quality",
            "https://images.unsplash.com/photo-1550583724-b2692b85b150?w=300", 0xFFFFFDE7),
        Category("5", "مواد غذائية", "Groceries", "كل احتياجاتك", "All Your Needs",
            "https://images.unsplash.com/photo-1586201375761-83865001e31c?w=300", 0xFFE3F2FD),
        Category("6", "مخبوزات", "Bakery", "طازجة يومياً", "Baked Fresh Daily",
            "https://images.unsplash.com/photo-1509440159596-0249088772ff?w=300", 0xFFEDE7F6),
    )

    private fun defaultBanners(): List<Banner> = listOf(
        Banner(
            id = "1",
            titleAr = "طازج يومياً",
            titleEn = "Fresh Daily",
            subtitleAr = "خضار وفواكه عالية الجودة",
            subtitleEn = "High quality vegetables and fruits",
            buttonTextAr = "تسوق الآن",
            buttonTextEn = "Shop Now",
            imageUrl = "https://images.unsplash.com/photo-1488459716781-31db52582fe9?w=600",
            actionRoute = "home"
        ),
        Banner(
            id = "2",
            titleAr = "عروض حصرية",
            titleEn = "Exclusive Offers",
            subtitleAr = "خصومات تصل إلى ٥٠٪",
            subtitleEn = "Discounts up to 50%",
            buttonTextAr = "اكتشف العروض",
            buttonTextEn = "Discover Deals",
            imageUrl = "https://images.unsplash.com/photo-1542838132-92c53300491e?w=600",
            actionRoute = "menu"
        )
    )
}

private fun CategoryEntity.toDomain() = Category(
    id = id, nameAr = nameAr, nameEn = nameEn,
    subtitleAr = subtitleAr, subtitleEn = subtitleEn,
    imageUrl = imageUrl, backgroundColor = backgroundColor,
    emoji = emoji, itemCount = itemCount
)

private fun BannerEntity.toDomain() = Banner(
    id = id, titleAr = titleAr, titleEn = titleEn,
    subtitleAr = subtitleAr, subtitleEn = subtitleEn,
    buttonTextAr = buttonTextAr, buttonTextEn = buttonTextEn,
    imageUrl = imageUrl, actionRoute = actionRoute
)
