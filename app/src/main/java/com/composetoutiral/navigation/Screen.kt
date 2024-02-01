package com.composetoutiral.navigation


sealed class Screen(
    val route: String,
) {
    /*object Login : Screen(route = "login_screen")
    object Register : Screen(route = "register_screen")
    object Verification : Screen(route = "verification_screen")
    object ForgotPassword : Screen(route = "forgot_password_screen")
    object WelcomeScreen01 : Screen(route = "welcome_screen_01")
    object WelcomeScreen02 : Screen(route = "welcome_screen_02")
    object WelcomeScreen03 : Screen(route = "welcome_screen_03")
    object NewAddressScreen : Screen(route = "new_address_screen")
    object SelectFavFoodScreen01 : Screen(route = "fav_food_screen_01")
    object SelectFavFoodScreen02 : Screen(route = "fav_food_screen_02")
    object SelectFavFoodScreen03 : Screen(route = "fav_food_screen_03")
    object SelectFavFoodScreen04 : Screen(route = "fav_food_screen_04")*/

    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object ForgotPassword : Screen("forgot_password_screen")
    object Verification : Screen("verification_screen")
    object SelectFavFoodScreen01 : Screen("fav_food_screen_01")
    object SelectFavFoodScreen02 : Screen("fav_food_screen_02")
    object SelectFavFoodScreen03 : Screen("fav_food_screen_03")
    object SelectFavFoodScreen04 : Screen("fav_food_screen_04")
    object WelcomeScreen01 : Screen("welcome_screen_01")
    object WelcomeScreen02 : Screen("welcome_screen_02")
    object WelcomeScreen03 : Screen("welcome_screen_03")
    object OrderStatusScreen : Screen("order_status_screen")
    object OrderSuccessScreen : Screen("order_success_screen")
    object PaymentMethodScreen : Screen("payment_method_screen")
    object FoodStyleScreen : Screen("food_style_screen")
//    object ProfileScreen : Screen("profile_screen")
    object YourOrderScreen : Screen("your_order_screen")
    object CheckoutOrderScreen : Screen("check_out_order_screen")
    object TestLoginScreen : Screen("testing_login_screen")

    object BottomBar : Screen("bottom_bar")
    object AppScaffold : Screen("app_scaffold")
}

