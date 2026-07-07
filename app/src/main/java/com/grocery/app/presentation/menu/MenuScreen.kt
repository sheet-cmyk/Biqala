package com.grocery.app.presentation.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.grocery.app.R
import com.grocery.app.ui.theme.GreenPrimary

data class MenuItem(val labelRes: Int, val icon: ImageVector)

val menuItems = listOf(
    MenuItem(R.string.menu_offers, Icons.Default.LocalOffer),
    MenuItem(R.string.menu_profile, Icons.Default.Person),
    MenuItem(R.string.menu_orders, Icons.Default.Receipt),
    MenuItem(R.string.menu_favorites, Icons.Default.Favorite),
    MenuItem(R.string.menu_contact, Icons.Default.ContactSupport),
    MenuItem(R.string.menu_about, Icons.Default.Info),
)

@Composable
fun MenuScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = stringResource(R.string.nav_menu),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(menuItems.size) { index ->
                val item = menuItems[index]
                ListItem(
                    headlineContent = {
                        Text(
                            text = stringResource(item.labelRes),
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    leadingContent = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = GreenPrimary,
                            modifier = Modifier.size(28.dp)
                        )
                    },
                    trailingContent = {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                if (index < menuItems.size - 1) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                }
            }
        }
    }
}
