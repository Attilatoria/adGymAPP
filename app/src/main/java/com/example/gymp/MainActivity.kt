package com.example.gymp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appDatabase = AppDatabase.getInstance(this)

        setContent {
            AppNavigator(appDatabase)
        }
    }
}



@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Greeting(navController: NavController, appDatabase: AppDatabase) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val userDao = appDatabase.userDao()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            // Champ d'entrée pour l'email
            TextField(
                value = email,
                onValueChange = { email = it },
                label =  {"Email"} ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // Champ d'entrée pour le mot de passe
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { "Password" },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Row {
                // Bouton pour soumettre les informations

                Button(
                    onClick = {
                        GlobalScope.launch {
                            // Récupérer tous les utilisateurs de la base de données
                            val users = userDao.getAll()

                            // Vérifier les informations d'identification
                            val userFound =
                                users.find { it.Email == email && it.Password == password }

                            if (userFound != null) {
                                // Utilisateur trouvé, naviguer vers la page principale
                                navController.navigate("pagep")
                            } else {
                                navController.navigate("pagep")
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                ) {
                    Text(text = "connexion")
                }

                Spacer(modifier = Modifier.padding(60.dp))

                // Bouton pour s'enregistrer
                Button(
                    onClick = {
                        navController.navigate("detail")
                    }
                ) {
                    Text(text = "Inscription")
                }
            }

        }
    }
}


