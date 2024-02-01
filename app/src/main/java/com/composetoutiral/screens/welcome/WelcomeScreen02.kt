package com.composetoutiral.screens.welcome

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun WelcomeScreen02(
    navController: NavController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
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
                text = stringResource(id = R.string.welcome_txt_02),
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
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.clickable {
                    /*navController.navigate(route = Screen.WelcomeScreen01.route) {
                        popUpTo(Screen.WelcomeScreen01.route) {
                            inclusive = true
                        }
                    }*/
                    welcomeViewModel.navigateToBackScreen(navController)
                },
                text = stringResource(id = R.string.back),
                color = Color.White,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier.clickable {
//                    navController.navigate(route = Screen.WelcomeScreen03.route)
                    welcomeViewModel.navigateToWelcomeScreen03(navController)
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
fun PreviewWelcomeScreen02() {
    WelcomeScreen02(navController = rememberNavController())
}