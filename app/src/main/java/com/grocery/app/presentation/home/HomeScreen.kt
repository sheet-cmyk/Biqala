package com.grocery.app.presentation.home

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.grocery.app.R
import com.grocery.app.ui.components.*
import com.grocery.app.ui.theme.GreenPrimary

@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when {
        state.isLoading && state.banners.isEmpty() -> LoadingScreen()
        state.error != null && state.banners.isEmpty() -> ErrorScreen(
            message = state.error ?: "Unknown error",
            onRetry = viewModel::retry
        )
        else -> HomeContent(
            state = state,
            onCategoryClick = onCategoryClick,
            onSearchQueryChange = viewModel::onSearchQueryChange,
            onSearch = viewModel::onSearch
        )
    }
}

@Composable
private fun HomeContent(
    state: HomeUiState,
    onCategoryClick: (String) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp)
    ) {
        // ── Banner / Image Slider ────────────────────────────────────────────
        if (state.banners.isNotEmpty()) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically()
            ) {
                ImageSlider(
                    banners = state.banners,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .height(220.dp)
                )
            }
        }

        // ── Category Grid ────────────────────────────────────────────────────
        if (state.categories.isNotEmpty()) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it / 4 })
            ) {
                val rows = (state.categories.size + 2) / 3
                val cardHeight = 160.dp
                val gridHeight = cardHeight * rows + 12.dp * (rows - 1) + 32.dp

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(gridHeight)
                        .padding(horizontal = 12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = false
                ) {
                    items(state.categories, key = { it.id }) { category ->
                        CategoryCard(
                            category = category,
                            onClick  = { onCategoryClick(category.id) },
                            modifier = Modifier.fillMaxWidth().height(cardHeight)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ── Special Offer Banner ─────────────────────────────────────────────
        SpecialOfferBanner(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ── Search Bar ───────────────────────────────────────────────────────
        GrocerySearchBar(
            query = state.searchQuery,
            onQueryChange = onSearchQueryChange,
            onSearch = onSearch,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun SpecialOfferBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF1B5E20),
                        Color(0xFF388E3C),
                        Color(0xFF66BB6A)
                    )
                )
            )
            .padding(horizontal = 20.dp, vertical = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocalOffer,
                        contentDescription = null,
                        tint = Color(0xFFFFF176),
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = stringResource(R.string.special_offer_title),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
                Text(
                    text = stringResource(R.string.special_offer_subtitle),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f),
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = GreenPrimary
                    ),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.special_offer_button),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Decorative percentage badge
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color.White.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "20%",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFFFF176),
                        fontSize = 22.sp
                    )
                    Text(
                        text = "OFF",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}
