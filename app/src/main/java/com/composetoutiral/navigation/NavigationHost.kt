package com.composetoutiral.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composetoutiral.screens.CheckoutOrderScreen
import com.composetoutiral.screens.bottomnavscreens.FoodStyleScreen
import com.composetoutiral.screens.bottomnavscreens.HomeScreen
import com.composetoutiral.screens.bottomnavscreens.YourOrderScreen
import com.composetoutiral.screens.profile.ProfileScreen


@Composable
fun NavigationHost(
    navController: NavController,
    logout: () -> Unit
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = NavigationScreen.HomeScreen.route
    ) {
        composable(NavigationScreen.HomeScreen.route) { HomeScreen() }
        composable(NavigationScreen.YourOrderScreen.route) { YourOrderScreen(navController = navController) }
        composable(NavigationScreen.FoodStyleScreen.route) { FoodStyleScreen(navController = navController) }
        composable(Screen.CheckoutOrderScreen.route) { CheckoutOrderScreen(navController = navController) }
        composable(NavigationScreen.ProfileScreen.route) {
            ProfileScreen(navController) {
                logout()
            }
        }
    }
}