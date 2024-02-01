package com.composetoutiral.screens.welcome

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composetoutiral.R
import com.composetoutiral.navigation.Screen
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.viewmodel.WelcomeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WelcomeScreen01(
    navController: NavController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
        SideEffect {
    //        systemUiController.setSystemBarsColor(Color.White)
            systemUiController.setStatusBarColor(YellowColor)
            systemUiController.setNavigationBarColor(YellowColor)

        }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 250.dp)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_txt_01),
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 28.sp, fontWeight = FontWeight.Normal,
                    lineHeight = 45.sp
                )
            )
            Image(
                imageVector = Icons.Default.AccountBox,
                modifier = Modifier.size(280.dp),
                contentDescription = ""
            )
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier.clickable {
//                    navController.navigate(route = Screen.WelcomeScreen02.route)
                    welcomeViewModel.navigateToWelcomeScreen02(navController)
                },
                text = stringResource(id = R.string.next),
                color = Color.Black,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Composable
@Preview
fun PreviewWelcomeScreen01() {
    WelcomeScreen01(navController = rememberNavController())
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun PreviewDarkWelcomeScreen01() {
    WelcomeScreen01(navController = rememberNavController())
}