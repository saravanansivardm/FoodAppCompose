package com.composetoutiral.screens.bottomnavscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composetoutiral.R
import com.composetoutiral.navigation.Screen
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.ui.theme.YellowColorLight
import com.composetoutiral.viewmodel.YourOrderViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourOrderScreen(
    navController: NavController,
    yourOrderModel: YourOrderViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    stringResource(id = R.string.your_order),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
        )
    }) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(top = 54.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.ready_to_checkout).toUpperCase(Locale.current),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    style = TextStyle(
                        fontSize = 16.sp, fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.padding(top = 16.dp, start = 8.dp)
                )
                Card(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(route = Screen.CheckoutOrderScreen.route)
                        }
                        .height(100.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    ),
                    border = BorderStroke(1.dp, Color.Gray),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .background(
                                    color = YellowColorLight,
                                    shape = RoundedCornerShape(
                                        topStart = 10.dp,
                                        bottomStart = 10.dp
                                    ),
                                )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.your_order),
                                contentDescription = "Javascript",
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                                    .padding(5.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(24.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .wrapContentWidth(),
                            ) {
                                Column {
                                    Text(
                                        text = stringResource(id = R.string.view_all_order),
                                        color = Color.Black,
                                        style = TextStyle(
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                    )
                                    Text(
                                        modifier = Modifier.padding(top = 4.dp),
                                        text = "$17.66",
                                        color = Color.Gray,
                                        style = TextStyle(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .wrapContentWidth()
                            ) {
                                Image(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .padding(end = 16.dp),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }
                Text(
                    text = stringResource(id = R.string.order_on_the_way_txt).toUpperCase(Locale.current),
                    color = Color.Black,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 8.dp, top = 16.dp),
                    style = TextStyle(
                        fontSize = 14.sp, fontWeight = FontWeight.Bold,
                        lineHeight = 45.sp
                    )
                )
                LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                    itemsIndexed(yourOrderModel.getYourOrderMethod()) { index, item ->
                        Card(
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 8.dp)
                                .height(90.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 3.dp
                            ),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                        )
                        {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(100.dp)
                                        .background(
                                            color = Color.Transparent,
                                            shape = RoundedCornerShape(5.dp),
                                        )
                                ) {
                                    Image(
                                        painter = painterResource(id = yourOrderModel.getYourOrderMethod()[index].yourOrderIcon),
                                        contentDescription = "Javascript",
                                        modifier = Modifier
                                            .height(80.dp)
                                            .width(70.dp)
                                            .align(Alignment.Center)
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .wrapContentWidth(),
                                    ) {
                                        Column {
                                            Text(
                                                text = yourOrderModel.getYourOrderMethod()[index].yourOrderTitle,
                                                color = Color.Black, textAlign = TextAlign.Start,
                                                style = TextStyle(
                                                    fontSize = 16.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            )
                                            Text(
                                                text = "Fees: 340",
                                                color = Color.Gray, textAlign = TextAlign.Start,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Normal
                                                )
                                            )
                                        }
                                    }

                                    Box(
                                        modifier = Modifier
                                            .wrapContentWidth()
                                    ) {
                                        Image(
                                            imageVector = Icons.Default.KeyboardArrowRight,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .padding(end = 16.dp),
                                            contentDescription = ""
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun YourOrderScreenPreview() {
    YourOrderScreen(navController = rememberNavController())
}