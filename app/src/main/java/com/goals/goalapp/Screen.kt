package com.goals.goalapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import com.goals.goalapp.navigation.NavigationScreen

sealed class Screen(val route: String) {
    data object LoginScreen : Screen("login_screen")
    data object RegisterScreen : Screen("register_screen")

    data object AppScaffold : Screen("app_scaffold")
    data object Friends: Screen("friends_screen")
}
