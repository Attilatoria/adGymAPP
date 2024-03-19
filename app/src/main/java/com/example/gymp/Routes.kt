package com.example.gymp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigator(appDatabase: AppDatabase) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { Greeting(navController) }
        composable("detail") { singIN(navController, appDatabase) }
        composable("newe") { GymApp(exerciceDao = appDatabase.exerciceDao(), navController ) }
        composable("folow"){DisplayExercisesFromDatabase(exerciceDao = appDatabase.exerciceDao(),navController )}
        composable("pagep"){pageP(navController)}
        composable("set"){ settings(navController, appDatabase.userDao()) }
//        composable("mes"){SendMessage(navController)}

    }
}