package com.example.newsappcompose.graphs


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.newsappcompose.view.FirstSplashScreen
import com.example.newsappcompose.view.SecondeSplashScreen


fun NavGraphBuilder.authNavGraph(navController : NavHostController){
        navigation(
            route = Graph.AUTHENTICATION,
            startDestination = AuthScreen.First.route
        ){
            composable(route = AuthScreen.First.route) {

                FirstSplashScreen(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(AuthScreen.Seconde.route)
                    })
            }
            composable(route =AuthScreen.Seconde.route ){
                SecondeSplashScreen(navController = navController)
            }
        }
}


sealed class AuthScreen (val route: String){
    object First : AuthScreen(route = "LOGIN")
    object Seconde : AuthScreen(route = "Seconde_Screen")
}