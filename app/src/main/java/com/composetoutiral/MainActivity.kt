package com.composetoutiral

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.composetoutiral.navigation.LoginNavigationHost
import com.composetoutiral.navigation.RootNavigationGraph
import com.composetoutiral.ui.theme.ComposeToutiralTheme
import com.composetoutiral.ui.theme.YellowColor
import com.composetoutiral.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = YellowColor
            ) {
                val s2 = viewModel.getNamePref()
                Log.e("s2_main_log", s2.toString())
//                if (s2.isNullOrEmpty()) {
                    /* navController = rememberNavController()
                     RootNavigationGraph(navController = rememberNavController(), s2)
 //                    MainScreen()*/

                    val navController = rememberNavController()
                    val navBarNavController = rememberNavController()
                    LoginNavigationHost(navController, navBarNavController, s2)
//                }

//
            }
        }
    }
}
