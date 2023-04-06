package com.example.newsappcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsappcompose.ui.theme.*

@OptIn(ExperimentalTextApi::class)
@Composable
fun AppNameText(){
    val gradientColors = listOf(customRed, custemPink, customLightBlur, customOrange ,customBlue)

        Text(text = "News App",
            fontSize = 30.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(15.dp),

            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )

}

