package com.example.gymp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter


data class Exercise(val name: String, val bodyPart: String, val trainingTime: String, val date: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymApp(exercises: MutableList<Exercise>, navController : NavController) {
    var exerciseName by remember { mutableStateOf("") }
    var bodyPart by remember { mutableStateOf("") }
    var trainingTime by remember { mutableStateOf("") }

    Button(onClick = { navController.navigate("pagep") }) {
        Text(text = "Back")
    }

    Column(
    ){
        Spacer(modifier = Modifier.padding(20.dp))
        TopAppBar(title = { Text(text = "Gym Exercises")})

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = exerciseName,
            onValueChange = { exerciseName = it },
            label = { Text("Exercise name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = bodyPart,
            onValueChange = { bodyPart = it },
            label = { Text("Body part") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = trainingTime,
            onValueChange = { trainingTime = it },
            label = { Text("Training time (minutes)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val newExercise = Exercise(
                name = exerciseName,
                bodyPart = bodyPart,
                trainingTime = trainingTime,
                date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            )
            exercises.add(newExercise)
            exerciseName = ""
            bodyPart = ""
            trainingTime = ""
        },
            enabled = (if(exerciseName.isEmpty()) false else true)
        ) {
            Text(text = "Add Exercise")
        }
        ExerciseList(exercises)
    }

}

@Composable
fun ExerciseList(exercises: List<Exercise>, onRemove: (Exercise) -> Unit = {}) {
    val doneExercises = remember { mutableStateListOf<Exercise>() }

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            items(exercises) { exercise ->
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

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(onClick = {
                                doneExercises.add(exercise)
                                onRemove(exercise)
                                
                            }) {
                                Text("Remove")
                            }
                        }
                    }
                }
            }
        }
    }
}