package com.composetoutiral.screens.bottomnavscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composetoutiral.R
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.ui.theme.YellowColorLight
import com.composetoutiral.viewmodel.FoodStyleViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FoodStyleScreen(
    navController: NavController,
    foodStyleViewModel: FoodStyleViewModel = hiltViewModel()
) {
    val selectedValue = remember { mutableStateOf("") }
    val label = "Item"
    val context = LocalContext.current

    Scaffold(
        topBar = {
                TopAppBar(
                    modifier = Modifier.background(Color.Transparent),
                    title = {
                        Text(
                            stringResource(id = R.string.food_style_txt),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black,
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
                )
        },
    ) { contentPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 64.dp, start = 8.dp, end = 8.dp)
            ) {
                val annotatedString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp, fontWeight = FontWeight.Medium
                        )
                    ) {
                        append("Suggestions for you")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp, fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    ) {
                        append(" (nearby)")
                    }
                }
                Text(
                    text = annotatedString,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    color = Color.Black,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
                )
                LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                    itemsIndexed(foodStyleViewModel.getFoodStyleMethod()) { index, item ->
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
                                    .padding(start = 8.dp, end = 8.dp)
                                    .fillMaxWidth()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .wrapContentWidth(),
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start,
                                        modifier = Modifier
                                            .padding(top = 24.dp, start = 8.dp)
                                            .wrapContentWidth()
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
                                                painter = painterResource(id = foodStyleViewModel.getFoodStyleMethod()[index].foodStyleIcon),
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
                                                text = foodStyleViewModel.getFoodStyleMethod()[index].foodStyleTitle,
                                                color = Color.Black, textAlign = TextAlign.Start,
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            )
                                            foodStyleViewModel.getFoodStyleMethod()[index].foodStylePeopleCount
                                            val annotatedString = buildAnnotatedString {
                                                withStyle(
                                                    style = SpanStyle(
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.Medium,
                                                        color = Color.Gray
                                                    )
                                                ) {
                                                    append("Added by ")
                                                }
                                                withStyle(
                                                    style = SpanStyle(
                                                        fontSize = 14.sp,
                                                        fontWeight = FontWeight.Normal,
                                                        color = Color.Black
                                                    )
                                                ) {
                                                    append(foodStyleViewModel.getFoodStyleMethod()[index].foodStylePeopleCount)
                                                }
                                            }
                                            Text(
                                                text = annotatedString,
                                                color = Color.Gray, textAlign = TextAlign.Start,
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Normal
                                                )
                                            )
                                        }
                                    }
                                }
                                Box(
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .padding(top = 24.dp),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Button(
                                        onClick = {
                                        },
                                        shape = RoundedCornerShape(20),
                                        modifier = Modifier
                                            .width(125.dp)
                                            .height(45.dp),
                                        colors = ButtonDefaults.buttonColors(Color.White),
                                        border = BorderStroke(width = 1.dp, color = Color.LightGray)
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.add_to_order),
                                            color = Color.Gray,
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium
                                            )
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
fun PreviewFoodStyleScreen() {
    FoodStyleScreen(navController = rememberNavController())
}
