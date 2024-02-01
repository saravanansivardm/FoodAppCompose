package com.composetoutiral.navigation

import androidx.annotation.DrawableRes
import com.composetoutiral.R

sealed class NavigationScreen(val route: String, val title: String, @DrawableRes val icon: Int) {

    object HomeScreen : NavigationScreen(
        route = "home_screen",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object FoodStyleScreen : NavigationScreen(
        route = "food_style_screen",
        title = "FoodStyle",
        icon = R.drawable.ic_settings
    )

    object YourOrderScreen : NavigationScreen(
        route = "your_order_screen",
        title = "YourOrder",
        icon = R.drawable.ic_settings
    )

    object ProfileScreen : NavigationScreen(
        route = "profile_screen",
        title = "Profile",
        icon = R.drawable.ic_chat
    )
}