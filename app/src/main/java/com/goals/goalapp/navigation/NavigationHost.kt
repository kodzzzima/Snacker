package com.goals.goalapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.goals.goalapp.Screen
import com.goals.goalapp.ui.bottombar.HomeScreen
import com.goals.goalapp.ui.bottombar.MyOrders
import com.goals.goalapp.ui.bottombar.friends.FriendsScreen
import com.goals.goalapp.ui.bottombar.profile.ProfileScreen
import com.goals.goalapp.ui.bottombar.profile.ProfileViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationHost(
    navController: NavController,
    paddingValues: PaddingValues,
    logout: () -> Unit,
) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController as NavHostController,
        startDestination = NavigationScreen.HomeScreen.route
    ) {
        composable(NavigationScreen.HomeScreen.route) {
            HomeScreen()
        }
        composable(NavigationScreen.MyOrdersScreen.route) {
            MyOrders()
        }
        composable(NavigationScreen.ProfileScreen.route) {
            ProfileScreen(
                navController,
                logout = logout
            )
        }
        composable(Screen.Friends.route) {
            FriendsScreen()
        }
    }
}

sealed class NavigationScreen(val route: String, val title: String, val icon: ImageVector) {
    data object HomeScreen : NavigationScreen(
        route = "home_screen",
        title = "Заказы",
        icon = Icons.Filled.Home
    )

    data object MyOrdersScreen : NavigationScreen(
        route = "my_orders_screen",
        title = "Мои заказы",
        icon = Icons.Filled.AddCircle
    )

    data object ProfileScreen : NavigationScreen(
        route = "profile_screen",
        title = "Профиль",
        icon = Icons.Filled.AccountCircle
    )
}
