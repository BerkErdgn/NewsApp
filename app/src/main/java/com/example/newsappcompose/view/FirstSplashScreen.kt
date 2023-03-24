package com.example.newsappcompose.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newsappcompose.graphs.Graph

@Composable
fun FirstSplashScreen(onClick: () -> Unit){

    Column(modifier = Modifier
        .fillMaxWidth()) {

        Text(text = "merhaba",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold,)

        Text(
            modifier = Modifier
                .clickable {
                    onClick()
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

}