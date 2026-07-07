package com.grocery.app.presentation.offers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grocery.app.R
import com.grocery.app.ui.theme.GreenPrimary

private data class Offer(val title: String, val sub: String, val discount: String, val color1: Color, val color2: Color)

private val sampleOffers = listOf(
    Offer("خضروات طازجة", "خصم على جميع الخضروات", "30%", Color(0xFF2E7D32), Color(0xFF66BB6A)),
    Offer("فواكه موسمية", "أفضل فواكه الموسم", "20%", Color(0xFF1565C0), Color(0xFF42A5F5)),
    Offer("منتجات الألبان", "حليب وجبن وزبدة", "15%", Color(0xFF6A1B9A), Color(0xFFAB47BC)),
    Offer("المخبوزات", "خبز طازج يومياً", "10%", Color(0xFFBF360C), Color(0xFFFF7043)),
    Offer("اللحوم الطازجة", "لحوم ودواجن مختارة", "25%", Color(0xFF4E342E), Color(0xFF8D6E63)),
)

@Composable
fun OffersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.nav_offers) + " 🏷️",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = GreenPrimary,
                fontSize = 24.sp
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sampleOffers.size) { index ->
                val offer = sampleOffers[index]
                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Brush.horizontalGradient(listOf(offer.color1, offer.color2)))
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(offer.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                Text(offer.sub, color = Color.White.copy(alpha = 0.85f), fontSize = 13.sp)
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color.White.copy(alpha = 0.25f)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Icon(Icons.Default.LocalOffer, null, tint = Color.White, modifier = Modifier.size(14.dp))
                                        Text(stringResource(R.string.special_offer_button), color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                            Text(offer.discount, color = Color(0xFFFFF176), fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                        }
                    }
                }
            }
        }
    }
}
