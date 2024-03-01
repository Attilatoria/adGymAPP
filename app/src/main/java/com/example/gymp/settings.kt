package com.example.gymp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

//@Composable
//fun SettingsScreen(navController: NavController, viewModel: ViewModel) {
//    val currentUser by viewModel.currentUser
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Name: ${currentUser?.Firstname} ${currentUser?.Lastname}")
//        Text("Email: ${currentUser?.Email}")
//        Text("Password: ${currentUser?.Password}")
//
//        Button(onClick = {
//            // Naviguer vers l'écran de modification des informations
//            navController.navigate("editUserInfo")
//        }) {
//            Text("Edit Information")
//        }
//    }
//}
