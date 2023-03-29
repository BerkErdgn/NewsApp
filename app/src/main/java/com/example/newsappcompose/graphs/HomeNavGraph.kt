package com.example.newsappcompose.graphs


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.newsappcompose.BottomBarScreen
import com.example.newsappcompose.view.NewsDetailsScreen
import com.example.newsappcompose.view.NewsList
import com.example.newsappcompose.view.ScreenContent
import com.example.newsappcompose.viewmodel.HomeViewModel


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            NewsList(navController = navController)

        }
        composable(route = BottomBarScreen.SEARCH.route) {
            NewsList(navController = navController)
        }
        composable(route = BottomBarScreen.SAVE.route) {
            ScreenContent(
                name = BottomBarScreen.SAVE.route,
                onClick = { }
            )
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            NewsDetailsScreen()
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
}