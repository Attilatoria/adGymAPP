package com.example.gymp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { Greeting(navController) }
        composable("detail") { singIN(navController) }
        composable("pagep"){pageP(navController)}
        composable("newEx"){exercice()}

    }
}