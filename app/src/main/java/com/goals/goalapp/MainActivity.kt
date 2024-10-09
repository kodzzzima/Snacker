package com.goals.goalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.goals.goalapp.ui.bottombar.AppScaffold
import com.goals.goalapp.ui.bottombar.friends.FriendsScreen
import com.goals.goalapp.ui.login.LoginScreen
import com.goals.goalapp.ui.login.RegisterScreen
import com.goals.goalapp.ui.theme.GoalAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()

        setContent {
            GoalAppTheme {
                LoginApplication()
            }
        }
    }
}

@Composable
fun LoginApplication() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(
            route = Screen.LoginScreen.route,
            content = {
                LoginScreen(
                    navController = navController
                )
            }
        )

        composable(
            route = Screen.RegisterScreen.route,
            content = {
                RegisterScreen(navController = navController)
            }
        )

        composable(
            route = Screen.AppScaffold.route,
            content = {
                AppScaffold(
                    logout = { navController.navigate(Screen.LoginScreen.route) },
                )
            }
        )

        composable(
            route = Screen.Friends.route,
            content = {
                FriendsScreen()
            }
        )
    }
}
