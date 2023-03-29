package com.example.newsappcompose.view


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newsappcompose.graphs.Graph
import com.example.newsappcompose.ui.theme.custemPink


@Composable
fun SecondeSplashScreen(navController: NavHostController){

    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        //For LottieAnimation

        //val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets2.lottiefiles.com/packages/lf20_2LdLki.json"))
        //LottieAnimation(composition = composition, iterations =LottieConstants.IterateForever )

        Spacer(modifier = Modifier.padding(3.dp))

        //For Text
        val preamble = "You have come to the right place to learn the latest and accurate news. Come in."
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 5.dp, end = 5.dp)
            .width(200.dp)
            , text = preamble,
            fontSize = 15.sp,
            textAlign = TextAlign.Center
            )

        Spacer(modifier = Modifier.padding(5.dp))


        //For button
        Button(onClick = {
            navController.popBackStack()
            navController.navigate(Graph.HOME)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = custemPink),
            shape = CutCornerShape(10.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 30.dp,
                pressedElevation = 25.dp,
                disabledElevation = 0.dp
            ),
            modifier = Modifier
                .size(width = 150.dp, height = 35.dp)
        ) {
            Text(text = "Continue",
                color = Color.White)
        }

    }

}
//For Preview
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SecondeSplashScreen()
}

 */