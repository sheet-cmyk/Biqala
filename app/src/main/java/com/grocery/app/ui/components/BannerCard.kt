package com.grocery.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.grocery.app.domain.model.Banner
import com.grocery.app.ui.theme.GreenPrimary

@Composable
fun BannerCard(
    banner: Banner,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val title = if (isRtl) banner.titleAr else banner.titleEn
    val subtitle = if (isRtl) banner.subtitleAr else banner.subtitleEn
    val buttonText = if (isRtl) banner.buttonTextAr else banner.buttonTextEn

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFEAF4EA))
            .clickable { onClick() }
    ) {
        // Background image (right side / full bleed)
        AsyncImage(
            model = banner.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterEnd)
        )

        // Left-side gradient overlay for text readability
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.55f)
                .align(if (isRtl) Alignment.CenterEnd else Alignment.CenterStart)
                .background(
                    Brush.horizontalGradient(
                        colors = if (isRtl)
                            listOf(Color.Transparent, Color(0xE6EAF4EA))
                        else
                            listOf(Color(0xE6EAF4EA), Color.Transparent)
                    )
                )
        )

        // Text content
        Column(
            modifier = Modifier
                .align(if (isRtl) Alignment.CenterEnd else Alignment.CenterStart)
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .fillMaxWidth(0.5f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1B5E20),
                fontSize = 26.sp,
                lineHeight = 32.sp
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF4E4E4E),
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            RoundedButton(
                text = buttonText,
                onClick = onClick
            )
        }
    }
}
