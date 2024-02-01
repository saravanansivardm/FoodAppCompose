package com.composetoutiral.screens.selectfavouritefood

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
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
import com.composetoutiral.model.SelectFoodStyle
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.ui.theme.YellowColorDarkLight
import com.composetoutiral.viewmodel.SelectFavouriteFoodViewModel

@Composable
fun SelectFavFoodScreen03(
    navController: NavController,
    selectFavouriteFoodViewModel: SelectFavouriteFoodViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val selectedValue = remember { mutableStateOf("") }
    val label = "Item"
    /*
    lateinit var favFoodList: List<SelectFoodStyle>
    favFoodList = ArrayList()

    favFoodList = favFoodList + SelectFoodStyle(
        "Vegan", "Stay healthy with unique vegan menu.", R.drawable.japanse_food
    )
    favFoodList = favFoodList + SelectFoodStyle(
        "Vegetarian", "We recommend the best food for you.", R.drawable.american_food
    )
    favFoodList = favFoodList + SelectFoodStyle(
        "Meat Lover", "Meat lover gonna love the special resto.", R.drawable.italian_food
    )
    favFoodList = favFoodList + SelectFoodStyle(
        "Random", "Try a variety of typical food in the world", R.drawable.indonasian_food
    )*/

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 50.dp, bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.food_style),
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp),
                style = TextStyle(
                    fontSize = 28.sp, fontWeight = FontWeight.Normal, lineHeight = 35.sp
                )
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 32.sp, fontWeight = FontWeight.W500
                    )
                ) {
                    append("3")
                }
                append("/3")
            }
            Text(
                text = annotatedString,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 16.dp),
                style = TextStyle(
                    fontSize = 24.sp, fontWeight = FontWeight.Normal,
                )
            )
        }
        LazyColumn(modifier = Modifier.padding(top = 32.dp)) {
            itemsIndexed(selectFavouriteFoodViewModel.getFoodStyle()) { index, item ->
                Card(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 4.dp)
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
                                        color = YellowColorDarkLight,
                                        shape = RoundedCornerShape(5.dp),
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = selectFavouriteFoodViewModel.getFoodStyle()[index].foodImage),
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
                                    text = selectFavouriteFoodViewModel.getFoodStyle()[index].food,
                                    color = Color.Black, textAlign = TextAlign.Start,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = selectFavouriteFoodViewModel.getFoodStyle()[index].foodDesc,
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

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .clickable {
                    selectFavouriteFoodViewModel.saveNamePref("firstname", "3")
                    selectFavouriteFoodViewModel.navigateSkipNowOption(navController)
                },
            text = stringResource(id = R.string.skip_now),
            color = Color.Gray,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
        )
        Button(
            onClick = {
//                navController.navigate(route = Screen.SelectFavFoodScreen04.route)
                selectFavouriteFoodViewModel.navigateToFavFoodScreen04(navController)
            },
            shape = RoundedCornerShape(40),
            modifier = Modifier
                .width(100.dp)
                .padding(bottom = 20.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(YellowColor),
        ) {
            Text(
                text = stringResource(id = R.string.submit),
                color = Color.Black,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
        }
    }
}

@Composable
@Preview
fun PreviewSelectFavFoodScreen03() {
    SelectFavFoodScreen03(navController = rememberNavController())
}