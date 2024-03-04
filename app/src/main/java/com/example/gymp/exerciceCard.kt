package com.example.gymp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


var nameExercice: String? = null
var selectedBodyPart: String? = null
var trainingTime: String? = null
var selectedDate: String? = null
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciceCard(
    name: String,
    bodyPart: String,
    time: String,
    date: String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Exercice name: $name")
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Body part: $bodyPart")
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Training time: $time minutes")
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Date: $date")
    }
}