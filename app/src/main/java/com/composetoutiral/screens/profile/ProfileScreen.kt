package com.composetoutiral.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = hiltViewModel(),
    logout: () -> Unit
) {

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    stringResource(id = R.string.profile),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
        )
    }) { contentPadding ->
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile_image),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Transparent, CircleShape)
                            .background(YellowColor)   // add a border (optional)
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))
                Column {
                    Text(
                        text = "Farhan Fauzan",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(top = 4.dp, start = 4.dp)
                    )
                    Text(
                        text = "Supreme Vegetarian",
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp, fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(top = 2.dp, start = 4.dp)
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.personal_information),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(top = 16.dp, start = 4.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        imageVector = Icons.Default.LocationOn,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 16.dp),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = stringResource(id = R.string.location),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
                    )
                }
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp),
                    contentDescription = ""
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(0.5.dp)
            )
            //Payment
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.payments),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 16.dp),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = stringResource(id = R.string.payment),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
                    )
                }
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp),
                    contentDescription = ""
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(0.5.dp)
            )
            //Information
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        imageVector = Icons.Default.Info,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 16.dp),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = stringResource(id = R.string.information),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
                    )
                }
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp),
                    contentDescription = ""
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(0.5.dp)
            )
            //Security
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.security),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 16.dp),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = stringResource(id = R.string.security),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
                    )
                }
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp),
                    contentDescription = ""
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()  //fill the max height
                    .height(0.5.dp)
            )
            Text(
                text = stringResource(id = R.string.notification),
                color = Color.Gray,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(top = 16.dp, start = 4.dp)
            )
            //Discount Notification
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.discount),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 16.dp),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Text(
                        text = stringResource(id = R.string.discount_notification),
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
                    )
                }
                // Declaring a boolean value for storing checked state
                val mCheckedState = remember { mutableStateOf(false) }

                // Creating a Switch, when value changes,
                // it updates mCheckedState value
                Switch(
                    checked = mCheckedState.value,
                    onCheckedChange = { mCheckedState.value = it },
                    modifier = Modifier.padding(end = 24.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        profileViewModel.saveLogoutPref("firstname", "0")
                        logout()
                        profileViewModel.navigateLogin(navController)
                    },
                    shape = CutCornerShape(10),
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                ) {
                    Text(
                        text = stringResource(id = R.string.logout_txt),
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController(), logout = {})
}