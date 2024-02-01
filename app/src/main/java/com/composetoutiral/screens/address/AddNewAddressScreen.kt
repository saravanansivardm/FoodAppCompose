package com.composetoutiral.screens.address

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.composetoutiral.R
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.ui.theme.YellowColorDarkLight
import com.composetoutiral.ui.theme.YellowColorLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewAddressScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    fun validate(email: String, password: String) {
        isError = if (email.isEmpty()) {
            true
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

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
                        stringResource(id = R.string.add_new_address),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black,
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                },
            )
        },
    ) { contentPadding ->
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(contentPadding)
        ) {
            Text(
                text = stringResource(id = R.string.add_address),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(top = 16.dp, start = 4.dp)
            )
            Text(
                text = stringResource(id = R.string.name_txt),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(top = 16.dp, start = 8.dp)
            )
            TextField(
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.enter_your_name),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                value = email,
                onValueChange = {
                    email = it
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                ),
                placeholder = { Text(text = stringResource(id = R.string.enter_your_name)) },
            )

            Text(
                text = stringResource(id = R.string.address_txt),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(top = 16.dp, start = 8.dp)
            )
            TextField(
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.enter_your_address),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                value = address,
                onValueChange = {
                    address = it
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                ),
                placeholder = { Text(text = stringResource(id = R.string.enter_your_address)) },
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                YellowColorLight,
                                YellowColorDarkLight
                            )
                        ),
                        shape = RoundedCornerShape(5.dp),
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        imageVector = Icons.Default.LocationOn,
                        modifier = Modifier
                            .size(45.dp)
                            .padding(start = 16.dp),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(id = R.string.add_pin_point),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    )
                }
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 16.dp),
                    contentDescription = ""
                )
            }
            Text(
                text = stringResource(id = R.string.phone),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(top = 16.dp, start = 4.dp)
            )
            TextField(
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.enter_your_phone_number),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                value = phone,
                onValueChange = {
                    phone = it
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 16.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Phone
                ),
                keyboardActions = KeyboardActions(
                ),
                placeholder = { Text(text = stringResource(id = R.string.enter_your_phone_number)) },
            )
            Box(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = {
                    },
                    shape = CutCornerShape(10),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                        .align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(YellowColor),
                ) {
                    Text(
                        text = stringResource(id = R.string.done_txt),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewAddNewAddressScreen() {
    AddNewAddressScreen(navController = rememberNavController())
}