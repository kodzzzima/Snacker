package com.goals.goalapp.ui.bottombar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.goals.goalapp.Screen
import com.goals.goalapp.navigation.NavigationHost
import com.goals.goalapp.navigation.NavigationScreen

@Composable
fun AppScaffold(
    logout: () -> Unit,
) {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar()
        },
        bottomBar = {
            val items = listOf(
                NavigationScreen.HomeScreen,
                NavigationScreen.MyOrdersScreen,
                NavigationScreen.ProfileScreen,
            )

            NavigationBar(
                modifier = Modifier.padding(),
            ) {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.map { navigationItem ->
                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            unselectedIconColor = MaterialTheme.colorScheme.secondary,
                        ),
                        selected = navigationItem.route == currentRoute,
                        label = null,
                        icon = {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = navigationItem.icon,
                                contentDescription = navigationItem.title
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavigationHost(
            navController,
            paddingValues,
            logout,
        )
    }
}
