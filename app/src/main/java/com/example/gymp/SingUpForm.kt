package com.example.gymp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun singIN(navController: NavController, appDatabase: AppDatabase) {
    var nom by remember { mutableStateOf("") }
    var prenom by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }

    val userDao = appDatabase.userDao()

    Button(onClick = { navController.navigate("main") }) {
        Text(text = "Back")
    }
    Spacer(modifier = Modifier.padding(30.dp))


    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.padding(30.dp))
            TextField(
                value = nom,
                onValueChange = { nom = it },
                label = { Text("Nom") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = prenom,
                onValueChange = { prenom = it },
                label = { Text("Prénom") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = selectedDate,
                onValueChange = { selectedDate = it },
                label = { Text("date of birth (dd-mm-yyyy)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mot de passe") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )


            // Bouton pour soumettre les informations
            Button(
                onClick = {

                    val user = User(
                        Firstname = nom,
                        Lastname = prenom,
                        Email = email,
                        Password = password,
                        Birthday = selectedDate
                    )
                    GlobalScope.launch{
                    userDao.insert(user)
                    }
                     nom = ""
                     prenom = ""
                     email = ""
                     password = ""
                     selectedDate =""

                },
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Text(text = "Save")
            }
        }
    }
}

