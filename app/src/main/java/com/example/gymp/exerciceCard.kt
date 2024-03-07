package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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

    Column {
        Button(onClick = { navController.navigate("pagep") }) {
            Text(text = "Back")
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Finished workout:", modifier = Modifier.padding(14.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                
        ) {

            items(doneExercises) { exercisess ->
                Spacer(modifier = Modifier.padding(20.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Exercise: ${exercisess.name}")
                        Text(text = "Body part: ${exercisess.bodyPart}")
                        Text(text = "Training time: ${exercisess.trainingTime} minutes")
                        Text(text = "Date: ${exercisess.date}")
                    }
                }
            }
        }
    }
}
