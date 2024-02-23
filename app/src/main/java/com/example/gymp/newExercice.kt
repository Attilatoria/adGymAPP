package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun exercice(){
    var nameExercice by remember { mutableStateOf("") }
    Column {
        TextField(value = nameExercice, onValueChange = {nameExercice = it}, label = {"Exercice name"} )
        Spacer(modifier = Modifier.padding(12.dp))

        DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
            DropdownMenuItem(text = { "" }, onClick = { /*TODO*/ })
        }
    }
}
