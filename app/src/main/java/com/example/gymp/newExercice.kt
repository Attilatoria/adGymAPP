package com.example.gymp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
fun GymApp(exerciceDao: ExerciceDao, navController: NavController) {
    var exerciseName by remember { mutableStateOf("") }
    var bodyPart by remember { mutableStateOf("") }
    var trainingTime by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Menu(navController)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Add New Exercise")

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

        Button(
            onClick = {
                val newExercise = userId?.let {
                    Exercice(
                        ExerciceName = exerciseName,
                        BodyPart = bodyPart,
                        TrainingTime = trainingTime.toDouble(),
                        TrainingDate = LocalDate.now().toString(),
                        TrainingDone = false,
                        idUserExercice = it
                    )
                }
                GlobalScope.launch {
                    if (newExercise != null) {
                        exerciceDao.insert(newExercise)
                    }
                }
                exerciseName = ""
                bodyPart = ""
                trainingTime = ""
            },
            enabled = exerciseName.isNotEmpty() && bodyPart.isNotEmpty() && trainingTime.isNotEmpty()
        ) {
            Text(text = "Add Exercise")
        }
    }
}

