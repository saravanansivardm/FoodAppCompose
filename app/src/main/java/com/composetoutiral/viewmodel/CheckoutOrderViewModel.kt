package com.composetoutiral.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.composetoutiral.R
import com.composetoutiral.model.CheckoutOrderModel

class CheckoutOrderViewModel : ViewModel() {

    private val _checkoutOrderList: MutableState<Set<CheckoutOrderModel>> = mutableStateOf(setOf())

    fun getYourOrderMethod(): List<CheckoutOrderModel> {
        _checkoutOrderList.value = _checkoutOrderList.value + CheckoutOrderModel(
            R.drawable.japanse_food, "Okonomiyaki", "$15.00"
        )
        _checkoutOrderList.value = _checkoutOrderList.value + CheckoutOrderModel(
            R.drawable.american_food, "Karage Balls", "$3.66"
        )
        _checkoutOrderList.value = _checkoutOrderList.value + CheckoutOrderModel(
            R.drawable.italian_food, "Sushite", "$2.57"
        )
        return _checkoutOrderList.value.toList()
    }
}