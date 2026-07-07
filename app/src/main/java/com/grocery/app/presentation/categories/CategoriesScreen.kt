package com.grocery.app.presentation.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grocery.app.R

data class FoodCategory(
    val id: Int,
    val name: String,
    val mainEmoji: String,
    val iconEmoji: String,
    val gradientTop: Color,
    val gradientBottom: Color,
    val iconBg: Color
)

val foodCategories = listOf(
    FoodCategory(1,  "اللحوم والدواجن",                     "🥩", "🥩", Color(0xFFFFCDD2), Color(0xFFEF9A9A), Color(0xFFE53935)),
    FoodCategory(2,  "الأسماك\nوالمأكولات البحرية",          "🐟", "🐠", Color(0xFFB3E5FC), Color(0xFF81D4FA), Color(0xFF1E88E5)),
    FoodCategory(3,  "البيض",                               "🥚", "🍳", Color(0xFFFFF9C4), Color(0xFFFFF176), Color(0xFFFDD835)),
    FoodCategory(4,  "المعكرونة والنودلز",                   "🍝", "🍜", Color(0xFFFFE0B2), Color(0xFFFFCC80), Color(0xFFFB8C00)),
    FoodCategory(5,  "المعلبات",                             "🥫", "🥫", Color(0xFFC8E6C9), Color(0xFFA5D6A7), Color(0xFF43A047)),
    FoodCategory(6,  "المخلات والزيتون",                     "🫒", "🫙", Color(0xFFD7CCC8), Color(0xFFBCAAA4), Color(0xFF6D4C41)),
    FoodCategory(7,  "البهارات والتوابل",                    "🌶️", "🫙", Color(0xFFFFCDD2), Color(0xFFEF9A9A), Color(0xFFE53935)),
    FoodCategory(8,  "الزيوت والسمن",                        "🫒", "🟡", Color(0xFFFFF9C4), Color(0xFFFFF176), Color(0xFFFDD835)),
    FoodCategory(9,  "العسل والمربى",                        "🍯", "🍯", Color(0xFFFFE0B2), Color(0xFFFFCC80), Color(0xFFFB8C00)),
    FoodCategory(10, "الحلويات والشوكولاتة",                  "🍫", "🍭", Color(0xFFF8BBD0), Color(0xFFF48FB1), Color(0xFFD81B60)),
    FoodCategory(11, "البسكويت\nوالوجبات الخفيفة",            "🍪", "🍘", Color(0xFFFFE0B2), Color(0xFFFFCC80), Color(0xFFFB8C00)),
    FoodCategory(12, "المكسرات والبذور",                     "🥜", "🌰", Color(0xFFD7CCC8), Color(0xFFBCAAA4), Color(0xFF6D4C41)),
    FoodCategory(14, "العصائر والمشروبات",                   "🧃", "🥤", Color(0xFFC8E6C9), Color(0xFFA5D6A7), Color(0xFF43A047)),
    FoodCategory(15, "القهوة والشاي",                        "☕", "🍵", Color(0xFFD7CCC8), Color(0xFFBCAAA4), Color(0xFF6D4C41)),
    FoodCategory(15, "المشروبات الغازية\nومشروبات الطاقة",   "🥤", "🫙", Color(0xFFB3E5FC), Color(0xFF81D4FA), Color(0xFF1E88E5)),
    FoodCategory(17, "الأطعمة المجمدة",                      "❄️", "🧊", Color(0xFFE1F5FE), Color(0xFFB3E5FC), Color(0xFF0288D1)),
    FoodCategory(18, "أغذية الأطفال",                        "🍼", "👶", Color(0xFFF8BBD0), Color(0xFFF48FB1), Color(0xFFD81B60)),
    FoodCategory(19, "أغذية الحيوانات الأليفة",               "🐾", "🐕", Color(0xFFE1BEE7), Color(0xFFCE93D8), Color(0xFF8E24AA)),
    FoodCategory(29, "المنتجات العضوية والصحية",              "🥦", "🌿", Color(0xFFC8E6C9), Color(0xFFA5D6A7), Color(0xFF2E7D32)),
    FoodCategory(20, "الوجبات الجاهزة",                      "🍱", "🍽️", Color(0xFFC8E6C9), Color(0xFFA5D6A7), Color(0xFF43A047)),
    FoodCategory(22, "مستلزمات المطبخ",                      "🍳", "🫕", Color(0xFFCFD8DC), Color(0xFFB0BEC5), Color(0xFF546E7A)),
    FoodCategory(23, "المناديل والورق الصحي",                 "🧻", "🧼", Color(0xFFE1BEE7), Color(0xFFCE93D8), Color(0xFF8E24AA)),
)

@Composable
fun CategoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // ── Title ────────────────────────────────────────────────────────────
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.categories_title) + " 🧺",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1B5E20),
                textAlign = TextAlign.Center,
                fontSize = 26.sp
            )
        }

        // ── Grid ─────────────────────────────────────────────────────────────
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(foodCategories) { category ->
                FoodCategoryCard(category = category)
            }
        }
    }
}

@Composable
private fun FoodCategoryCard(category: FoodCategory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 3.dp, shape = RoundedCornerShape(16.dp))
            .clickable { },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column {
            // ── Food image area ───────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(category.gradientTop, category.gradientBottom)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = category.mainEmoji,
                    fontSize = 52.sp,
                    textAlign = TextAlign.Center
                )
            }

            // ── Bottom info strip ─────────────────────────────────────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Icon badge — on the left (end in RTL)
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(category.iconBg.copy(alpha = 0.18f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(category.iconEmoji, fontSize = 13.sp)
                }

                // Category number + name — on the right (start in RTL)
                Text(
                    text = "${category.id}. ${category.name}",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF212121),
                    textAlign = TextAlign.End,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 10.sp,
                    lineHeight = 13.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                )
            }
        }
    }
}
