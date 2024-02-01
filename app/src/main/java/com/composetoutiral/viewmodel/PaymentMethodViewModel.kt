package com.composetoutiral.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.composetoutiral.R
import com.composetoutiral.model.PaymentMethodModel

class PaymentMethodViewModel : ViewModel() {

    private val _paymentMethodList: MutableState<Set<PaymentMethodModel>> = mutableStateOf(setOf())

    fun getPaymentMethod(): List<PaymentMethodModel> {
        _paymentMethodList.value = _paymentMethodList.value + PaymentMethodModel(
            R.drawable.japanse_food, "Pay cash on delivery", "$0.00"
        )
        _paymentMethodList.value = _paymentMethodList.value + PaymentMethodModel(
            R.drawable.american_food, "Credit card", "$1.20"
        )
        _paymentMethodList.value = _paymentMethodList.value + PaymentMethodModel(
            R.drawable.italian_food, "Paypal", ""
        )

        return _paymentMethodList.value.toList()
    }
}