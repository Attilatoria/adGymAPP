package com.example.gymp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun exercice(navController: NavController){
    var nameExercice by remember { mutableStateOf("") }
    var selectedBodyPart by remember { mutableStateOf("") }
    var trainingTime by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var menuExpanded by remember { mutableStateOf(false) } // État pour contrôler l'ouverture du menu

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = nameExercice,
            onValueChange = { nameExercice = it },
            label = { Text("Exercice name") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.padding(12.dp))

        // Texte "What do you want to work?" cliquable pour ouvrir le menu
        Text(
            text = "What do you want to work?",
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clickable {
                    menuExpanded = !menuExpanded // Inverser l'état pour ouvrir/fermer le menu
                }
        )

        // Menu déroulant, ouvert lorsque menuExpanded est vrai
        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = { menuExpanded = false } // Fermer le menu lorsqu'il est rejeté
        ) {
            DropdownMenuItem( text = {"Bras"},
                onClick = {
                    selectedBodyPart = "Bras"
                    menuExpanded = false
                }
            )
            DropdownMenuItem( text = {"Jambe"},
                onClick = {
                    selectedBodyPart = "Jambe"
                    menuExpanded = false
                }
            )
            DropdownMenuItem( text = {"Dos"},
                onClick = {
                    selectedBodyPart = "Dos"
                    menuExpanded = false
                }
            )
            DropdownMenuItem(
                text = {"Torse"},
                onClick = {
                    selectedBodyPart = "Torse"
                    menuExpanded = false
                }
            )
        }


        Spacer(modifier = Modifier.padding(12.dp))

        OutlinedTextField(
            value = trainingTime,
            onValueChange = { trainingTime = it },
            label = { Text("Training time (minutes)") },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.padding(12.dp))

// Champ pour la date  avec un DatePicker
        TextField(
            value = selectedDate.toString(),
            onValueChange = {}, // Ignorer les changements de texte, car il sera rempli par DatePicker
            label = { Text("Date de l'entrainement") },
            trailingIcon = {
                DatePicker(
                    state = rememberDatePickerState()

                )
            },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .width(20.dp)
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


