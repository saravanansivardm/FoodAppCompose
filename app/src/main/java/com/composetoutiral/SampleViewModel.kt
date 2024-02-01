package com.composetoutiral

import android.text.TextUtils
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.composetoutiral.datastore.DataStoreRepo
import com.composetoutiral.navigation.Screen
import com.composetoutiral.utils.Helper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val dataStoreRepo: DataStoreRepo
) : ViewModel() {


    fun validateLoginCredentials(emailAddress: String, password: String): Pair<Boolean, String> {
        var result = Pair(true, "")
        if (TextUtils.isEmpty(emailAddress)) {
            result = Pair(false, "Please enter email address")
        } else if (!Helper.isValidEmail(emailAddress)) {
            result = Pair(false, "Please enter valid email address")
        } else if (TextUtils.isEmpty(password)) {
            result = Pair(false, "Please enter password")
        } else if (!Helper.isValidPassword(password)) {
            result = Pair(false, "Please enter valid password")
        }
        return result
    }

    fun navigateForgotPassword(navController: NavController) {
        navController.navigate(route = Screen.ForgotPassword.route)
    }

    fun navigateRegister(navController: NavController) {
        navController.navigate(route = Screen.RegisterScreen.route)
    }

    fun navigateHome(navController: NavController) {
        navController.navigate(route = Screen.RegisterScreen.route)
    }

}