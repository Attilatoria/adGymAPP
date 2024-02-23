package com.example.gymp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun pageP(navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Blue)){
        Row {
            IconButton( onClick = { navController.navigate("main") }) {
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "home", modifier = Modifier.size(50.dp))
            }
            Spacer(modifier = Modifier.padding(10.dp))
            IconButton(onClick = { navController.navigate("") }) {
                Image(painter = painterResource(id = R.drawable.plus), contentDescription = "addExercice", modifier = Modifier.size(50.dp))

            }
            Spacer(modifier = Modifier.padding(10.dp))
            IconButton(onClick = { navController.navigate("") }) {
                Image(painter = painterResource(id = R.drawable.goal), contentDescription = "objectif", modifier = Modifier.size(50.dp))

            }
            Spacer(modifier = Modifier.padding(10.dp))
            IconButton(onClick = { navController.navigate("") }) {
                Image(painter = painterResource(id = R.drawable.setting), contentDescription = "Settings",modifier = Modifier.size(50.dp))

            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }

}

