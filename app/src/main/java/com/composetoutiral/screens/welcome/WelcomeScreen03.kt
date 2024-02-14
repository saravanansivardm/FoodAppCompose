package com.composetoutiral.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.viewmodel.WelcomeViewModel

@Composable
fun WelcomeScreen03(
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
                text = stringResource(id = R.string.welcome_txt_03),
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
                .padding(20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    /*navController.navigate(AUTH_GRAPH_ROUTE) {
                        popUpTo(WELCOME_GRAPH_ROUTE)
                    }*/
                    welcomeViewModel.saveNamePref("firstname", "0")
                    welcomeViewModel.navigateToLogin(navController)
                },
                shape = CutCornerShape(10),
                modifier = Modifier
                    .width(200.dp)
                    .height(70.dp)
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(
                    text = stringResource(id = R.string.get_started),
                    color = Color.White,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewWelcomeScreen03() {
    WelcomeScreen03(
        navController = rememberNavController())
}