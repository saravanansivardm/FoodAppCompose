package com.composetoutiral.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.composetoutiral.R
import com.composetoutiral.model.FoodStyleModel

class FoodStyleViewModel : ViewModel() {

    private val _foodStyleList: MutableState<Set<FoodStyleModel>> = mutableStateOf(setOf())

    fun getFoodStyleMethod(): List<FoodStyleModel> {
        _foodStyleList.value = _foodStyleList.value + FoodStyleModel(
            R.drawable.japanse_food, "Veg Foodies","200+ people"
        )
        _foodStyleList.value = _foodStyleList.value + FoodStyleModel(
            R.drawable.american_food, "Sweet Lovers","10 people"
        )
        _foodStyleList.value = _foodStyleList.value + FoodStyleModel(
            R.drawable.italian_food, "Non Veg Foodies","100 people"
        )
        return _foodStyleList.value.toList()
    }
}