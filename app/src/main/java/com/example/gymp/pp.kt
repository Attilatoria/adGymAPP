package com.example.gymp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun pageP(navController: NavController){
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)) {
            Row {
                IconButton( onClick = { navController.navigate("main") }) {
                    Image(painter = painterResource(id = R.drawable.home), contentDescription = "home", modifier = Modifier.size(50.dp))
                }
                Spacer(modifier = Modifier.padding(10.dp))

                IconButton(onClick = { navController.navigate("newe") }) {
                    Image(painter = painterResource(id = R.drawable.plus), contentDescription = "newexercice", modifier = Modifier.size(50.dp))
                }
                Spacer(modifier = Modifier.padding(10.dp))
                IconButton(onClick = { navController.navigate("folow") }) {
                    Image(painter = painterResource(id = R.drawable.goal), contentDescription = "objectif", modifier = Modifier.size(50.dp))
                }
                Spacer(modifier = Modifier.padding(10.dp))
                IconButton(onClick = { navController.navigate("set") }) {
                    Image(painter = painterResource(id = R.drawable.setting), contentDescription = "Settings",modifier = Modifier.size(50.dp))
                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }

//        Spacer(modifier = Modifier.padding(10.dp).background(color = Color.Blue))

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .background(color = Color.Black))

        {
            item {
                Text(
                    text = "Arm exercise",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.arm1),
                    contentDescription = "ExerciceArm1"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.arm2),
                    contentDescription = "ExerciceArm2"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.arm3),
                    contentDescription = "ExerciceArm3"
                )

                Spacer(modifier = Modifier.padding(10.dp))

////////////////////////////////////////// EXERCICE FOR THE BACK /////////////////////////////////////////
                Text(
                    text = "Back exercise",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.oip_3),
                    contentDescription = "ExerciceBack1"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.dos2),
                    contentDescription = "ExerciceArm2"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.dos3),
                    contentDescription = "ExerciceArm3"
                )

                Spacer(modifier = Modifier.padding(10.dp))

////////////////////////////////////////// EXERCICE FOR THE SHOULDER /////////////////////////////////////////
                Text(
                    text = "Shoulder exercise",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.shoulder1),
                    contentDescription = "ExerciceBack1"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.shoulder2),
                    contentDescription = "ExerciceArm2"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.shoulder3),
                    contentDescription = "ExerciceArm3"
                )

                Spacer(modifier = Modifier.padding(10.dp))

////////////////////////////////////////// EXERCICE FOR THE ABS /////////////////////////////////////////
                Text(
                    text = "Abs exercise",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.abs1),
                    contentDescription = "ExerciceBack1"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.abs2),
                    contentDescription = "ExerciceArm2"
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.abs3),
                    contentDescription = "ExerciceArm3"
                )

                Spacer(modifier = Modifier.padding(10.dp))

            }
        }
    }
}

