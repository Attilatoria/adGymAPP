package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun DoneExerciseList(doneExercises: List<Exercise>, navController : NavController) {
    Button(onClick = { navController.navigate("pagep") }) {
        Text(text = "Back")
    }

    Column {
        Text(text = "Done Exercises:", modifier = Modifier.padding(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            items(doneExercises) { exercise ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Exercise: ${exercise.name}")
                        Text(text = "Body part: ${exercise.bodyPart}")
                        Text(text = "Training time: ${exercise.trainingTime} minutes")
                        Text(text = "Date: ${exercise.date}")
                    }
                }
            }
        }
    }
}
