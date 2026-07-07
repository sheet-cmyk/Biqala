package com.grocery.app.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.grocery.app.R
import com.grocery.app.ui.theme.GreenPrimary

@Composable
fun CartScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Surface(
            shadowElevation = 4.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.nav_cart),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )

                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = GreenPrimary
                ) {
                    CartTab(
                        index = 0,
                        selectedTab = selectedTab,
                        labelRes = R.string.tab_orders,
                        icon = Icons.Default.Receipt,
                        onSelect = { selectedTab = 0 }
                    )
                    CartTab(
                        index = 1,
                        selectedTab = selectedTab,
                        labelRes = R.string.tab_favorites,
                        icon = Icons.Default.Favorite,
                        onSelect = { selectedTab = 1 }
                    )
                }
            }
        }

        when (selectedTab) {
            0 -> EmptyTabContent(
                icon = Icons.Default.Receipt,
                messageRes = R.string.orders_empty
            )
            1 -> EmptyTabContent(
                icon = Icons.Default.Favorite,
                messageRes = R.string.favorites_empty
            )
        }
    }
}

@Composable
private fun CartTab(
    index: Int,
    selectedTab: Int,
    labelRes: Int,
    icon: ImageVector,
    onSelect: () -> Unit
) {
    Tab(
        selected = selectedTab == index,
        onClick = onSelect,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        text = {
            Text(
                text = stringResource(labelRes),
                fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
            )
        },
        selectedContentColor = GreenPrimary,
        unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
private fun EmptyTabContent(icon: ImageVector, messageRes: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = GreenPrimary.copy(alpha = 0.5f),
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(messageRes),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
