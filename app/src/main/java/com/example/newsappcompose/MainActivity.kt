package com.example.newsappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappcompose.graphs.Graph
import com.example.newsappcompose.graphs.RootNavigationGraph
import com.example.newsappcompose.graphs.detailsNavGraph
import com.example.newsappcompose.ui.theme.NewsAppComposeTheme
import com.example.newsappcompose.view.NewsList
import com.example.newsappcompose.view.ScreenContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsAppComposeTheme {
                RootNavigationGraph(navController =  rememberNavController())

            }
        }
    }
}

