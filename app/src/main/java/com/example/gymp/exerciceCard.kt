package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
fun DisplayExercisesFromDatabase(exerciceDao: ExerciceDao, navController : NavController) {
    // Variable pour stocker les exercices de la base de données
    val exercices: MutableState<List<Exercice>> = remember { mutableStateOf(emptyList()) }

    // Utilisation de LaunchedEffect pour récupérer les exercices dès que l'écran est composé
    LaunchedEffect(true) {
        // Récupération des exercices de la base de données dans un thread séparé

        val exercisesFromDb = userId?.let { exerciceDao.getExercicesByUserId(it) }
        // Mise à jour de la liste d'exercices dans le thread principal
        if (exercisesFromDb != null) {
            exercices.value = exercisesFromDb
        }
    }

    Column {
        Menu(navController)
        Spacer(modifier = Modifier.padding(10.dp))
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            item {
                Text(text = "List of Exercises")
                Spacer(modifier = Modifier.height(8.dp))
            }
            // Utilisation de la fonction items() pour afficher chaque exercice dans la liste
            items(exercices.value) { exercise ->
                Text(text = "Exercise Name: ${exercise.ExerciceName}")
                Text(text = "Body Part: ${exercise.BodyPart}")
                Text(text = "Training Time: ${exercise.TrainingTime}")
                Text(text = "Training Date: ${exercise.TrainingDate}")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    GlobalScope.launch {
                        exerciceDao.deleteExercice(globalExerciseName, userId)
                    }
                }) {
                    Text(text = "finished")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
