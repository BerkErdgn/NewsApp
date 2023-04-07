package com.example.newsappcompose.graphs


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsappcompose.AppNameText
import com.example.newsappcompose.BottomBarScreen
import com.example.newsappcompose.view.*

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            Column(modifier = Modifier.fillMaxSize()){
                AppNameText()
                NewsList(navController = navController)
            }


        }
        composable(route = BottomBarScreen.SEARCH.route) {
            Column(modifier = Modifier.fillMaxSize()){
                AppNameText()
                NewsSearchScreen(navController = navController)
            }


        }
        composable(route = BottomBarScreen.SAVE.route) {
            Column(modifier = Modifier.fillMaxSize()){
                AppNameText()
                savedNewsView(navController = navController)
            }

        }
        detailsNavGraph(navController =navController)
    }
}
fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = "details_graph/{title}"
    ) {
        composable(route = "details_graph/{title}", arguments = listOf(
            navArgument("title"){
                type = NavType.StringType
            }
        )){


            val title = remember {
                it.arguments?.getString("title")
            }
            println(title)
            detailView(

                content = title ?:"",
            )
        }

    }

}



