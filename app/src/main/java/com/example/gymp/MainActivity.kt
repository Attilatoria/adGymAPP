package com.example.gymp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private lateinit var users: List<User>
private lateinit var appDatabase: AppDatabase
private lateinit var userDao: UserDao
var userId: Int? = null

class MainActivity : ComponentActivity() {
    
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDatabase = AppDatabase.getInstance(this)
        userDao = appDatabase.userDao()

        GlobalScope.launch {
             users = userDao.getAll()
        }

        setContent {
            AppNavigator(appDatabase)
        }
    }
}


@Composable
fun Greeting(navController: NavController, appDatabase: AppDatabase) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userFound = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Champ d'entrée pour l'email
            TextField(
                value = email,
                onValueChange = { email = it },
                label =  { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )

            // Champ d'entrée pour le mot de passe
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )

            // Bouton pour soumettre les informations
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {

                        // Vérifie les informations d'identification
                        val user = users.find { it.Email == email && it.Password == password }
                        if (user != null) {
                            // Utilisateur trouvé, naviguer vers la page principale
                            userFound.value = true

                            navController.navigate("pagep")



                                GlobalScope.launch {
                                    // Once the user is authenticated, retrieve the user's ID
//                                     userId = userDao.getUserById(user.id)

                                    userId = user?.id
                                }
                        } else {
                            // Informer l'utilisateur que les informations d'identification sont incorrectes
                            userFound.value = false
                            errorMessage.value = "No user found."
                        }
                    },

                    modifier = Modifier.width(200.dp),
                ) {
                    Text("Login", color = Color.White)
                }

                Button(
                    onClick = {
                        navController.navigate("detail")
                    },
                    modifier = Modifier.width(200.dp),
                ) {
                    Text(text = "Inscription", color = Color.White)
                }
            }

            // Affichage du message d'erreur
            if (errorMessage.value.isNotEmpty()) {
                Text(
                    text = errorMessage.value,
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}



