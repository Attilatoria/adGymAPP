package com.example.gymp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Menu(navController)


        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5DC)),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            item {
                Text(
                    text = "Arm exercise",
                    color = Color.Black,
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
                    color = Color.Black,
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
                    color = Color.Black,
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
                    color = Color.Black,
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

