/*
package com.composetoutiral.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composetoutiral.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val repository: DataStoreManager
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    //    private val _startDestination: MutableState<String> = mutableStateOf("")
    private val _startDestination: MutableState<String> =
        mutableStateOf("auth")
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                Log.e("completed_log", completed.toString())
                if (completed) {
                    _startDestination.value = "bottom_nav"
//                    _startDestination.value = Screen.HomeScreen.route
                } else {
                    _startDestination.value = "auth"
                }
            }
            _isLoading.value = false
        }
    }

}*/
