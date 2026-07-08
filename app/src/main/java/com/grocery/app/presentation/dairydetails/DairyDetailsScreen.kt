package com.grocery.app.presentation.dairydetails

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class DairyProduct(
    val nameAr: String,
    val imageUrl: String
)

val dairyProducts = listOf(
    DairyProduct(
        "القشطة",
        "https://images.unsplash.com/photo-1488477181946-6428a0291777?w=400&q=80"
    ),
    DairyProduct(
        "الزبدة",
        "https://images.unsplash.com/photo-1558618666-fcd25c85cd64?w=400&q=80"
    ),
    DairyProduct(
        "الزبادي",
        "https://images.unsplash.com/photo-1571212515416-fca88e3b8b4f?w=400&q=80"
    ),
    DairyProduct(
        "الحليب",
        "https://images.unsplash.com/photo-1550583724-b2692b85b150?w=400&q=80"
    ),
    DairyProduct(
        "اللبنة",
        "https://images.unsplash.com/photo-1488477181946-6428a0291777?w=400&q=80"
    ),
    DairyProduct(
        "الجبنة البيضاء",
        "https://images.unsplash.com/photo-1559561853-08451507cbe7?w=400&q=80"
    ),
    DairyProduct(
        "الجبنة الشيدر",
        "https://images.unsplash.com/photo-1618164436241-4473940d1f5c?w=400&q=80"
    ),
    DairyProduct(
        "الجبنة الفاخرة",
        "https://images.unsplash.com/photo-1573276534991-ab45f4b44ab9?w=400&q=80"
    ),
    DairyProduct(
        "الموزاريلا",
        "https://images.unsplash.com/photo-1599458252573-56ae36120de1?w=400&q=80"
    ),
    DairyProduct(
        "حليب بودرة",
        "https://images.unsplash.com/photo-1564466809058-bf4114d55352?w=400&q=80"
    ),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DairyDetailsScreen(onBack: () -> Unit) {
    val blueDeep  = Color(0xFF0D47A1)
    val blueMid   = Color(0xFF1565C0)
    val blueLight = Color(0xFFBBDEFB)
    val bluePale  = Color(0xFFE3F2FD)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = blueDeep)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = bluePale)
            )
        },
        containerColor = Color(0xFFF0F7FF)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // ── Header ───────────────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(blueLight, bluePale, Color(0xFFF0F7FF))
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "🥛", fontSize = 28.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "منتجات الألبان",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = blueDeep
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "🥛", fontSize = 28.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    // Subtitle badge
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = blueMid
                    ) {
                        Text(
                            text = "طازجة  •  طبيعية  •  عالية الجودة",
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            // ── Grid ──────────────────────────────────────────────────────────
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement   = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(dairyProducts) { product ->
                    DairyProductCard(product, blueMid, blueLight)
                }
            }

            // ── Footer ────────────────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "🥛", fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "اختيارك الأمثل لصحة عائلتك",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = blueDeep
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "🥛", fontSize = 16.sp)
                }
            }
        }
    }
}

// ── Card ──────────────────────────────────────────────────────────────────────
@Composable
private fun DairyProductCard(
    product: DairyProduct,
    blueMid: Color,
    blueLight: Color
) {
    Card(
        modifier  = Modifier
            .fillMaxWidth()
            .clickable { },
        shape     = RoundedCornerShape(16.dp),
        border    = BorderStroke(1.5.dp, blueLight),
        colors    = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            // Photo area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model        = product.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier     = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .padding(8.dp)
                )
            }

            // Blue name label
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = blueMid,
                        shape = RoundedCornerShape(
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text       = product.nameAr,
                    color      = Color.White,
                    fontSize   = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign  = TextAlign.Center
                )
            }
        }
    }
}
