package com.example.newsappcompose.view

import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition


@Composable
fun FirstSplashScreen(onClick: () -> Unit){

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 60.dp)){

        //For after 4 second continues secondScreen
        val timer  = object: CountDownTimer(4000,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                onClick()
            }

        }
        timer.start()

        //For LottieAnimation
       val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://assets4.lottiefiles.com/private_files/lf30_cbizhsdy.json"))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever )


        

    }

}