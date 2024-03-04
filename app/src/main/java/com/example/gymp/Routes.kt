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
        composable("newe"){exercice(navController)}
        composable("folow"){
            nameExercice?.let { it1 ->
                selectedBodyPart?.let { it2 ->
                    trainingTime?.let { it3 ->
                        selectedDate?.let { it4 ->
                            ExerciceCard(name = it1,
                                bodyPart = it2,
                                time = it3,
                                date = it4
                            )
                        }
                    }
                }
            }
        }
        composable("pagep"){pageP(navController)}
        composable("set"){ settings(navController) }




    }
}