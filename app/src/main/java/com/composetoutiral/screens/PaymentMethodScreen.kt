package com.composetoutiral.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.composetoutiral.ui.theme.YellowColorLight
import com.composetoutiral.viewmodel.PaymentMethodViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PaymentMethodScreen(
    navController: NavController,
    paymentMethodViewModel: PaymentMethodViewModel = hiltViewModel()
) {
    val selectedValue = remember { mutableStateOf("") }
    val label = "Item"
    Scaffold(
        topBar = {
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
                        stringResource(id = R.string.payment_method),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                },
            )
        },
    ) { contentPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White).padding(top = 32.dp, start = 8.dp, end = 8.dp)
            ) {
                LazyColumn(modifier = Modifier.padding(top = 32.dp)) {
                    itemsIndexed(paymentMethodViewModel.getPaymentMethod()) { index, item ->
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
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 24.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier
                                        .padding(top = 24.dp, start = 8.dp)
                                        .fillMaxWidth()
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .width(45.dp)
                                            .height(45.dp)
                                            .background(
                                                color = YellowColorLight,
                                                shape = RoundedCornerShape(5.dp),
                                            )
                                    ) {
                                        Image(
                                            painter = painterResource(id = paymentMethodViewModel.getPaymentMethod()[index].paymentIcon),
                                            contentDescription = "Javascript",
                                            modifier = Modifier
                                                .height(30.dp)
                                                .width(30.dp)
                                                .padding(5.dp)
                                                .align(Alignment.Center)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Text(
                                            text = paymentMethodViewModel.getPaymentMethod()[index].paymentTitle,
                                            color = Color.Black, textAlign = TextAlign.Start,
                                            style = TextStyle(
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                        val s1 =
                                            paymentMethodViewModel.getPaymentMethod()[index].paymentFees
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
                                RadioButton(
                                    modifier = Modifier.padding(top = 12.dp),
                                    selected = selectedValue.value == label,
                                    onClick = { selectedValue.value = label }
                                )
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
fun PreviewPaymentMethodScreen() {
    PaymentMethodScreen(navController = rememberNavController())
}