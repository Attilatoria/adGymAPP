package com.example.gymp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigator(appDatabase: AppDatabase) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { Greeting(navController, appDatabase ) }
        composable("detail") { singIN(navController, appDatabase) }
        composable("newe"){GymApp(exercises = mutableListOf(), navController)}
        composable("folow"){DoneExerciseList(doneExercises = mutableListOf(),navController)}
        composable("pagep"){pageP(navController)}
        composable("set"){ settings(navController) }


    }
}