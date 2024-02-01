package com.composetoutiral.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.composetoutiral.R
import com.composetoutiral.datastore.DataStoreRepo
import com.composetoutiral.model.SelectFavFoodFlavour
import com.composetoutiral.model.SelectFavFoodModel
import com.composetoutiral.model.SelectFoodStyle
import com.composetoutiral.navigation.Screen
import com.composetoutiral.utils.NavScreenConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectFavouriteFoodViewModel @Inject constructor(
    private val dataRepository: DataStoreRepo
) : ViewModel() {

    private val _favFoodList: MutableState<Set<SelectFavFoodModel>> = mutableStateOf(setOf())
    private val _favFlavourList: MutableState<Set<SelectFavFoodFlavour>> = mutableStateOf(setOf())
    private val _favFoodStyleList: MutableState<Set<SelectFoodStyle>> = mutableStateOf(setOf())


    fun getFavFood(): List<SelectFavFoodModel> {
        _favFoodList.value = _favFoodList.value + SelectFavFoodModel(
            "Japanese Food", "Eat with the fresh food from Japan.", R.drawable.japanse_food
        )

        _favFoodList.value = _favFoodList.value + SelectFavFoodModel(
            "American Food", "Keep healthy with the vegetables food.", R.drawable.american_food
        )
        _favFoodList.value = _favFoodList.value + SelectFavFoodModel(
            "Italian Food", "Make your day always sweet.", R.drawable.italian_food
        )
        _favFoodList.value = _favFoodList.value + SelectFavFoodModel(
            "Indonesian Food", "Try variety of typical Indonesian food", R.drawable.indonasian_food
        )
        return _favFoodList.value.toList()
    }

    fun getFavFlavour(): List<SelectFavFoodFlavour> {
        _favFlavourList.value = _favFlavourList.value + SelectFavFoodFlavour(
            "Spicy Food", "Burn your day with spicy delicious food.", R.drawable.japanse_food
        )
        _favFlavourList.value = _favFlavourList.value + SelectFavFoodFlavour(
            "Tasteful Food", "Fill your lunch with various flavours.", R.drawable.american_food
        )
        _favFlavourList.value = _favFlavourList.value + SelectFavFoodFlavour(
            "Sweet Food", "Make your day always sweet.", R.drawable.italian_food
        )
        _favFlavourList.value = _favFlavourList.value + SelectFavFoodFlavour(
            "Any Food", "Try a variety of typical food in the world.", R.drawable.indonasian_food
        )
        return _favFlavourList.value.toList()
    }

    fun getFoodStyle(): List<SelectFoodStyle> {
        _favFoodStyleList.value = _favFoodStyleList.value + SelectFoodStyle(
            "Vegan", "Stay healthy with unique vegan menu.", R.drawable.japanse_food
        )
        _favFoodStyleList.value = _favFoodStyleList.value + SelectFoodStyle(
            "Vegetarian", "We recommend the best food for you.", R.drawable.american_food
        )
        _favFoodStyleList.value = _favFoodStyleList.value + SelectFoodStyle(
            "Meat Lover", "Meat lover gonna love the special resto.", R.drawable.italian_food
        )
        _favFoodStyleList.value = _favFoodStyleList.value + SelectFoodStyle(
            "Random", "Try a variety of typical food in the world", R.drawable.indonasian_food
        )
        return _favFoodStyleList.value.toList()
    }

    fun navigateSkipNowOption(navController: NavController) {
       /* navController.navigate(NavScreenConstants.BOTTOM_GRAPH_ROUTE) {
            popUpTo(NavScreenConstants.FAV_FOOD_GRAPH_ROUTE)
        }*/
        navController.navigate(Screen.AppScaffold.route) {
            popUpTo(Screen.SelectFavFoodScreen01.route) {
                inclusive = true
            }
        }
    }

    fun navigateToFavFoodScreen02(navController: NavController) {
        navController.navigate(route = Screen.SelectFavFoodScreen02.route) {
            popUpTo(Screen.SelectFavFoodScreen02.route) {
                inclusive = true
            }
        }

    }

    fun navigateToFavFoodScreen03(navController: NavController) {
        navController.navigate(route = Screen.SelectFavFoodScreen03.route)
    }

    fun navigateToFavFoodScreen04(navController: NavController) {
        navController.navigate(route = Screen.SelectFavFoodScreen04.route)
    }

    fun navigateToHomePage(navController: NavController) {
        /*navController.navigate(NavScreenConstants.BOTTOM_GRAPH_ROUTE) {
            popUpTo(NavScreenConstants.FAV_FOOD_GRAPH_ROUTE)
        }*/
        navController.navigate(Screen.AppScaffold.route) {
            popUpTo(Screen.SelectFavFoodScreen01.route) {
                inclusive = true
            }
        }
    }

    fun saveNamePref(key: String, value: String) {
        viewModelScope.launch {
            dataRepository.putString(key, value)
        }
    }
}