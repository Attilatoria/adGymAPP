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
fun settings(navController: NavController) {
    Column {


//        Button(onClick = { navController.navigate("pagep") }) {
//            Text(text = "Back")
//        }
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
                text = "First Name: ${userId?.Firstname ?: ""}",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            // Deuxième partie
            Text(
                text = "Last Name: ${userId?.Lastname ?: ""}",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            // Troisième partie
            Text(
                text = "Email: ${userId?.Email ?: ""}",
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


//@Composable
//fun CustomDialog() {
//    var showDialog by remember { mutableStateOf(false) }
//    var textFieldValue by remember { mutableStateOf("") }
//
//    if (showDialog) {
//        AlertDialog(
//            onDismissRequest = { showDialog = false },
//            title = { Text("Update") },
//            text = {
//                Column {
//                    TextField(
//                        value = textFieldValue,
//                        onValueChange = { textFieldValue = it },
//                        label = { Text("Enter something") }
//                    )
//                }
//            },
//            confirmButton = {
//                Button(onClick = {
//                    showDialog = false
//                }) {
//                    Text("OK")
//                }
//            },
//            dismissButton = {
//                Button(onClick = { showDialog = false }) {
//                    Text("Cancel")
//                }
//            },
//            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
//        )
//    }
//    Button(
//        onClick = { showDialog = true },
//        modifier = Modifier.width(100.dp)
//    ) {
//        Text("Update", color = Color.White)
//    }
//}
