package com.composetoutiral.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composetoutiral.TestLoginScreen
import com.composetoutiral.screens.CheckoutOrderScreen
import com.composetoutiral.screens.OrderStatusScreen
import com.composetoutiral.screens.OrderSuccessScreen
import com.composetoutiral.screens.PaymentMethodScreen
import com.composetoutiral.screens.auth.ForgotPasswordScreen
import com.composetoutiral.screens.auth.LoginScreen
import com.composetoutiral.screens.auth.RegisterScreen
import com.composetoutiral.screens.auth.VerificationScreen
import com.composetoutiral.screens.bottomnavscreens.AppScaffold
import com.composetoutiral.screens.bottomnavscreens.FoodStyleScreen
import com.composetoutiral.screens.bottomnavscreens.YourOrderScreen
import com.composetoutiral.screens.selectfavouritefood.SelectFavFoodScreen01
import com.composetoutiral.screens.selectfavouritefood.SelectFavFoodScreen02
import com.composetoutiral.screens.selectfavouritefood.SelectFavFoodScreen03
import com.composetoutiral.screens.selectfavouritefood.SelectFavFoodScreen04
import com.composetoutiral.screens.welcome.WelcomeScreen01
import com.composetoutiral.screens.welcome.WelcomeScreen02
import com.composetoutiral.screens.welcome.WelcomeScreen03

@Composable
fun LoginNavigationHost(
    navController: NavHostController,
    navBarNavController: NavController,
    s2: String?
) {
    Log.e("s2_root_log", s2.toString())

    val s23 = if (s2.isNullOrEmpty() || s2 == "null") {
        Screen.WelcomeScreen01.route
    } else if (s2 == "0") {
        Screen.LoginScreen.route
    } else if (s2 == "1") {
        Screen.Verification.route
    } else if (s2 == "2") {
        Screen.SelectFavFoodScreen01.route
    } else if (s2 == "3") {
        Screen.AppScaffold.route
    } else if (s2 == "4") {
        Screen.AppScaffold.route
    } else if (s2 == "5") {
        Screen.ForgotPassword.route
    } else {
        Screen.LoginScreen.route
    }
    NavHost(
        navController = navController,
        startDestination = s23
//        startDestination = Screen.CheckoutOrderScreen.route
    ) {
        composable(
            route = Screen.LoginScreen.route,
            content = {
                LoginScreen(
                    navController = navController,
                    onClick = {}
                )
            })
        composable(
            route = Screen.RegisterScreen.route,
            content = { RegisterScreen(navController = navController) })

        composable(
            route = Screen.ForgotPassword.route,
            content = { ForgotPasswordScreen(navController = navController) })

        composable(
            route = Screen.Verification.route,
            content = { VerificationScreen(navController = navController) })

        composable(
            route = Screen.SelectFavFoodScreen01.route,
            content = { SelectFavFoodScreen01(navController = navController) })

        composable(
            route = Screen.SelectFavFoodScreen02.route,
            content = { SelectFavFoodScreen02(navController = navController) })

        composable(
            route = Screen.SelectFavFoodScreen03.route,
            content = { SelectFavFoodScreen03(navController = navController) })

        composable(
            route = Screen.SelectFavFoodScreen04.route,
            content = { SelectFavFoodScreen04(navController = navController) })

        composable(
            route = Screen.WelcomeScreen01.route,
            content = { WelcomeScreen01(navController = navController) })

        composable(
            route = Screen.WelcomeScreen02.route,
            content = { WelcomeScreen02(navController = navController) })

        composable(
            route = Screen.WelcomeScreen03.route,
            content = { WelcomeScreen03(navController = navController) })

        composable(
            route = Screen.AppScaffold.route,
            content = {
                AppScaffold(navController = navBarNavController) {
                    navController.navigate(Screen.LoginScreen.route){
                        popUpTo(Screen.LoginScreen.route) {
                            inclusive = true
                        }
                    }
                }
            })

        //For home dashboard related contents
        composable(
            route = Screen.FoodStyleScreen.route,
            content = { FoodStyleScreen(navController = navController) })

        composable(
            route = Screen.YourOrderScreen.route,
            content = { YourOrderScreen(navController = navController) })

        /*composable(
            route = Screen.ProfileScreen.route,
            content = { ProfileScreen(navController = navController, logout = {}) })*/

        composable(
            route = Screen.OrderStatusScreen.route,
            content = { OrderStatusScreen(navController = navController) })

        composable(
            route = Screen.OrderSuccessScreen.route,
            content = { OrderSuccessScreen(navController = navController) })

        composable(
            route = Screen.PaymentMethodScreen.route,
            content = { PaymentMethodScreen(navController = navController) })

        composable(
            route = Screen.CheckoutOrderScreen.route,
            content = { CheckoutOrderScreen(navController = navController) })

        composable(
            route = Screen.TestLoginScreen.route,
            content = { TestLoginScreen(navController = navController) })
    }
}