package com.example.gymp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun sendMessage() {
    var selectedCoach by remember { mutableStateOf("Zinedine Zidane") }
    var message by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        DropdownMenu(
            expanded = true,
            onDismissRequest = { false },
            modifier = Modifier.width(200.dp)
        ) {
            DropdownMenuItem(onClick = { selectedCoach = "Zinedine Zidane" }, text = {"Sir Ferguson"})
            DropdownMenuItem(onClick = { selectedCoach = "Sir Ferguson" }, text = {"Sir Ferguson"})
        }

        Spacer(modifier = Modifier.height(100.dp))

        TextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Votre message") },
            maxLines = 5
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Ici, vous pouvez implémenter le code pour envoyer le message
            val coach = selectedCoach
            val text = message.text

        }) {
            Text("Envoyer")
        }
    }
}

@Preview
@Composable
fun SendMessagePreview() {
    sendMessage()
}