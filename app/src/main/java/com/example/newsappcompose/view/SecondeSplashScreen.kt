package com.example.newsappcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newsappcompose.graphs.AuthScreen
import com.example.newsappcompose.graphs.Graph

@Composable
fun SecondeSplashScreen(navController: NavHostController){

    Text(
        modifier = Modifier
            .clickable {
                navController.popBackStack()
                navController.navigate(Graph.HOME)
            }
            .background(color = Color.Blue)
            .padding(start = 5.dp, top = 8.dp, bottom = 15.dp)
            // .fillMaxSize(0.5f)
            .width(200.dp)
        ,text = "Devam",
        color = Color.Red,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}