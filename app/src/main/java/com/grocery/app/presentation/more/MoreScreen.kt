package com.grocery.app.presentation.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grocery.app.R
import com.grocery.app.ui.theme.GreenPrimary

@Composable
fun MoreScreen(
    onNavigateToCart: () -> Unit = {},
    onNavigateToSettings: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 18.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.nav_more) + " ···",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = GreenPrimary,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            MoreSectionCard {
                MoreRowItem(Icons.Default.ShoppingCart, stringResource(R.string.nav_cart),   GreenPrimary,   onNavigateToCart)
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), color = Color(0xFFEEEEEE))
                MoreRowItem(Icons.Default.Settings,     stringResource(R.string.nav_settings), Color(0xFF1565C0), onNavigateToSettings)
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            MoreSectionCard {
                MoreRowItem(Icons.Default.ContactSupport, stringResource(R.string.settings_contact), Color(0xFF6A1B9A))
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), color = Color(0xFFEEEEEE))
                MoreRowItem(Icons.Default.Info,           stringResource(R.string.settings_about),   Color(0xFF0288D1))
            }
        }
    }
}

@Composable
private fun MoreSectionCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        content = content
    )
}

@Composable
private fun MoreRowItem(
    icon: ImageVector,
    label: String,
    iconColor: Color,
    onClick: () -> Unit = {}
) {
    Surface(onClick = onClick, color = Color.Transparent) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(iconColor.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, null, tint = iconColor, modifier = Modifier.size(22.dp))
                }
                Text(label, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
            }
            Icon(Icons.Default.ChevronRight, null, tint = Color(0xFFBDBDBD))
        }
    }
}
