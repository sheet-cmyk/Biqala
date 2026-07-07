package com.grocery.app.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.grocery.app.domain.model.Banner
import kotlinx.coroutines.delay

@Composable
fun ImageSlider(
    banners: List<Banner>,
    modifier: Modifier = Modifier,
    autoScrollDuration: Long = 3500L,
    onBannerClick: (Banner) -> Unit = {}
) {
    if (banners.isEmpty()) return

    val pagerState = rememberPagerState(pageCount = { banners.size })

    // Auto-scroll
    LaunchedEffect(pagerState.currentPage) {
        delay(autoScrollDuration)
        val next = (pagerState.currentPage + 1) % banners.size
        pagerState.animateScrollToPage(
            page = next,
            animationSpec = tween(durationMillis = 600)
        )
    }

    Box(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            BannerCard(
                banner = banners[page],
                modifier = Modifier.fillMaxSize(),
                onClick = { onBannerClick(banners[page]) }
            )
        }

        // Dots indicator
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(banners.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            if (isSelected) Color.White
                            else Color.White.copy(alpha = 0.5f)
                        )
                        .size(if (isSelected) 8.dp else 6.dp)
                )
            }
        }
    }
}
