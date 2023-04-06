package com.example.newsappcompose.graphs


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.newsappcompose.view.FirstSplashScreen
import com.example.newsappcompose.view.SecondSplashScreen



fun NavGraphBuilder.authNavGraph(navController : NavHostController){
        navigation(
            route = Graph.AUTHENTICATION,
            startDestination = AuthScreen.First.route
        ){
            composable(route = AuthScreen.First.route) {

                FirstSplashScreen(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(AuthScreen.Second.route)
                    })
            }
            composable(route =AuthScreen.Second.route ){
                SecondSplashScreen(navController = navController)
            }
        }
}


sealed class AuthScreen (val route: String){
    object First : AuthScreen(route = "FIRS")
    object Second : AuthScreen(route = "SECOND")
}