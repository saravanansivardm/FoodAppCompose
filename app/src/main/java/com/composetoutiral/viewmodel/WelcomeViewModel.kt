package com.composetoutiral.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.composetoutiral.datastore.DataStoreRepo
import com.composetoutiral.navigation.Screen
import com.composetoutiral.utils.NavScreenConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val dataRepository: DataStoreRepo
) : ViewModel() {

    fun navigateToBackScreen(navController: NavController) {
        navController.navigate(route = Screen.WelcomeScreen01.route) {
            popUpTo(Screen.WelcomeScreen01.route) {
                inclusive = true
            }
        }
    }

    fun navigateToWelcomeScreen02(navController: NavController) {
        navController.navigate(route = Screen.WelcomeScreen02.route)
    }

    fun navigateToWelcomeScreen03(navController: NavController) {
        navController.navigate(route = Screen.WelcomeScreen03.route)
    }

    fun navigateToLogin(navController: NavController) {
        /*navController.navigate(NavScreenConstants.AUTH_GRAPH_ROUTE) {
            popUpTo(NavScreenConstants.WELCOME_GRAPH_ROUTE)
        }*/
        navController.navigate(route = Screen.LoginScreen.route) {
            popUpTo(Screen.WelcomeScreen03.route) {
                inclusive = true
            }
        }
    }

    fun saveNamePref(key: String, value: String) {
        viewModelScope.launch {
            dataRepository.putString(key, value)
        }
    }
}