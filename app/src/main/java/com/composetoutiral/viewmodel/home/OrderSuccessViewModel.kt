package com.composetoutiral.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.composetoutiral.navigation.Screen

class OrderSuccessViewModel : ViewModel() {

    fun navigateToHome(navController: NavController) {
        navController.navigate(route = Screen.AppScaffold.route)
    }

    fun navigateToTrackOrder(navController: NavController) {
        navController.navigate(route = Screen.OrderStatusScreen.route)
    }
}