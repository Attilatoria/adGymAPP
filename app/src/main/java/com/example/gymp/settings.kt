package com.example.gymp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController

@Composable
fun settings(navController: NavController) {
    Button(onClick = { navController.navigate("pagep") }) {
        Text(text = "Back")
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Première partie
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texte et bouton pour le prénom
            Text(
                text = "First Name: ${userId?.Firstname ?: ""}",
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            CustomDialog()
        }
        // Deuxième partie
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texte et bouton pour le nom de famille
            Text(
                text = "Last Name: ${userId?.Lastname ?: ""}",
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            CustomDialog()
        }
        // Troisième partie
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texte et bouton pour l'email
            Text(
                text = "Email: ${userId?.Email ?: ""}",
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            CustomDialog()
        }
        // Quatrième partie
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Texte et bouton pour le mot de passe
            Text(
                text = "Password: ${userId?.Password ?: ""}",
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            CustomDialog()
        }
    }
}

@Composable
fun CustomDialog() {
    var showDialog by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Update") },
            text = {
                Column {
                    TextField(
                        value = textFieldValue,
                        onValueChange = { textFieldValue = it },
                        label = { Text("Enter something") }
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
    Button(
        onClick = { showDialog = true },
        modifier = Modifier.width(100.dp)
    ) {
        Text("Update", color = Color.White)
    }
}
