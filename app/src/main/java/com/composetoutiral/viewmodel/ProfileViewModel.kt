package com.composetoutiral.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.composetoutiral.datastore.DataStoreRepo
import com.composetoutiral.db.LoginEntity
import com.composetoutiral.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataRepository: DataStoreRepo,
) : ViewModel() {

    fun navigateLogin(navController: NavController) {
        /*navController.navigate(Screen.LoginScreen.route){
            popUpTo(Screen.LoginScreen.route) {
                inclusive = true
            }
        }*/
    }

    fun saveLogoutPref(key: String, value: String) {
        viewModelScope.launch {
            dataRepository.putString(key, value)
        }
    }

}