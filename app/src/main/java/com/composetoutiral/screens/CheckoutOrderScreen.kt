package com.composetoutiral.screens

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.composetoutiral.ui.theme.YellowColorLight
import com.composetoutiral.viewmodel.CheckoutOrderViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutOrderScreen(
    navController: NavController,
    checkoutOrderViewModel: CheckoutOrderViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Rounded.ArrowBack, "")
                }
            },
            title = {
                Text(
                    stringResource(id = R.string.checkout_order),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            },
        )
    }) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(top = 54.dp)
                    .wrapContentWidth()
                    .background(Color.White)
            ) {
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
                    itemsIndexed(checkoutOrderViewModel.getYourOrderMethod()) { index, item ->
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
                                        painter = painterResource(id = checkoutOrderViewModel.getYourOrderMethod()[index].checkOutOrderIcon),
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
                                                text = checkoutOrderViewModel.getYourOrderMethod()[index].checkOutOrderTitle,
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
                Column(
                    modifier = Modifier
                        .background(Color.Blue)
                        .height(300.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, bottom = 100.dp)
                            .height(300.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.clickable {
                            },
                            text = stringResource(id = R.string.total_order),
                            color = Color.Gray,
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        )
                        Row {
                            Card(
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(100.dp)
                                    .padding(end = 16.dp)
                                    .align(Alignment.CenterVertically),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 3.dp
                                ),
                                shape = RoundedCornerShape(5.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = YellowColorLight,
                                ),
                            ) {
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .padding(top = 5.dp),
                                    text = stringResource(id = R.string.free_delivery),
                                    color = Color.Gray,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "$17.66",
                                color = Color.Black,
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            )
                        }
                    }

                    Button(
                        onClick = {
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
    }
}

@Composable
@Preview
fun CheckoutOrderScreenPreview() {
    CheckoutOrderScreen(navController = rememberNavController())
}