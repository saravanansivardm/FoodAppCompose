package com.composetoutiral.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.composetoutiral.viewmodel.home.OrderSuccessViewModel

@Composable
fun OrderSuccessScreen(
    navController: NavController,
    orderSuccessViewModel: OrderSuccessViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.order_on_the_way),
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
        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clickable {
                        orderSuccessViewModel.navigateToHome(navController)
                    },
                text = stringResource(id = R.string.back_to_home),
                color = Color.Black,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
            /*Text(
                modifier = Modifier.clickable {
                    orderSuccessViewModel.navigateToTrackOrder(navController)
                },
                text = stringResource(id = R.string.track_your_order),
                color = Color.Black,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )*/
            Button(
                onClick = {
                    orderSuccessViewModel.navigateToTrackOrder(navController)
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .wrapContentWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(YellowColor),
            ) {
                Text(
                    text = stringResource(id = R.string.track_your_order),
                    color = Color.Black,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewOrderSuccessScreen() {
    OrderSuccessScreen(navController = rememberNavController())
}