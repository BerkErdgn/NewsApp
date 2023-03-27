package com.example.newsappcompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.newsappcompose.graphs.Graph
import com.example.newsappcompose.model.Article
import com.example.newsappcompose.ui.theme.customGrey
import com.example.newsappcompose.viewmodel.HomeViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp



@Composable
fun NewsList(navController: NavHostController,viewModel: HomeViewModel = hiltViewModel()){
    val articleList by remember {viewModel.newsList}
    val errorMessage by remember {viewModel.errorMessage}
    val isLoading by remember {viewModel.isLoading}

    NewsListView(articles = articleList, navController = navController)

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        if (isLoading){
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if (errorMessage.isNotEmpty()){
            RetryView(error = errorMessage) {
                viewModel.loadNews()
            }
        }

    }

}


@Composable
fun NewsListView(articles:List<Article>,navController: NavHostController){
    LazyColumn(contentPadding = PaddingValues(5.dp)){
        items(articles){ article ->
            NewsRow(navController = navController, article = article)
        }
    }

}

@Composable
fun NewsRow(navController: NavHostController, article : Article){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = customGrey)
            .clickable {
                navController.navigate(Graph.DETAILS)
            }
    ) {
        Image(painter = rememberImagePainter(data = article.urlToImage),
            contentDescription = "Image",
            modifier = Modifier
                .size(150.dp, 150.dp)
                .clip(RectangleShape)
                .padding(2.dp)
        )
        Column {
            Text(text = article.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .padding(2.dp),
            fontWeight = FontWeight.Bold)

            Text(text = article.content,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(2.dp),
                fontWeight = FontWeight.Bold)

            Text(text = article.author,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(2.dp),
                fontWeight = FontWeight.ExtraLight)

        }
    }

}


@Composable
fun RetryView(error:String, onRetry: () -> Unit){

    Column {
        Text(error, color = Color.Red, fontSize = 20.sp)

        Button(onClick = {
            onRetry
        }, modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(text = "Retry")
        }
    }

}

