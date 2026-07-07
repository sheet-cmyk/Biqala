package com.grocery.app.navigation

sealed class Screen(val route: String) {
    object Home           : Screen("home")
    object Cart           : Screen("cart")
    object Settings       : Screen("settings")
    object Profile        : Screen("profile")
    object GroceryDetails : Screen("grocery_details")
}
