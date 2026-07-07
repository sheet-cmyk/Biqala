package com.grocery.app.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.grocery.app.R
import com.grocery.app.navigation.Screen
import com.grocery.app.ui.theme.GreenPrimary

data class BottomNavItem(val screen: Screen, val labelRes: Int, val icon: ImageVector)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Cart,     R.string.nav_cart,     Icons.Default.ShoppingCart),
    BottomNavItem(Screen.Home,     R.string.nav_home,     Icons.Default.Home),
    BottomNavItem(Screen.Settings, R.string.nav_settings, Icons.Default.Settings),
)

@Composable
fun GroceryBottomNavigation(currentRoute: String?, onNavigate: (Screen) -> Unit) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        bottomNavItems.forEach { item ->
            val selected = currentRoute == item.screen.route
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigate(item.screen) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.labelRes),
                        modifier = Modifier.size(26.dp),
                        tint = if (selected) GreenPrimary else Color.Black
                    )
                },
                label = { Text(stringResource(item.labelRes), color = if (selected) GreenPrimary else Color.Black) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = GreenPrimary, unselectedIconColor = Color.Black,
                    selectedTextColor = GreenPrimary, unselectedTextColor = Color.Black,
                    indicatorColor = Color(0xFFC8E6C9)
                )
            )
        }
    }
}
