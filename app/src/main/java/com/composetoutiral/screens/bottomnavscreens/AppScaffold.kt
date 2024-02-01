package com.composetoutiral.screens.bottomnavscreens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.composetoutiral.navigation.NavigationHost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppScaffold(
    navController: NavController,
    logout: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        scaffoldState = scaffoldState,
    ) {
        NavigationHost(navController = navController) {
            logout()
        }
    }

}