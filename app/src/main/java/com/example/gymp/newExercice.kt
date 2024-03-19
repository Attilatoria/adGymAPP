package com.example.gymp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate

var globalExerciseName by mutableStateOf("")
@Composable
fun GymApp(exerciceDao: ExerciceDao, navController: NavController) {
    var exerciseName by remember { mutableStateOf("") }
    var bodyPart by remember { mutableStateOf("") }
    var trainingTime by remember { mutableStateOf("") }
    val selectedBodyParts = remember { mutableStateListOf<String>() }

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

        Box {
            Column {
                Row {
                    Checkbox(
                        checked = selectedBodyParts.contains("Leg's"),
                        onCheckedChange = { isChecked ->
                            if (isChecked)
                                selectedBodyParts.add("Leg's")
                            else
                                selectedBodyParts.remove("Leg's")
                            bodyPart = selectedBodyParts.joinToString(", ")
                        }
                    )
                    Text(text = "Leg's")
                    Spacer(modifier = Modifier.padding(10.dp))
                    Checkbox(
                        checked = selectedBodyParts.contains("Arm"),
                        onCheckedChange = { isChecked ->
                            if (isChecked)
                                selectedBodyParts.add("Arm")
                            else
                                selectedBodyParts.remove("Arm")
                            bodyPart = selectedBodyParts.joinToString(", ")
                        }
                    )
                    Text(text = "Arm")
                }
                Row {
                    Checkbox(
                        checked = selectedBodyParts.contains("Torso"),
                        onCheckedChange = { isChecked ->
                            if (isChecked)
                                selectedBodyParts.add("Torso")
                            else
                                selectedBodyParts.remove("Torso")
                            bodyPart = selectedBodyParts.joinToString(", ")
                        }
                    )
                    Text(text = "Torso")
                    Spacer(modifier = Modifier.padding(10.dp))
                    Checkbox(
                        checked = selectedBodyParts.contains("Back"),
                        onCheckedChange = { isChecked ->
                            if (isChecked)
                                selectedBodyParts.add("Back")
                            else
                                selectedBodyParts.remove("Back")
                            bodyPart = selectedBodyParts.joinToString(", ")
                        }
                    )
                    Text(text = "Back")
                }
            }
        }

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

                globalExerciseName = exerciseName

                GlobalScope.launch {
                    if (newExercise != null) {
                        exerciceDao.insert(newExercise)
                    }
                }
                exerciseName = ""
                bodyPart = ""
                trainingTime = ""
                selectedBodyParts.clear()
            },
            enabled = exerciseName.isNotEmpty() && bodyPart.isNotEmpty() && trainingTime.isNotEmpty()
        ) {
            Text(text = "Add Exercise")
        }
    }
}
