package com.example.gymp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun settings(navController: NavController,userDao: UserDao) {
    val user = users.find { it.id == userId }

    Column {


        Menu(navController)
        Spacer(modifier = Modifier.padding(vertical = 20.dp))

        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color(0xFFF5F5DC)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Première partie
            Text(
                text = "First Name: ${user?.Firstname ?: ""}",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            // Deuxième partie
            Text(
                text = "Last Name: ${user?.Lastname ?: ""}",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            // Troisième partie
            Text(
                text = "Email: ${user?.Email ?: ""}",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            //Logout
            Button(onClick = { navController.navigate("main")}) {
                Text(text = "Logout")
            }
        }
    }
}


