package com.grocery.app.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.grocery.app.presentation.cart.CartScreen
import com.grocery.app.presentation.grocerydetails.GroceryDetailsScreen
import com.grocery.app.presentation.home.HomeScreen
import com.grocery.app.presentation.profile.ProfileScreen
import com.grocery.app.presentation.settings.SettingsScreen
import com.grocery.app.ui.components.GroceryBottomNavigation

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val hideBottomBar = currentRoute in listOf(
        Screen.Profile.route,
        Screen.Settings.route,
        Screen.GroceryDetails.route
    )

    val navigateTo: (Screen) -> Unit = { screen ->
        navController.navigate(screen.route) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    Scaffold(
        bottomBar = {
            if (!hideBottomBar) {
                GroceryBottomNavigation(currentRoute = currentRoute, onNavigate = navigateTo)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding),
            enterTransition  = { fadeIn(tween(280))  + slideInHorizontally(tween(280))  { it / 10 } },
            exitTransition   = { fadeOut(tween(200)) },
            popEnterTransition  = { fadeIn(tween(280)) },
            popExitTransition   = { fadeOut(tween(200)) + slideOutHorizontally(tween(280)) { it / 10 } }
        ) {
            composable(Screen.Home.route) {
                HomeScreen(onCategoryClick = { categoryId ->
                    if (categoryId == "5") navController.navigate(Screen.GroceryDetails.route)
                })
            }
            composable(Screen.Cart.route)     { CartScreen() }
            composable(Screen.Settings.route) {
                SettingsScreen(onNavigateToProfile = { navController.navigate(Screen.Profile.route) })
            }
            composable(Screen.Profile.route) {
                ProfileScreen(onBack = { navController.popBackStack() })
            }
            composable(Screen.GroceryDetails.route) {
                GroceryDetailsScreen(onBack = { navController.popBackStack() })
            }
        }
    }
}
