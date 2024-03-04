package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExerciseList(exercises: List<Exercise>, navController : NavController) {
    Button(onClick = { navController.navigate("pagep") }) {
        Text(text = "Back")
    }
    Spacer(modifier = Modifier.padding(10.dp))
    for (exercise in exercises) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Exercise: ${exercise.name}")
                Text(text = "Body part: ${exercise.bodyPart}")
                Text(text = "Training time: ${exercise.trainingTime} minutes")
                Text(text = "Date: ${exercise.date}")
            }
        }
    }
    ExerciseList(exercises, navController)
}


