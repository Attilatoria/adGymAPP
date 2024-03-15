package com.example.gymp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SendMessage(navController : NavController) {
    var selectedCoach by remember { mutableStateOf("Choose the coach") }
    var message by remember { mutableStateOf(TextFieldValue()) }
    var menuExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Menu(navController)
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Choose the coach",
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clickable {
                    menuExpanded = true
                }
        )

        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = { menuExpanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            listOf("Zinedine Zidane", "Sir Ferguson", "Ancelotti").forEach { coach ->
                DropdownMenuItem(
                    onClick = {
                        selectedCoach = coach
                        menuExpanded = false
                    },
                    interactionSource = remember { MutableInteractionSource() },
                    text = {Text(coach)}
                )
            }
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))

        TextField(
            value = message.text,
            onValueChange = { message = message },
            singleLine = false,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Your message") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val coach = selectedCoach
                val text = message.text
            }
        ) {
            Text("Send")
        }
    }
}


