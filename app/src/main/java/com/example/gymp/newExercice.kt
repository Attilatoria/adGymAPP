package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun exercice(navController: NavController){
    var nameExercice by remember { mutableStateOf("") }
    var selectedBodyPart by remember { mutableStateOf("") }
    var trainingTime by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { navController.navigate("pagep") }) {
            Text(text = "Back")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        OutlinedTextField(
            value = nameExercice,
            onValueChange = { nameExercice = it },
            label = { Text("Exercice name") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.padding(12.dp))

        OutlinedTextField(
            value = selectedBodyPart,
            onValueChange = { selectedBodyPart = it },
            label = { Text("what body part?") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )


        Spacer(modifier = Modifier.padding(12.dp))

        OutlinedTextField(
            value = trainingTime,
            onValueChange = { trainingTime = it },
            label = { Text("Training time (minutes)") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.padding(12.dp))

        OutlinedTextField(
            value = selectedDate,
            onValueChange = { selectedDate = it },
            label = { Text("when? (dd/mm/yyyy)") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.padding(24.dp))

        Button(
            onClick = {
                // TODO: Save the exercise details
            },
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Text("Save")
        }
    }
}


