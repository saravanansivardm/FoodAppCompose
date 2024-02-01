package com.composetoutiral.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composetoutiral.screens.bottomnavscreens.HomeScreen
import com.composetoutiral.utils.NavScreenConstants
import com.composetoutiral.utils.NavScreenConstants.BOTTOM_GRAPH_ROUTE

@Composable
fun RootNavigationGraph(navController: NavHostController, s2: String?) {
    Log.e("s2_root_log", s2.toString())

    val s23 = if (s2.isNullOrEmpty() || s2 == "2" || s2 == "3" || s2 == "4") {
        NavScreenConstants.AUTH_GRAPH_ROUTE
    } else {
        BOTTOM_GRAPH_ROUTE
    }
    Log.e("s23_nav01_log", s23)
    NavHost(
        navController = navController,
        startDestination = s23,
        route = NavScreenConstants.ROOT_GRAPH_ROUTE
    ) {
//        authNavGraph(navController = navController, s2.toString())
        composable(route = BOTTOM_GRAPH_ROUTE) {
            HomeScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}