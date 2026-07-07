package com.grocery.app.presentation.grocerydetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

// ── Data ──────────────────────────────────────────────────────────────────────
data class FoodSubCategory(
    val id: Int,
    val nameAr: String,
    val imageUrl: String,
    val iconEmoji: String,
    val bgTop: Color,
    val bgBottom: Color,
    val iconBg: Color
)

val grocerySubCategories = listOf(
    FoodSubCategory(1,  "اللحوم والدواجن",
        "https://images.unsplash.com/photo-1529692236671-f1f6cf9683ba?w=400&q=80",
        "🥩", Color(0xFFFFCDD2), Color(0xFFFFAB91), Color(0xFFE53935)),

    FoodSubCategory(2,  "الأسماك\nوالمأكولات البحرية",
        "https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=400&q=80",
        "🐠", Color(0xFFB3E5FC), Color(0xFF81D4FA), Color(0xFF039BE5)),

    FoodSubCategory(3,  "البيض",
        "https://images.unsplash.com/photo-1582722872445-44dc5f7e3c8f?w=400&q=80",
        "🥚", Color(0xFFFFF8E1), Color(0xFFFFECB3), Color(0xFFF9A825)),

    FoodSubCategory(4,  "المعكرونة\nوالنودلز",
        "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9?w=400&q=80",
        "🍜", Color(0xFFFFE0B2), Color(0xFFFFCC80), Color(0xFFEF6C00)),

    FoodSubCategory(5,  "المعلبات",
        "https://images.unsplash.com/photo-1584263347416-85a696b4eda7?w=400&q=80",
        "🥫", Color(0xFFFFCDD2), Color(0xFFEF9A9A), Color(0xFFC62828)),

    FoodSubCategory(6,  "المخلات والزيتون",
        "https://images.unsplash.com/photo-1474979266404-7eaacbcd87c5?w=400&q=80",
        "🫙", Color(0xFFDCEDC8), Color(0xFFC5E1A5), Color(0xFF558B2F)),

    FoodSubCategory(7,  "البهارات والتوابل",
        "https://images.unsplash.com/photo-1596040033229-a9821ebd058d?w=400&q=80",
        "🌶️", Color(0xFFFFCDD2), Color(0xFFFF8A80), Color(0xFFD32F2F)),

    FoodSubCategory(8,  "الزيوت والسمن",
        "https://images.unsplash.com/photo-1474979266404-7eaacbcd87c5?w=400&q=80",
        "💛", Color(0xFFFFF9C4), Color(0xFFFFF176), Color(0xFFF9A825)),

    FoodSubCategory(9,  "العسل والمربى",
        "https://images.unsplash.com/photo-1587049352846-4a222e784d38?w=400&q=80",
        "🍯", Color(0xFFFFE0B2), Color(0xFFFFCC80), Color(0xFFE65100)),

    FoodSubCategory(10, "الحلويات\nوالشوكولاتة",
        "https://images.unsplash.com/photo-1606312619070-d48b3c7e3e01?w=400&q=80",
        "🍭", Color(0xFFF8BBD0), Color(0xFFF48FB1), Color(0xFFAD1457)),

    FoodSubCategory(11, "البسكويت\nوالوجبات الخفيفة",
        "https://images.unsplash.com/photo-1558961363-fa8fdf82db35?w=400&q=80",
        "🍪", Color(0xFFFFE0B2), Color(0xFFFFCC80), Color(0xFFBF360C)),

    FoodSubCategory(12, "المكسرات والبذور",
        "https://images.unsplash.com/photo-1508061253366-f7da158b6d46?w=400&q=80",
        "🌰", Color(0xFFD7CCC8), Color(0xFFBCAAA4), Color(0xFF5D4037)),

    FoodSubCategory(14, "العصائر\nوالمشروبات",
        "https://images.unsplash.com/photo-1600271886742-f049cd451bba?w=400&q=80",
        "🥤", Color(0xFFDCEDC8), Color(0xFFC5E1A5), Color(0xFF388E3C)),

    FoodSubCategory(15, "القهوة والشاي",
        "https://images.unsplash.com/photo-1509042239860-f550ce710b93?w=400&q=80",
        "☕", Color(0xFFD7CCC8), Color(0xFFBCAAA4), Color(0xFF4E342E)),

    FoodSubCategory(15, "المشروبات الغازية\nومشروبات الطاقة",
        "https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=400&q=80",
        "🫙", Color(0xFFB3E5FC), Color(0xFF81D4FA), Color(0xFF1565C0)),

    FoodSubCategory(17, "الأطعمة المجمدة",
        "https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400&q=80",
        "🧊", Color(0xFFE1F5FE), Color(0xFFB3E5FC), Color(0xFF0277BD)),

    FoodSubCategory(18, "أغذية الأطفال",
        "https://images.unsplash.com/photo-1584897333429-ded2f5c7fd35?w=400&q=80",
        "👶", Color(0xFFFCE4EC), Color(0xFFF8BBD0), Color(0xFFAD1457)),

    FoodSubCategory(19, "أغذية الحيوانات\nالأليفة",
        "https://images.unsplash.com/photo-1589924691995-400dc9ecc119?w=400&q=80",
        "🐾", Color(0xFFE8EAF6), Color(0xFFC5CAE9), Color(0xFF3949AB)),

    FoodSubCategory(29, "المنتجات العضوية\nوالصحية",
        "https://images.unsplash.com/photo-1518843875459-f738682238a6?w=400&q=80",
        "🌿", Color(0xFFE8F5E9), Color(0xFFC8E6C9), Color(0xFF2E7D32)),

    FoodSubCategory(20, "الوجبات الجاهزة",
        "https://images.unsplash.com/photo-1574484284002-952d92456975?w=400&q=80",
        "🍽️", Color(0xFFE8F5E9), Color(0xFFC8E6C9), Color(0xFF43A047)),

    FoodSubCategory(22, "مستلزمات المطبخ",
        "https://images.unsplash.com/photo-1556910103-1c02745aae4d?w=400&q=80",
        "🫕", Color(0xFFECEFF1), Color(0xFFCFD8DC), Color(0xFF455A64)),

    FoodSubCategory(23, "المناديل\nوالورق الصحي",
        "https://images.unsplash.com/photo-1584744982491-665216d95f8b?w=400&q=80",
        "🧼", Color(0xFFF3E5F5), Color(0xFFE1BEE7), Color(0xFF7B1FA2)),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryDetailsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // ── Title ─────────────────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(bottom = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "المواد الغذائية",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1B5E20)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "🧺", fontSize = 24.sp)
                }
            }

            // ── Grid ──────────────────────────────────────────────────────────
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement   = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(grocerySubCategories) { cat ->
                    SubCategoryCard(cat)
                }
            }
        }
    }
}

// ── Card ──────────────────────────────────────────────────────────────────────
@Composable
private fun SubCategoryCard(cat: FoodSubCategory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(14.dp))
            .clickable { },
        shape  = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column {

            // ── Image area ────────────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(108.dp)
                    .background(
                        Brush.verticalGradient(listOf(cat.bgTop, cat.bgBottom))
                    ),
                contentAlignment = Alignment.Center
            ) {
                // Real photo — covers gradient when loaded, gradient shows while loading
                AsyncImage(
                    model = cat.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            // ── Bottom strip ──────────────────────────────────────────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Number + name (RTL: appears on the right)
                Text(
                    text       = "${cat.id}. ${cat.nameAr}",
                    fontSize   = 9.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color      = Color(0xFF1A1A1A),
                    textAlign  = TextAlign.End,
                    maxLines   = 2,
                    overflow   = TextOverflow.Ellipsis,
                    lineHeight = 13.sp,
                    modifier   = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                )

                // Icon circle (RTL: appears on the left)
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(cat.iconBg.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(cat.iconEmoji, fontSize = 12.sp)
                }
            }
        }
    }
}
