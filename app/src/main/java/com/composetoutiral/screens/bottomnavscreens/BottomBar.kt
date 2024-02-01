package com.composetoutiral.screens.bottomnavscreens

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.composetoutiral.navigation.NavigationScreen
import com.composetoutiral.ui.theme.YellowColor


@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        NavigationScreen.HomeScreen,
        NavigationScreen.FoodStyleScreen,
        NavigationScreen.YourOrderScreen,
        NavigationScreen.ProfileScreen,
    )

    BottomNavigation(
        elevation = 5.dp,
        backgroundColor = Color.White,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.map {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(
                        text = it.title,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                },
                selected = currentRoute == it.route,
                selectedContentColor = YellowColor,
                unselectedContentColor = Color.Black.copy(0.5f),
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
            )
        }

    }
}