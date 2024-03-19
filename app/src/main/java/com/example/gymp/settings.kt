package com.example.gymp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun settings(navController: NavController, userDao: UserDao) {
    val user = users.find { it.id == userId }

    var updatedFirstName by remember { mutableStateOf(user?.Firstname ?: "") }
    var updatedLastName by remember { mutableStateOf(user?.Lastname ?: "") }
    var updatedEmail by remember { mutableStateOf(user?.Email ?: "") }
    var updatedPassword by remember { mutableStateOf(user?.Password ?: "") }

    var showDialog by remember { mutableStateOf(false) }

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
            //quatrieme partie
            Text(
                text = "Password: ${user?.Password ?: ""}",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            // Modifier le profil
            Button(onClick = { showDialog = true }) {
                Text(text = "Update Profile")
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            // Logout
            Button(onClick = { navController.navigate("main") }) {
                Text(text = "Logout")
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Update Profile") },
                confirmButton = {
                    // Modifier le profil
                    Button(
                        onClick = {
                            GlobalScope.launch {
                                // Mettre à jour les informations de l'utilisateur dans la base de données
                                user?.let {
                                    userDao.updateUser(
                                        it.copy(
                                            Firstname = updatedFirstName,
                                            Lastname = updatedLastName,
                                            Email = updatedEmail,
                                            Password = updatedPassword
                                        )
                                    )
                                }
                            }
                            showDialog = false
                        }
                    ) {
                        Text("Save")
                    }

                },
                dismissButton = {
                    Button(
                        onClick = { showDialog = false }
                    ) {
                        Text("Cancel")
                    }
                },
                text = {
                    Column {
                        TextField(
                            value = updatedFirstName,
                            onValueChange = { updatedFirstName = it },
                            label = { Text("First Name") }
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        TextField(
                            value = updatedLastName,
                            onValueChange = { updatedLastName = it },
                            label = { Text("Last Name") }
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        TextField(
                            value = updatedEmail,
                            onValueChange = { updatedEmail = it },
                            label = { Text("Email") }
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        TextField(
                            value = updatedPassword,
                            onValueChange = { updatedPassword = it },
                            label = { Text("Password") }
                        )
                    }
                }
            )
        }
    }
}
