package com.example.newsappcompose.graphs


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsappcompose.BottomBarScreen
import com.example.newsappcompose.model.Article
import com.example.newsappcompose.view.*
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
            NewsSearchScreen(navController = navController)

        }
        composable(route = BottomBarScreen.SAVE.route) {
            ScreenContent(
                name = BottomBarScreen.SAVE.route,
                onClick = { }
            )
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



/*

 */

/*
fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = "news_detail_screen/{author}/{content}/{publishedAt}/{url}/{title}/{urlToImage}"
    ) {
        composable(route = "news_detail_screen/{author}/{content}/{publishedAt}/{url}/{title}/{urlToImage}", arguments = listOf(
            navArgument("author"){
                type = NavType.StringType
            },
            navArgument("content"){
                type = NavType.StringType
            },
            navArgument("publishedAt"){
                type = NavType.StringType
            },
            navArgument("title"){
                type = NavType.StringType
            },
            navArgument("url"){
                type = NavType.StringType
            },
            navArgument("urlToImage"){
                type = NavType.StringType
            }

        )){
            val author = remember {
                it.arguments?.getString("author")
            }

            val content = remember {
                it.arguments?.getString("content")
            }

            val publishedAt = remember {
                it.arguments?.getString("publishedAt")
            }

            val url = remember {
                it.arguments?.getString("url")
            }

            val title = remember {
                it.arguments?.getString("title")
            }



            val urlToImage = remember {
                it.arguments?.getString("urlToImage")
            }


            detailView(
                author = author ?: "",
                content = content ?:"",
                publishedAt = publishedAt ?:"",
                title = title ?:"",
                url = url ?:"",
                urlToImage = urlToImage ?:"",
                navController = navController
            )



        }
    }

}

 */


