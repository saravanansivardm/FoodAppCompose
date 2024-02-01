package com.composetoutiral.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.composetoutiral.R
import com.composetoutiral.model.FoodStyleModel
import com.composetoutiral.model.YourOrderModel

class YourOrderViewModel : ViewModel() {

    private val _yourOrderList: MutableState<Set<YourOrderModel>> = mutableStateOf(setOf())

    fun getYourOrderMethod(): List<YourOrderModel> {
        _yourOrderList.value = _yourOrderList.value + YourOrderModel(
            R.drawable.japanse_food, "Okonomiyaki", "$15.00"
        )
        _yourOrderList.value = _yourOrderList.value + YourOrderModel(
            R.drawable.american_food, "Karage Balls", "$3.66"
        )
        _yourOrderList.value = _yourOrderList.value + YourOrderModel(
            R.drawable.italian_food, "Sushite", "$2.57"
        )
        return _yourOrderList.value.toList()
    }
}